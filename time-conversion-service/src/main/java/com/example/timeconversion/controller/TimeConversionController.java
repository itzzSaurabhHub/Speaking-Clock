package com.example.timeconversion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.timeconversion.exception.TimeInvalidException;
import com.example.timeconversion.service.TimeConversionService;

@RestController
public class TimeConversionController {
	
	private final TimeConversionService timeConversionService;

	public TimeConversionController(TimeConversionService timeConversionService) {
		this.timeConversionService = timeConversionService;
	}
	
	@GetMapping("/convert-time")
	public ResponseEntity<String> convertTime(@RequestParam("time") String time)
	{
		String convertedTime = timeConversionService.convertTime(time);
		return ResponseEntity.ok(convertedTime);
	}
	
	@ExceptionHandler(TimeInvalidException.class)
	public ResponseEntity<String> handleTimeInvalidException(TimeInvalidException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
