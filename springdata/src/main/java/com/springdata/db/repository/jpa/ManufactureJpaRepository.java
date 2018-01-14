package com.springdata.db.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdata.db.model.Manufacturer;

public interface ManufactureJpaRepository extends JpaRepository<Manufacturer, Long> {

	public Manufacturer findByName(String manufactureName);

}
