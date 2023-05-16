package com.example.timeconversion.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.timeconversion.exception.TimeInvalidException;
import com.example.timeconversion.service.TimeConversionService;

	class TimeConversionControllerTest {

		@Test
		void testConvertTime() {
			TimeConversionService timeConversionService = mock(TimeConversionService.class);
			
			when(timeConversionService.convertTime("08:34")).thenReturn("It's eight thirty four");
			
			TimeConversionController controller = new TimeConversionController(timeConversionService);
			
			ResponseEntity<String> response = controller.convertTime("08:34");
			
			assert response.getStatusCode() == HttpStatus.OK;
			assert response.getBody().equals("It's eight thirty four");
		}
		
		@Test
		void testHandleTimeInvalidException() {
			
			TimeConversionController controller = new TimeConversionController(null);
			
			ResponseEntity<String> response = controller.handleTimeInvalidException(new TimeInvalidException("Invalid Time Format"));
			
			assert response.getStatusCode() == HttpStatus.BAD_REQUEST;
			assert response.getBody().equals("Invalid Time Format");
		}

	}
