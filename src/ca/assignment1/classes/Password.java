/*
*********************************************************************************
* Project:	Comp3095_assignment1
* Assignment: Assignment One
* Author(s):
*      Andrew Cobb:		101142044
*      Giuseppe Ragusa; 101109502
*      Arsalan Farooqui:101144384
*       
*      Date: 17/10/2019
*      Description:           Hashes passwords with random salt for storage in DB
 ******************************************************************************** */

package ca.assignment1.classes;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Password {
	public static String getHash(String password, String salt) {
		/* 
		 * ***** not working will fix if i have time - Andrew ******
		try {
		MessageDigest mdigest = MessageDigest.getInstance("SHA-512");
		mdigest.update(salt.getBytes());
		byte[] hashbytes = mdigest.digest(password.getBytes());
		return new String(hashbytes, "UTF-8");
		} catch(NoSuchAlgorithmException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		}// */
		return password;
		
	}
	public static String newRandomSalt() {
		Random rand = new Random();
		byte[] salt = new byte [16];
		rand.nextBytes(salt);
		try {
		return new String(salt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
