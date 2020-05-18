package com.challenge.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;

@RestController
@RequestMapping("challenge")
public class ChallengeController {
	
	@Autowired
	private ChallengeService challengeService;
	
	@GetMapping(params= {"accelerationId", "userId"})
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long acceleration_id, 
    		@RequestParam("userId")Long user_id) {
        return challengeService.findByAccelerationIdAndUserId(acceleration_id, user_id);
    }

}
