package com.designpattern.example.compositepattern;

import java.util.ArrayList;
import java.util.List;

public class SendAcknowledgeImpl implements SendAcknowledge{

	final List<SendAcknowledge> message =  new ArrayList<SendAcknowledge>();
	public void sendMessage(String e) {

			for(SendAcknowledge ack : message){
				ack.sendMessage(e);
			}
	}

	public void add(SendAcknowledge ack){
		message.add(ack);
	}
	
}
