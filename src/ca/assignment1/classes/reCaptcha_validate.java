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
*      Description:           Code to connect to google reCaptcha servers
 ******************************************************************************** */

package ca.assignment1.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;

public class reCaptcha_validate {
	public static boolean check_reCaptcha (String response) throws Exception {
		
		String request = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6LdpNb0UAAAAAB2heT3JXQUudCK6IfAbsc4aQYff"
	            + "&response=" + response; 
		URL url = new URL(request+params);
		final java.io.InputStream inputstream = url.openStream();
        BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
        StringBuilder stringbuilder = new StringBuilder();
        int tmp = bufferreader.read();
        while (tmp != -1) {
            stringbuilder.append((char)tmp);
            tmp =  bufferreader.read();
        }
        String text = stringbuilder.toString();
        JSONObject json = new JSONObject(text);
        inputstream.close();
        return json.getBoolean("success");// */
		//return true;
    }
}
