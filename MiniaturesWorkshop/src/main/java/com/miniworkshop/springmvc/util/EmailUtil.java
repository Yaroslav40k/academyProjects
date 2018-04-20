package com.miniworkshop.springmvc.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	final static String adminEmail = "artist.yaroslav@gmail.com";
	final static String password = "Sunnyboy27artist.yaroslav";

	public static Session createSession() {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		final PasswordAuthentication passwordAuthentication = new PasswordAuthentication(adminEmail, password);
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return passwordAuthentication;
			}
		};
		Session session = Session.getInstance(properties, authenticator);

		return session;

	}

	public static String sendMessage(Session session, String senderName, String senderEmail, String to, String subject, String messageText) {

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail, senderName));
			message.addHeader("Content-Type", "text/HTML; charset=UTF-8");
			message.setSubject(subject, "UTF-8");
			// message.setText(messageText);
			message.setContent(messageText, "text/HTML; charset=UTF-8");
			message.getSentDate();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			System.out.println("Message is Ready");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Message sent";
	}

	/**
	 * Send message with attachment
	 * 
	 * @param session
	 * @param from
	 * @param to
	 * @param subject
	 * @param messageText
	 * @param PathToFile
	 * @return
	 */
	public String sendMessage(Session session, String customerName, String customerEmail, String to, String subject, String messageText, String PathToFile) {

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(customerEmail, customerName));
			message.addHeader("Content-Type", "text/HTML; charset=UTF-8");
			message.setSubject(subject, "UTF-8");
			// message.setText(messageText);
			// message.setContent(messageText, "text/HTML; charset=UTF-8");
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(messageText, "text/HTML; charset=UTF-8");
			Multipart multiPart = new MimeMultipart(bodyPart);
			// For file attachment

			bodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(PathToFile);
			bodyPart.setDataHandler(new DataHandler(source));
			bodyPart.setFileName(PathToFile);
			multiPart.addBodyPart(bodyPart);
			message.setContent(multiPart);
			message.getSentDate();
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			System.out.println("Message is Ready");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Message sent";
	}
}