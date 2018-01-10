package com.designpattern.example.bridgepattern;

public class MainBridgePattern {
	
	public static void main(String[] args) {
			
			MainBridgePattern mainBridgePattern = new MainBridgePattern();
			mainBridgePattern.callBridge();
	}
	
	public void callBridge(){
		final JDBCTemplate<PersonEntity> jdbcTemplateImpl = new JDBCTemplateImpl<PersonEntity>();
		final GenericDao personGenericDao = new PersonGenericDao(jdbcTemplateImpl);
		final PersonEntity personEntity = new PersonEntity();
		personEntity.setName("Cog");
		personEntity.setDept("CSE");
		personEntity.setUser("Admin");		
		personGenericDao.mergeEntity(personEntity);
	}
}
