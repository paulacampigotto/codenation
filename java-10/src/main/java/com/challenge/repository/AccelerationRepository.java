package com.challenge.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
@Component
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    @Query(value = "select distinct a.id, a.name, a.slug, a.challenge_id, a.created_at from acceleration a join (candidate c join company co on co.id = c.company_id)\n" + 
    		"on a.id = c.acceleration_id and co.id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);

}
