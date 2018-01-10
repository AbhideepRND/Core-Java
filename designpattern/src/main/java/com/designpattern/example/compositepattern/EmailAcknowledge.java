package com.designpattern.example.compositepattern;

public class EmailAcknowledge implements SendAcknowledge{

	public void sendMessage(String e) {
		System.out.println("email acknowledge "+e);
	}

	
		
}
