package com.springdata.db.beanconfig.derby;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.db.config.JpaDerbyConfig;
import com.springdata.db.model.Location;
import com.springdata.db.model.Manufacturer;
import com.springdata.db.repository.jpa.LocationJpaRepository;
import com.springdata.db.repository.jpa.ManufactureJpaRepository;

@ContextConfiguration(classes = { JpaDerbyConfig.class })
@TransactionConfiguration(defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
public class LocationPersistenceDerbyTest {

	@Autowired
	private LocationJpaRepository locationRepo;

	@Autowired
	private ManufactureJpaRepository manufactureRepo;

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testinsertDataToLocation() {
		final Location location = new Location();
		location.setCountry("India");
		location.setState("West Bengal");
		final Location saveAndFlush = locationRepo.saveAndFlush(location);
		System.out.println(saveAndFlush.getId());
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testinsertDataToManufactore() {
		final Location findFirstByState = locationRepo.findFirstByState("West Bengal");
		final Manufacturer samManufacturer = new Manufacturer();
		samManufacturer.setAverageYearlySales(new BigDecimal(40000));
		final Calendar instance = Calendar.getInstance();
		instance.add(Calendar.YEAR, -10);
		System.out.println(instance);
		samManufacturer.setFoundedDate(instance.getTime());
		samManufacturer.setName("Sam");
		samManufacturer.setHeadquarters(findFirstByState);
		final Manufacturer ramManufacturer = new Manufacturer();
		ramManufacturer.setAverageYearlySales(new BigDecimal(40000));
		instance.add(Calendar.YEAR, -9);
		System.out.println(instance);
		ramManufacturer.setFoundedDate(instance.getTime());
		ramManufacturer.setName("Ram");
		ramManufacturer.setHeadquarters(findFirstByState);
		manufactureRepo.saveAndFlush(samManufacturer);
		manufactureRepo.saveAndFlush(ramManufacturer);
	}

	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public void testRetrieveLocationData() {
		final Location findFirstByState = locationRepo.findFirstByState("West Bengal");
		final List<Manufacturer> manufacturers = findFirstByState.getManufacturers();
		for (Manufacturer manu : manufacturers) {
			System.out.println(manu.getName());
		}

		final List<Location> findFirstByState2 = locationRepo.findByCountryContaining("Ind");
		Assert.assertEquals(4, findFirstByState2.size());

		final Location findFirstByState3 = locationRepo.findFirstByCountry("India");
		Assert.assertNotNull(findFirstByState3);
		
		final List<Location> findFirstByState4 = locationRepo.findByStateLike("%Bengal%");
		Assert.assertEquals(1, findFirstByState4.size());
		Assert.assertEquals(3, locationRepo.findByStateNotNull().size());
		Assert.assertEquals(1, locationRepo.findByStateIsNull().size());

		final List<String> asList = Arrays.asList("West Bengal", "Delhi");
		Assert.assertEquals(1, locationRepo.findByStateNotIn(asList).size());
		Assert.assertEquals(2, locationRepo.findByStateIn(asList).size());

	}

}