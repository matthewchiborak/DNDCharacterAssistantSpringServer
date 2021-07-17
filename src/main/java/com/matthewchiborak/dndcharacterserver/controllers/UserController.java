package com.matthewchiborak.dndcharacterserver.controllers;

import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matthewchiborak.dndcharacterserver.model.User;
import com.matthewchiborak.dndcharacterserver.model.Userdb;
import com.matthewchiborak.dndcharacterserver.repository.UserRepository;
import com.matthewchiborak.dndcharacterserver.security.JwtUtil;
import com.matthewchiborak.dndcharacterserver.security.PasswordHandler;

@RestController
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	private JwtUtil jwt = new JwtUtil();
	private PasswordHandler ph = new PasswordHandler();
	
	@CrossOrigin
	@PostMapping("user")
	public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
					
		Userdb userFromDb = userRepository.findByUsername(username);
	
		if(userFromDb != null) {
			try {
				byte[] hashedPassword = ph.getHashedPassword(pwd, decodeHexString(userFromDb.getSalt()));
				
				if(userFromDb.getPassword().equals(bytesToHex(hashedPassword))) {
					String token = jwt.getJWTToken(username);
					User user = new User();
					user.setUsername(username);
					user.setToken(token);	
					
					return new ResponseEntity<>(user, HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}		
	}
	
	//////////////////////////////
	
	private void storeANewUser(String username, String password) {
		byte[] theSalt = ph.generateSalt();
		try {
			byte[] hashedPassword = ph.getHashedPassword(password, theSalt);
			

			Userdb newUser = new Userdb();
			newUser.setUsername(username);
			newUser.setSalt(bytesToHex(theSalt));
			newUser.setPassword(bytesToHex(hashedPassword));
			
			userRepository.insert(newUser);
			
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	
	public byte hexToByte(String hexString) {
	    int firstDigit = toDigit(hexString.charAt(0));
	    int secondDigit = toDigit(hexString.charAt(1));
	    return (byte) ((firstDigit << 4) + secondDigit);
	}

	private int toDigit(char hexChar) {
	    int digit = java.lang.Character.digit(hexChar, 16);
	    if(digit == -1) {
	        throw new IllegalArgumentException(
	          "Invalid Hexadecimal Character: "+ hexChar);
	    }
	    return digit;
	}
	public byte[] decodeHexString(String hexString) {
	    if (hexString.length() % 2 == 1) {
	        throw new IllegalArgumentException(
	          "Invalid hexadecimal String supplied.");
	    }
	    
	    byte[] bytes = new byte[hexString.length() / 2];
	    for (int i = 0; i < hexString.length(); i += 2) {
	        bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
	    }
	    return bytes;
	}

}
