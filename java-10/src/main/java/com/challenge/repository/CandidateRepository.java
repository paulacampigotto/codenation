package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;

@Repository
@Component
public interface CandidateRepository extends JpaRepository<Candidate, Long>{
	
	@Query(value = "select distinct * from candidate where user_id = :userId and company_id = :companyId and acceleration_id = :accelerationId", nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);
	
	@Query(value = "select distinct * from candidate where company_id = :companyId", nativeQuery = true)
	List<Candidate> findByCompanyId(@Param("companyId") Long companyId); 
	
	@Query(value = "select distinct * from candidate where acceleration_id = :accelerationId", nativeQuery = true)
	List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId); 
}
