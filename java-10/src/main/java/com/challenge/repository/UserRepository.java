package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select distinct u.* from users u join candidate c on c.user_id = u.id\n" + 
			"join acceleration a on a.id = c.acceleration_id and a.name = :name", nativeQuery = true)
	List<User> findByAccelerationName(@Param("name") String name); 

	@Query(value = "select distinct u.* from users u join (candidate ca join company co on co.id = ca.company_id \n" + 
			"and co.id = :companyId) on ca.user_id = u.id", nativeQuery = true)
	List<User> findByCompanyId(@Param("companyId") Long companyId);
	
}

