package com.springdata.db.repository.jpa;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springdata.db.model.Location;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

	@Query(value = "from Location c where c.state like concat('%',:stateName,'%')")
	List<Location> findByStateLK(@Param("stateName") String stateName);

	// Or for like statement we need to pass the data as %data%

	List<Location> findByStateLike(String stateName);
	List<Location> findByCountryContaining(String stateName);
	Location findFirstByState(String stateName);
	Location findFirstByCountry(String stateName);

	/**
	 * 
	 * IF our state name is West Bengal then we can use the following function
	 * to retrieve data
	 * 
	 * We can also use findByStateStartingWith("We"); --> Like('We%')
	 * 
	 * We can also use findByStateEndingWith("gal"); --> Like('%gal')
	 * 
	 * We can also use findByStateEndingWith("Ben"); --> Like('%Ben%')
	 * 
	 */

	/**
	 * 
	 * Ignore Case in DSL --. Domain Specific Language
	 * 
	 * findByStateIgnoreCase("<Data>") --> UPPER(State) = UPPER(<DATA>)
	 * 
	 * findByStateStartingWithIgnoreCase("<Data>") --> UPPER(State) =
	 * UPPER(<DATA>%) --> Like operator
	 * 
	 */

	/**
	 * 
	 * Even for null or Not Null
	 *
	 * findByStateIsNull() --> state is Null
	 * findByStateIsNotNull() --> state not null
	 * findByStateNotNull() --> state not null
	 * 
	 */

	List<Location> findByStateNotNull();

	List<Location> findByStateIsNull();

	/**
	 * 
	 * To find the data in collection is jpa
	 * 
	 * findByStateIn(Collection<String> stateList)
	 * findByStateNotIn(Collection<String> stateList)
	 * 
	 */

	List<Location> findByStateIn(Collection<String> stateList);

	List<Location> findByStateNotIn(Collection<String> stateList);

	/**
	 * 
	 * Few more methods can be used in DSL
	 *
	 * Order by clause
	 * findByStateOrderByCountryAsc("<Data>")
	 * findByStateOrderByCountryDesc("<Data>")
	 *
	 * First, Top (Limit), Distinct clause
	 *
	 * findFirstByStateLike("%AI%)
	 * 
	 * findTop5ByStateLike("%AI%)
	 * 
	 * findDistinctManufactureByStateLike("%AI%)
	 * 
	 */

}
