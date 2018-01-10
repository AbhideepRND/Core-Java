package com.designpattern.example.compositepattern;

public class MainComposePattern {

	public static void main(String[] args) {
			final SendAcknowledgeImpl impl = new SendAcknowledgeImpl();
			SendAcknowledge sms = new SmsAcknowledge();
			SendAcknowledge email = new EmailAcknowledge();
			impl.add(email);
			impl.add(sms);
			impl.sendMessage("100 rs has been deducted");
			
			
	}
}
