package com.fnw.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class EmailDAO {
	public void send(HttpServletRequest request, String email) {
		String host     = "smtp.naver.com";
		  final String user   = "library_4";
		  final String password  = "gudwns93";
		  String to     = email;
		  System.out.println("ss");
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");

		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(user, password);
		   }
		  });

		  // Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		   // Subject
		   message.setSubject("FnW 인증 메일");
		   
		   // Textc 
		   String a = "a12s";
		   String mes = "인증번호 :"+a;
		   request.getSession().setAttribute("check", a);
		   message.setText(mes); //보내는 내용


		   // send the message
		   Transport.send(message);
		   System.out.println("message sent successfully...");

		  } catch (MessagingException e) {
		   e.printStackTrace();
		  }
	}
	
/*	 public static void main(String[] args) {
	
	  String host     = "smtp.naver.com";
	  final String user   = "library_4";
	  final String password  = "gudwns93";
	
	  String to     = "hjun1121@naver.com";
	
	  // Get the session object
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.auth", "true");
	
	  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	   protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(user, password);
	   }
	  });
	
	  // Compose the message
	  try {
	   MimeMessage message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(user));
	   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	
	   // Subject
	   message.setSubject("변경된 비밀번호");
	   
	   // Textc 
	   int a = 10;
	   String mes = "비밀번호"+a;
	  
	   mes = mes + "www.naver.com";
	   message.setText(mes);
	
	
	   // send the message
	   Transport.send(message);
	   System.out.println("message sent successfully...");
	
	  } catch (MessagingException e) {
	   e.printStackTrace();
	  }
	 }*/
}
