package com.example.timevalidation.service;

import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

@Service
public class TimeValidationServiceImpl implements TimeValidationService {

	@Override
	public void isValidTimeFormat(String time) {		
		
		if(!time.matches("^([01][0-9]|2[0-3]):[0-5][0-9]$"))
			throw new ValidationException("Invalid time format, use HH:MM format");
				
	}

}
