package com.designpattern.example.compositepattern;

public class SmsAcknowledge implements SendAcknowledge{

	public void sendMessage(String e) {
		System.out.println("sms acknowledge "+e);
	}

	
		
}
