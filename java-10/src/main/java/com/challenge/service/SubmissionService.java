package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {

	 @Autowired(required=false)
	 private SubmissionRepository repository;
	
	@Override
	public Submission save(Submission object) {
		return repository.save(object);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		if(repository.findHigherScoreByChallengeId(challengeId) == null) return BigDecimal.ZERO;
		return repository.findHigherScoreByChallengeId(challengeId);
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
	}

}
