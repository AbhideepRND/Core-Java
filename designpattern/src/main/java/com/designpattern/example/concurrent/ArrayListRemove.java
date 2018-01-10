package com.designpattern.example.concurrent;

import java.util.List;

public class ArrayListRemove implements Runnable{

	List<String> aList;
	
	public ArrayListRemove(List<String> aList) {
	this.aList = aList;
		
	}
	
	public void run() {
		String name = this.getClass().getName();
		System.out.println(name);
		
		for(int i =0; i<aList.size() ;i++){
			aList.remove(i);
		}
		
	}

	
}
