package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
@Component
public interface CompanyRepository extends JpaRepository<Company, Long>{

	@Query(value = "select distinct co.id, co.name, co.slug, co.created_at from company co join candidate ca on ca.user_id = :userId and ca.company_id = co.id", nativeQuery = true)
	List<Company> findByUserId(@Param("userId") Long userId);
	
	@Query(value = "select distinct co.id, co.name, co.slug, co.created_at from company co join (candidate ca join acceleration a on ca.acceleration_id = a.id " + 
	"and a.id = :accelerationId) on co.id = ca.company_id", nativeQuery = true)
	List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);
	
}


