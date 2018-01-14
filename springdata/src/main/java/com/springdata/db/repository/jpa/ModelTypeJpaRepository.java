package com.springdata.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springdata.db.model.ModelType;

@Repository
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {
	public ModelType findByNameLike(String modelName);

}
