package ca.assignment1.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
import org.omg.CORBA.portable.InputStream;

public class reCaptcha_validate {
	public static boolean check_reCaptcha (String response) throws Exception {
		String url = "https://www.google.com/recaptcha/api/siteverify?secret=6LdpNb0UAAAAAB2heT3JXQUudCK6IfAbsc4aQYff"
	            + "&response=" + response;
		InputStream inputstream = (InputStream) new URL(url).openStream();
        BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream, Charset.forName("UTF-8")));
        StringBuilder stringbuilder = new StringBuilder();
        char tmp = (char) bufferreader.read();
        while (tmp != -1) {
            stringbuilder.append(tmp);
            tmp = (char) bufferreader.read();
        }
        String text = stringbuilder.toString();
        JSONObject json = new JSONObject(text);
        inputstream.close();
        return json.getBoolean("sucsess");// */
    }
}
