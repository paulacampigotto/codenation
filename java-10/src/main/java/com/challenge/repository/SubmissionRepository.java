package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;

@Repository
@Component
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
	
	@Query(value = "select max(s.score) from submission s join challenge c\n" + 
			"on c.id = s.challenge_id and c.id = :challengeId", nativeQuery = true)
	BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	
	@Query(value = "select distinct s.user_id, s.challenge_id, s.score, s.created_at from submission s join (challenge c join \n" + 
			"acceleration a on c.id = a.challenge_id) on \n" + 
			"s.challenge_id = c.id and a.id = :accelerationId \n" + 
			"and c.id = :challengeId", nativeQuery = true)
	List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
	
}