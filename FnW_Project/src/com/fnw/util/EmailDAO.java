package com.fnw.util;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

public class EmailDAO {
	
	public int send(HttpServletRequest request, String email) {
		int result=0;
		String host     = "smtp.naver.com";
		  final String user   = "library_4";
		  final String password  = "gudwns93";
		  String to     = email;
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
		   message.setSubject("FnW 회원가입 인증 메일");
		   
		   // Textc 
		   Random r = new Random();
		   String str = String.valueOf(r.nextInt(9));
		   str = str + String.valueOf(r.nextInt(9));
		   str = str + String.valueOf(r.nextInt(9));
		   str = str + String.valueOf(r.nextInt(9));
		   str = str + String.valueOf(r.nextInt(9));
		   str = str + String.valueOf(r.nextInt(9));
		   
		   String mes = "인증번호 :"+str;
		   request.getSession().setAttribute("check", str);
		   message.setText(mes); //보내는 내용

		   // send the message
		   Transport.send(message);
		   System.out.println("message sent successfully...");
		   result=1;

		  } catch (MessagingException e) {
		   e.printStackTrace();
		   result=0;
		  }
		  return result;
		  
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
