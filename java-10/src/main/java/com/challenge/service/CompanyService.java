package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Company;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.service.interfaces.CompanyServiceInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyServiceInterface {

	
	 @Autowired(required=false)
	 private CompanyRepository repository;
	 
	 
	@Override
	public Company save(Company object) {
		return repository.save(object);
	}

	@Override
	public Optional<Company> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Company> findByAccelerationId(Long accelerationId) {
		return repository.findByAccelerationId(accelerationId);
	}

	@Override
	public List<Company> findByUserId(Long userId) {
		return repository.findByUserId(userId);
	}

}
