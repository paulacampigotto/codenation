package com.challenge.endpoints;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;

@RestController
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value="/{id}")
    public Optional<Company> findById(@PathVariable(required = false) Long id) {
        return companyService.findById(id);
    }

	@GetMapping(params="accelerationId")
    public List<Company> findByAccelerationId(@RequestParam("accelerationId") Long acceleration_id) {
        return companyService.findByAccelerationId(acceleration_id);
    }

	@GetMapping(params="userId")
    public List<Company> findByUserId(@RequestParam("userId") Long user_id) {
        return companyService.findByUserId(user_id);
    }

}
