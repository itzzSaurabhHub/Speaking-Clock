package com.example.timeconversion.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.timeconversion.exception.TimeInvalidException;

public class TimeConversionServiceImplTest {

		private TimeConversionService service = new TimeConversionServiceImpl();

		@Test
		public void testConvertTimeWithValidInput() {
			String actual = service.convertTime("08:34");
			assertEquals("It's Eight Thirty Four AM", actual);
		}

		@Test
		public void testConvertTimeWithMidday() {
			String actual = service.convertTime("12:00");
			assertEquals("It's Midday", actual);
		}

		@Test
		public void testConvertTimeWithMidnight() {
			String actual = service.convertTime("00:00");
			assertEquals("It's Midnight", actual);
		}

		@Test
		public void testConvertTimeWithInvalidHour() {
			TimeInvalidException exception = assertThrows(TimeInvalidException.class, () -> service.convertTime("25:00"));
			assertEquals("Invalid Time Format", exception.getMessage());
		}

		@Test
		public void testConvertTimeWithInvalidMinute() {
			TimeInvalidException exception = assertThrows(TimeInvalidException.class, () -> service.convertTime("08:60"));
			assertEquals("Invalid Time Format", exception.getMessage());
		}

	}

