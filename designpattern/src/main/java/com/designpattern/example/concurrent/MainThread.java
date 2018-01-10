package com.designpattern.example.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainThread {

	static Object b = new Object();
	
	public static void main(String[] args) {
		
		final List<String> aList = new ArrayList<String>();
		List<String> synchronizedList = Collections.synchronizedList(aList);
		
		aList.add("Java");
		aList.add("Main");
		aList.add("Thread");
		aList.add("Synchonized");
		aList.add("Access");
		aList.add("ArrayList");
		
		final ArrayListConcur arrayListConcur = new ArrayListConcur(b,synchronizedList);
		final ArrayListRemove arrayListRemove = new ArrayListRemove(synchronizedList);
		final Thread thread1 = new Thread(arrayListConcur);
		final Thread thread2 = new Thread(arrayListRemove);
		
		thread1.start();
		thread2.start();
		
		//b.notifyAll();
		
	}
	
}
