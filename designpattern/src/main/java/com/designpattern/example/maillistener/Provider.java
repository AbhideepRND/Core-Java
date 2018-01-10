package com.designpattern.example.maillistener;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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

public class Provider {
	private static final String HOST = "smtp.gmail.com";

	private static final String PORT = "465";

	public Provider() {
	}

	public void execute(String to, String from, String password, String subject, String body, String fileAttachment) {

		Properties properties = new Properties();

		// Debug or not true/false
		properties.put("mail.debug", "false");

		// the email account on gmail
		properties.put("mail.smtp.user", to);

		// gmail host details
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// enable authentication of STARTTLS
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", "587");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		properties.put("mail.smtp.starttls.enable", "true");

		Authenticator authenticator = new MyAuthenticator(from, password);

		Session session = Session.getInstance(properties, authenticator);

		try {

			Transport transport = session.getTransport("smtp");
			transport.connect();

			Message message = new MimeMessage(session);
			// Set from
			message.setFrom(new InternetAddress(from));

			// Set to
			InternetAddress[] address = { new InternetAddress(to) };
			message.setRecipients(Message.RecipientType.TO, address);

			// Set subject
			message.setSubject(subject);

			// Set time
			message.setSentDate(new Date());

			// Set content
			// In this example multipart of
			// part1 is email body
			// part2 is the attachement
			MimeBodyPart bodyPart1 = new MimeBodyPart();
			bodyPart1.setText(body);

			MimeBodyPart bodyPart2 = new MimeBodyPart();
			FileDataSource fileDataSource = new FileDataSource(fileAttachment);
			bodyPart2.setDataHandler(new DataHandler(fileDataSource));
			bodyPart2.setFileName(fileDataSource.getName());

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart1);
			multipart.addBodyPart(bodyPart2);
			message.setContent(multipart);

			// Set complete
			message.saveChanges();

			// Send the message
			transport.sendMessage(message, address);
			transport.close();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		Provider sendEmail = new Provider();

		String to = "abhideepbakshi@gmail.com";
		String from = "samtel09@gmail.com";
		String password = "sanjaypanday";
		String subject = "new Email. sent with java";
		String body = "Hi Geek,\n\nThis is the body of the email\n\nregards,\n\nJavaGuy";
		String fileAttachment = "c:/file.txt";

		sendEmail.execute(to, from, password, subject, body, fileAttachment);

		System.out.println("took: " + (System.currentTimeMillis() - start));

	}

}

class MyAuthenticator extends Authenticator {

	protected PasswordAuthentication passwordAuthentication;

	public MyAuthenticator(String user, String password) {
		this.passwordAuthentication = new PasswordAuthentication(user, password);
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}
}