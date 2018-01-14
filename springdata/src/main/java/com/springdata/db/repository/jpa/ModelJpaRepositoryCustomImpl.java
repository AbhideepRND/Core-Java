package com.springdata.db.repository.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.springdata.db.model.Model;

public class ModelJpaRepositoryCustomImpl implements ModelJpaRepositoryCustom {

	@PersistenceContext(unitName = "derby")
	private EntityManager entitymanager;

	@Override
	public List<Model> getModelDetails() {
		final List<Model> resultList = entitymanager.createQuery("select l from Model l").getResultList();
		return resultList;

	}

}