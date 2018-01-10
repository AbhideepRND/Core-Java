package com.designpattern.example.bridgepattern;

public class PersonGenericDao extends GenericDao<PersonEntity>{

	public PersonGenericDao(JDBCTemplate<PersonEntity> template) {
		super(template);
	}

	@Override
	public boolean mergeEntity(PersonEntity entity) {
		return template.merge(entity);
		
	}

	
	

	
}
