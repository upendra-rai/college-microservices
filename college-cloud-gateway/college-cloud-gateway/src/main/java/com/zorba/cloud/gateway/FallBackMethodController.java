package com.zorba.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/examServiceFallBack")
	public String examServiceFallBackMethod() {
		return "Exam Service is taking longer than Expected."+" Please try again later";
	}
	
	@GetMapping("/studentServiceFallBack")
	public String studentServiceFallBackMethod() {
		return "Student Service is taking longer than Expected."+" Please try again later";
	}

}
