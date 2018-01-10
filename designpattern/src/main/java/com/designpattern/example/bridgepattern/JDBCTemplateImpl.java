package com.designpattern.example.bridgepattern;

public class JDBCTemplateImpl<E extends Audit> implements JDBCTemplate<E> {

	public boolean merge(E entity) {
		System.out.println(entity.getUser());
		return true;

	}

	public void get(E entity) {
		System.out.println(entity.getUser());

	}

}
