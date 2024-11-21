package com.cognizant.racegarden;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean validateEmail(String email) {
		
		Pattern p = Pattern.compile("^([a-zA-Z]+)[a-zA-Z0-9]+@[a-zA-Z]+[.][a-z]+");
        
        Matcher m = p.matcher(email);
        
        return m.matches();
	}
	
}
