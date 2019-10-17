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
*      Description:           code for sending confirmation email 
 ******************************************************************************** */

package ca.assignment1.classes;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	private static String USER_NAME = "tech.know.pro.app";  
    private static String PASSWORD = "%#DYh9)$(0qww294e"; 
	public static void send_email(User user) throws Exception{
    	String to = user.getEmail();
    	String subject = "Registration";
        String body = "We have received your Registration to our website please for: " + user.getFirstname() + " " +user.getLastname(); 
        
        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", USER_NAME);
        properties.put("mail.smtp.password", PASSWORD);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USER_NAME));
        InternetAddress toAddress = new InternetAddress(to);
        message.addRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject(subject);
        message.setText(body);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", USER_NAME, PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        //transport.close();
        
	}
}
