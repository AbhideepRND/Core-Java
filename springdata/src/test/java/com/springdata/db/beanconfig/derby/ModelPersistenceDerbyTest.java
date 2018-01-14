package com.springdata.db.beanconfig.derby;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springdata.db.config.JpaDerbyConfig;
import com.springdata.db.model.Model;
import com.springdata.db.model.ModelType;
import com.springdata.db.repository.jpa.ManufactureJpaRepository;
import com.springdata.db.repository.jpa.ModelJpaRepository;
import com.springdata.db.repository.jpa.ModelTypeJpaRepository;

@ContextConfiguration(classes = { JpaDerbyConfig.class })
@TransactionConfiguration(defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
public class ModelPersistenceDerbyTest {

	@Autowired
	private ModelTypeJpaRepository modelTypeRepo;

	@Autowired
	private ManufactureJpaRepository manufactureRepo;

	@Autowired
	private ModelJpaRepository modelRepo;

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testinsertDataToModelType() {
		final ModelType modelType = new ModelType();
		modelType.setName("Spanish Gitar");
		modelTypeRepo.saveAndFlush(modelType);
		final ModelType electric = new ModelType();
		electric.setName("Electric");
		modelTypeRepo.saveAndFlush(electric);
	}

	@Test
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void testinsertDataToModel() {

		final ModelType findByNameLike = modelTypeRepo.findByNameLike("%Spanish%");
		final Model modelSam = new Model();
		modelSam.setFrets(10);
		modelSam.setName("Sam");
		modelSam.setManufacturer(manufactureRepo.findByName("Sam"));
		modelSam.setModelType(findByNameLike);
		modelSam.setPrice(new BigDecimal(1000));
		modelSam.setWoodType("Wood1");

		final Calendar instance = Calendar.getInstance();
		instance.add(Calendar.YEAR, -10);
		System.out.println(instance);
		modelSam.setYearFirstMade(instance.getTime());
		final Model modelRam = new Model();
		modelRam.setFrets(10);
		modelRam.setName("Ram");
		modelRam.setManufacturer(manufactureRepo.findByName("Ram"));
		modelRam.setModelType(findByNameLike);
		modelRam.setPrice(new BigDecimal(2000));
		modelRam.setWoodType("Wood2");
		instance.add(Calendar.YEAR, -9);
		System.out.println(instance);
		modelRam.setYearFirstMade(instance.getTime());
		modelRepo.saveAndFlush(modelSam);
		modelRepo.saveAndFlush(modelRam);

		final Model modelIndra = new Model();
		modelIndra.setFrets(10);
		modelIndra.setName("Indra");
		modelIndra.setManufacturer(manufactureRepo.findByName("Ram"));
		modelIndra.setModelType(modelTypeRepo.findByNameLike("%Electric%"));
		modelIndra.setPrice(new BigDecimal(2000));
		modelIndra.setWoodType("Wood2");
		final Calendar instance2 = Calendar.getInstance();
		instance2.add(Calendar.YEAR, -11);
		System.out.println(instance2);
		modelIndra.setYearFirstMade(instance2.getTime());
		modelRepo.saveAndFlush(modelIndra);

	}

	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public void testRetrieveModelDataOnDifferentCondition() {
		final List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual = modelRepo
				.findByPriceGreaterThanEqualAndPriceLessThanEqual(new BigDecimal(900), new BigDecimal(2100));
		for (Model mo : findByPriceGreaterThanEqualAndPriceLessThanEqual) {
			System.out.println(mo.getName());
		}

		final Calendar instance = Calendar.getInstance();
		instance.add(Calendar.YEAR, -11);
		System.out.println(instance.getTime());
		final List<Model> findByYearFirstMadeBefore = modelRepo.findByYearFirstMadeBefore(instance.getTime());

		for (Model mo : findByYearFirstMadeBefore) {
			System.out.println(mo.getName() + "----" + mo.getYearFirstMade());
		}

		final List<String> asList = Arrays.asList("Spanish Gitar", "Electric");
		final Calendar instance2 = Calendar.getInstance();
		instance2.add(Calendar.YEAR, -9);
		final List<Model> findByModelTypeInAndYearFirstMadeBefore = modelRepo
				.findByModelTypeNameInAndYearFirstMadeBefore(asList, instance2.getTime());
		for (Model mo : findByModelTypeInAndYearFirstMadeBefore) {
			System.out.println(mo.getName() + "----" + mo.getYearFirstMade());
		}

		final List<Model> findAllModelsByType = modelRepo.findAllModelsByType("Electric");
		Assert.assertEquals(1, findAllModelsByType.size());
	}

	@Test
	@Transactional(readOnly = true)
	public void paginationInModel() {

		final Sort sort = new Sort(Sort.Direction.ASC, "country");
		final Pageable pageRequest = new PageRequest(0, 2, sort);
		final Page<Model> searchModelsByType = modelRepo.searchModelsByType("Electric", pageRequest);
		Assert.assertEquals(1, searchModelsByType.getTotalElements());
		final List<Model> modelDetails = modelRepo.getModelDetails();
		Assert.assertEquals(3, modelDetails.size());
	}

}
