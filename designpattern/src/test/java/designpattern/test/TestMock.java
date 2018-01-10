package designpattern.test;

import junit.framework.Assert;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;

import com.designpattern.example.bridgepattern.GenericDao;
import com.designpattern.example.bridgepattern.JDBCTemplate;
import com.designpattern.example.bridgepattern.JDBCTemplateImpl;
import com.designpattern.example.bridgepattern.PersonEntity;
import com.designpattern.example.bridgepattern.PersonGenericDao;

public class TestMock {

	/*@Mocked
	private PersonGenericDao ;*/

	
	@Test
	public void test(@Mocked final  PersonGenericDao personDao) {
		new NonStrictExpectations() {
			{
				boolean mergeEntity = personDao.mergeEntity((PersonEntity)any);
				result = false;
				
			}
		};
		
		final JDBCTemplate<PersonEntity> jdbcTemplateImpl = new JDBCTemplateImpl<PersonEntity>();
		final GenericDao personGenericDao = new PersonGenericDao(jdbcTemplateImpl);
		final PersonEntity personEntity = new PersonEntity();
		personEntity.setName("Cog");
		personEntity.setDept("CSE");
		personEntity.setUser("Admin");		
		boolean mergeEntity = personGenericDao.mergeEntity(personEntity);
		System.out.println(mergeEntity);
		Assert.assertFalse(mergeEntity);
		
	}
}
