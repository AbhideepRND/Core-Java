package com.springdata.db.repository.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springdata.db.model.Model;

public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

	/**
	 * 
	 * We are can use the below method to retrieve information on Price
	 * attribute
	 * 
	 * 
	 * findByPriceLessThan() --> price<
	 * findByPriceLessThanEqual() --> price<=
	 * findByPriceGreaterThan() --> price>
	 * findByPriceGreaterThanEqual() --> price>=
	 * or between a range
	 * findByPriceGreaterThanEqualAndPriceLessThan(Low , High) 1200<Price<1900
	 *
	 * 
	 * 
	 */

	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

	/**
	 * 
	 * We can us the JPA data to find by date
	 * 
	 * findByYearFirstMadeBefore(date) --> YearFirstMade<date
	 * 
	 * findByYearFirstMadeAfter(date) --> YearFirstMade>date
	 * 
	 * findByYearFirstMadeBetween(startDate, endDate) --> YearFirstMade between
	 * startDate and endDate
	 * 
	 */

	List<Model> findByYearFirstMadeBefore(Date yearFirstMade);

	/**
	 * 
	 * We are use boolean to find out the data from database using Spring data
	 * JPA
	 *
	 * 
	 * findByActiveTrue() --> Active == True
	 * 
	 * findByActivefalse() --. Active == False
	 * 
	 * 
	 */

	/**
	 * 
	 * Even for null or Not Null
	 * 
	 * findByStateIsNull() --> state is Null
	 * 
	 * findByStateIsNotNull() --> state not null
	 * 
	 * findByStateNotNull() --> state not null
	 * 
	 */

	/**
	 *
	 * 
	 * 
	 * Now we are try to find out those modeltype are electric and spanish
	 * guiter
	 * 
	 * and made date is before
	 *
	 * 
	 * 
	 * findBy<ModelType><Name>In -> here the <ModelType> is the relational table
	 * and
	 * 
	 * <Name> is the attribute in the relational table
	 * 
	 * in conjunction we add YearFirstMadeBefore --> YearFirstMade is the
	 * attribute in Model
	 * 
	 */

	List<Model> findByModelTypeNameInAndYearFirstMadeBefore(List<String> modelType, Date beforeDate);

	/**
	 * 
	 * Use of name query in Spring Data JPA
	 *
	 * 
	 * 
	 * We need to declare the name of the method as the Named Queried
	 * 
	 * Like --> @NamedQuery(name="Model.findAllModelsByType",
	 * 
	 * query="select m from Model m where m.modelType.name = :name")
	 * 
	 * 
	 * 
	 * Here name of the method will be findAllModelsByType and param name will
	 * be 'name'
	 *
	 * 
	 * 
	 * or
	 * 
	 * we can pass the name of NamedQuery in @Query like
	 * 
	 * 
	 * 
	 * @Query(name="Model.findAllModelsByType")
	 * 
	 * 											public List<Model>
	 *                                          findAllModelsByType(@Param("name")
	 *                                          String name);
	 * 
	 */

	public List<Model> findAllModelsByType(@Param("name") String name);

	/**
	 * 
	 * Pagination and Sorting in Spring Data JPA
	 *
	 *
	 * 
	 * 
	 * 
	 */

	@Query(name = "Model.findAllModelsByType")
	public Page<Model> searchModelsByType(@Param("name") String name, Pageable pageable);

}
