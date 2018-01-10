package com.designpattern.example.inheritance;

import java.util.ArrayList;
import java.util.Iterator;

public class MainClass {

	public static void main(String[] args) {
		AClass aClass = new AClass();
		System.out.println(aClass.i);
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Hello");
		arrayList.add("Java");
		arrayList.add("World");
		Iterator<String> iterator = arrayList.iterator();
		while(iterator.hasNext()){
				String next = iterator.next();
				
				if(next.equals("Java")){
					iterator.remove();
					
				}
			
		}
		
	}
	
}
