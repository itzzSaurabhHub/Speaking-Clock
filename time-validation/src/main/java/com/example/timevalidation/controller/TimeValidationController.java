package com.example.timevalidation.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.timevalidation.service.TimeValidationService;

@RestController

public class TimeValidationController {

	@Autowired
	private TimeValidationService timeValidationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/validate-time")
	public ResponseEntity<String> validateTime(@RequestParam("time") String time)
	{
		timeValidationService.isValidTimeFormat(time);
		String convertedTime = restTemplate.getForObject("http://TIME-CONVERSION/convert-time?time={time}", String.class, time);
		return ResponseEntity.ok(convertedTime);
	}
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleValidationException(ValidationException ex)
	{
		return ex.getMessage();
	}
	
	
}

	