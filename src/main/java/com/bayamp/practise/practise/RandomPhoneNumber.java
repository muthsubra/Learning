package com.bayamp.practise.practise;

import java.util.Random;

public class RandomPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Program to generate random Phone number
		
		Random generator = new Random();
		
		String strippedNum;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		num1 = generator.nextInt(600)+100;
		num2 = generator.nextInt(641)+100;
		num3 = generator.nextInt(8999)+1000;
		
		/*String string1 = Integer.toString(num1);
		strippedNum = Integer.toOctalString(num1);*/
		
		System.out.println("Print-"+num1+ "-"+num2+ "-"+num3);
		

	}

	}

