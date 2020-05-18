package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	@Autowired
	private CandidateMapper candidateMapper;

	@GetMapping("/candidate/{userId}/{accelerationId}/{companyId}")
	public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long accelerationId,
			@PathVariable Long companyId) {
		return candidateService.findById(userId, companyId, accelerationId).map(candidateMapper::map).orElse(null);
	}

	@GetMapping(params = "companyId")
	public @ResponseBody List<CandidateDTO> findByCompanyId(@RequestParam("companyId") Long companyId) {
		return candidateMapper.map(candidateService.findByCompanyId(companyId));
	}

	@GetMapping(params = "accelerationId")
	public @ResponseBody List<CandidateDTO> findByAccelerationId(@RequestParam("accelerationId") Long accelerationId) {
		return candidateMapper.map(candidateService.findByAccelerationId(accelerationId));
	}

}
