package com.designpattern.example.concurrent;

import java.util.Iterator;
import java.util.List;

public class ArrayListConcur implements Runnable {
	List<String> aList;
	Object obj;

	public ArrayListConcur(Object b, List<String> aList) {

		this.obj = b;
		this.aList = aList;
	}

	public void run() {

		String name = this.getClass().getName();
		System.out.println(name);
			synchronized (aList) {
				Iterator<String> iterator = aList.iterator();
				while (iterator.hasNext()) {
					
					System.out.println(iterator.next());
				}
			}
			
	}

}
