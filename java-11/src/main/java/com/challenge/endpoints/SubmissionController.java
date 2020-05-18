package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;

@RestController
@RequestMapping("submission")
public class SubmissionController {
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private SubmissionMapper submissionMapper;
	
	@GetMapping(params= {"challengeId", "accelerationId"})
		public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam("challengeId") Long challenge_id, 
	    		@RequestParam("accelerationId") Long acceleration_id) {
	    return submissionMapper.map(submissionService.findByChallengeIdAndAccelerationId(challenge_id, acceleration_id));
	    }

}
