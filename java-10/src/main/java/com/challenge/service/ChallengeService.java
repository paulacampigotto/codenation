package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChallengeService implements ChallengeServiceInterface {

	 @Autowired(required=false)
	 private ChallengeRepository repository;
	
	@Override
	public Challenge save(Challenge object) {
		return repository.save(object);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		return repository.findByAccelerationIdAndUserId(accelerationId, userId);
	}

}
