package com.bayamp.practise.practise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
	}
		// TODO Auto-generated method stub
        // Pattern
		// Matcher
		// PatternSyntaxException
		public static void RegexExp(){
		
		Pattern paint = Pattern.compile("Home Works");
		Matcher match1 = paint.matcher("work");
		System.out.println("Print -"+match1.matches());
		
		String Email_Pattern = "^[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
		Pattern pattn = Pattern.compile(Email_Pattern);
		Matcher match = pattn.matcher(null);
			System.out.println("Print -"+match.matches());

		}

}

