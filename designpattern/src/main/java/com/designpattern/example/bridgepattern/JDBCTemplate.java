package com.designpattern.example.bridgepattern;

public interface JDBCTemplate<E extends Audit> {
	
		public boolean merge(E entity);
		public void get(E entity);
		
}
