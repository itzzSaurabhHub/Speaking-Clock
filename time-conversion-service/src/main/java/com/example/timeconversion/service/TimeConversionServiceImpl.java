package com.example.timeconversion.service;

import org.springframework.stereotype.Service;

import com.example.timeconversion.exception.TimeInvalidException;

@Service
public class TimeConversionServiceImpl implements TimeConversionService {

	private static final String[] HOURS = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve"};
    
    private static String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty"};

    private static String[] TEENS = {"","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	
	
	@Override
	public String convertTime(String time) {
		
		
		String[] dividedString = time.split(":");
		int hours = Integer.parseInt(dividedString[0]);
		int minutes = Integer.parseInt(dividedString[1]);
		String convertedTime = "";
		
		if(hours<0 || hours>23 || minutes < 0 || minutes>59)
			throw new TimeInvalidException("Invalid Time Format");
	    
		if(hours==0 && minutes == 0)
			convertedTime = "It's Midnight";
		else if(hours==12 && minutes == 0)
			convertedTime = "It's Midday";
		else {
			String hourWord = (hours % 12 == 0 ) ? "Twelve" : HOURS[hours%12];
			String minuteWord = convertMinutesToWords(minutes);
			String period = hours>=12?"PM":"AM";
			
			convertedTime = "It's "+hourWord+" "+ minuteWord+" "+ period;
		}
		
	    
		return convertedTime;
		
		
		
	}


	private String convertMinutesToWords(int minutes) {
		
		if(minutes == 0)
			return "";
		else if(minutes <= 12)
			return HOURS[minutes];
		else if(minutes < 20)
			return TEENS[minutes%12];
		else
		{
			int tens = minutes/10;
			int ones = minutes%10;
			
			return TENS[tens] + (ones == 0 ? "" : " " + HOURS[ones]);
		}
	}

}
