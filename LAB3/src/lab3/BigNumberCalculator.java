package lab3;

import java.awt.SecondaryLoop;
import java.util.ArrayList;
import java.util.Scanner;
public class BigNumberCalculator {
	
	/*  
	// AUTHOR UGUR KELLECIOGLU 
	// START TIME 09:08 24.10.2020
	// break at 10:24 24.10.2020 -> time : 76min
	// start at 18:19 24.10.2020 
	// break at 19:32 24.10.2020 -> time : 73min
	// start at 8:24 25.10.2020
	// 9:12 -> time : 56 min
	// start at 9:58 found a class named BigInteger that makes everything easier :)
	 * I didn't change the functions that i already coded by myself -> max, min
	// 10:31 -> time : 33min
	// start at 12:03
	// FINAL AT 12: 19 25.10.2020 time -> : 16min
	// total time : 4h14min 
	*/
	
	// instructor told me that i can't use biginteger class. After that i literally spent 15 hours to complete it.
	
	public static ArrayList<Integer> convert_arraylist(String input) {
		char[] chars = input.toCharArray();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(char ch:chars) {
			arr.add(Integer.parseInt(String.valueOf(ch)));
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		do {
			System.out.println("Enter a command: ");
			input = keyboard.nextLine();
			String[] cmd = input.split("\\s+");
	 		String fnc = cmd[0];
	 		
	 		if(fnc.equals("min")) {
	 			String no_1 = cmd[1];
	 			String no_2 = cmd[2];
	 			BigNumber no_one;
	 			BigNumber no_two;
	 			if(no_1.charAt(0) == '-') {	
	 				
	 				no_1 = no_1.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_one = new BigNumber(convert_arraylist(no_1), 1); // NEGATIVE
	 			}
	 			else {
	 				no_one = new BigNumber(convert_arraylist(no_1), 0); // POSITIVE
	 			}
	 			if(no_2.charAt(0) == '-') {	
	 				
	 				no_2 = no_2.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_two = new BigNumber(convert_arraylist(no_2), 1); // NEGATIVE
	 			}
	 			else {
	 				no_two = new BigNumber(convert_arraylist(no_2), 0); // POSITIVE
	 			}
	 			int check = no_one.Minimum(no_two).getSign();
	 			if (check == 1 ) System.out.print("-");
	 			
	 			for (int digits:no_one.Minimum(no_two).getDigits()) {
	 				System.out.print(digits);
	 			}
	 			System.out.print("\n");
	 		}
	 		
	 		if(fnc.equals("max")) {
	 			String no_1 = cmd[1];
	 			String no_2 = cmd[2];
	 			BigNumber no_one;
	 			BigNumber no_two;
	 			if(no_1.charAt(0) == '-') {	
	 				
	 				no_1 = no_1.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_one = new BigNumber(convert_arraylist(no_1), 1); // NEGATIVE
	 			}
	 			else {
	 				no_one = new BigNumber(convert_arraylist(no_1), 0); // POSITIVE
	 			}
	 			if(no_2.charAt(0) == '-') {	
	 				
	 				no_2 = no_2.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_two = new BigNumber(convert_arraylist(no_2), 1); // NEGATIVE
	 			}
	 			else {
	 				no_two = new BigNumber(convert_arraylist(no_2), 0); // POSITIVE
	 			}
	 			int check = no_one.Max(no_two).getSign();
	 			if (check == 1 ) System.out.print("-");
	 			
	 			for (int digits:no_one.Max(no_two).getDigits()) {
	 				System.out.print(digits);
	 			}
	 			System.out.print("\n");
	 		}


	 		
	 		
	 		
	 		if(fnc.equals("add")) {
	 			String no_1 = cmd[1];
	 			String no_2 = cmd[2];
	 			BigNumber no_one;
	 			BigNumber no_two;
	 			BigNumber temp;

	 			if(no_1.charAt(0) == '-') {	
	 				
	 				no_1 = no_1.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_one = new BigNumber(convert_arraylist(no_1), 1); // NEGATIVE
	 			}
	 			else {
	 				no_one = new BigNumber(convert_arraylist(no_1), 0); // POSITIVE
	 			}
	 			if(no_2.charAt(0) == '-') {	
	 				
	 				no_2 = no_2.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_two = new BigNumber(convert_arraylist(no_2), 1); // NEGATIVE
	 			}
	 			else {
	 				no_two = new BigNumber(convert_arraylist(no_2), 0); // POSITIVE
	 			}
	 			if(no_one.absCompare(no_two) == no_two) {
	 				temp = no_two;
	 				no_two = no_one;
	 				no_one = temp;
	 			}
	 			
	 			if(no_two.getSign() == 1 && no_one.getSign() == 0) {
	 				String check = "";
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				if(no_2.equals(check)) System.out.print("-");
	 				for (int digits:no_one.Substract(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
	 				
		 			System.out.print("\n");
	 			}
	 			else if(no_one.getSign() == 1 && no_two.getSign() == 0) {
	 				String check = "";
	 				if(no_one.getSign() == 1) {
	 					System.out.print("-");
	 				}
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 				
	 				
	 				for (int digits:no_one.Substract(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			else if(no_one.getSign() == 0 && no_two.getSign() == 0){
	 				String check = "";
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				
	 				for (int digits:no_one.Add(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			else if(no_one.getSign() == 1 && no_two.getSign() == 1){
	 				String check = "";
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				System.out.print("-");
	 				for (int digits:no_one.Add(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			
	 		}
	 		
	 		
	 		if(fnc.equals("sub")) {
	 			String no_1 = cmd[1];
	 			String no_2 = cmd[2];
	 			BigNumber no_one;
	 			BigNumber no_two;
	 			BigNumber temp;
	 			if(no_1.charAt(0) == '-') {	
	 				
	 				no_1 = no_1.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_one = new BigNumber(convert_arraylist(no_1), 1); // NEGATIVE
	 			}
	 			else {
	 				no_one = new BigNumber(convert_arraylist(no_1), 0); // POSITIVE
	 			}
	 			if(no_2.charAt(0) == '-') {	
	 				
	 				no_2 = no_2.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_two = new BigNumber(convert_arraylist(no_2), 1); // NEGATIVE
	 			}
	 			else {
	 				no_two = new BigNumber(convert_arraylist(no_2), 0); // POSITIVE
	 			}
	 			
	 			if(no_one.absCompare(no_two) == no_two) {
	 				temp = no_two;
	 				no_two = no_one;
	 				no_one = temp;
	 			}
	 			
	 			if(no_two.getSign() != 1 && no_one.getSign() != 1) {
	 				String check = "";
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				if(no_one.Substract(no_two).getDigits().get(0) != 0) {
	 					if(no_2.equals(check)) System.out.print("-");
	 				}
	 				for (int digits:no_one.Substract(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			else if(no_two.getSign() == 1 && no_one.getSign() != 1) {
	 			String check = "";
 				for(int digit: no_one.getDigits()) {
 					check += digit;
 				}
 			
 				if(no_2.equals(check)) System.out.print("-");
	 				for (int digits:no_one.Add(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			else if(no_two.getSign() == 0 && no_one.getSign() != 0) {
	 			
	 				String check = "";
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				if(!no_2.equals(check)) System.out.print("-");
	 				for (int digits:no_one.Add(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			else if(no_two.getSign() == 1 && no_one.getSign() == 1) {
	 				String check = "";
	 				
	 				for(int digit: no_one.getDigits()) {
	 					check += digit;
	 				}
	 			
	 				if(no_2.equals(check)) {
	 					
	 					if(no_one.getSign() != 1) {
	 						System.out.print("-");
	 					}
	 				}
	 				
	 				for (int digits:no_one.Substract(no_two).getDigits()) {
		 				System.out.print(digits);
		 			}
		 			System.out.print("\n");
	 			}
	 			
	 		}
	 		if(fnc.equals("max3")) {
	 			String no_1 = cmd[1];
	 			String no_2 = cmd[2];
	 			String no_3 = cmd[3];
	 			BigNumber no_one;
	 			BigNumber no_two;
	 			BigNumber no_three;
	 			BigNumber temp;
	 			if(no_1.charAt(0) == '-') {	
	 				
	 				no_1 = no_1.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_one = new BigNumber(convert_arraylist(no_1), 1); // NEGATIVE
	 			}
	 			else {
	 				no_one = new BigNumber(convert_arraylist(no_1), 0); // POSITIVE
	 			}
	 			if(no_2.charAt(0) == '-') {	
	 				
	 				no_2 = no_2.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_two = new BigNumber(convert_arraylist(no_2), 1); // NEGATIVE
	 			}
	 			else {
	 				no_two = new BigNumber(convert_arraylist(no_2), 0); // POSITIVE
	 			}
	 			if(no_3.charAt(0) == '-') {	
	 				
	 				no_3 = no_3.substring(1); // OTHERWISE I'll get an error wheni try to put digits into arraylist
	 				no_three = new BigNumber(convert_arraylist(no_3), 1); // NEGATIVE
	 			}
	 			else {
	 				no_three = new BigNumber(convert_arraylist(no_3), 0); // POSITIVE
	 			}
	 			
	 			temp = no_one.Max(no_two);
	 			temp.setSign(no_one.Max(no_two).getSign());
	 			
	 			if(temp.Max(no_three).getSign() == 1) {
	 				System.out.print("-" );
	 			}
	 			for (int digits:temp.Max(no_three).getDigits()) {
	 				System.out.print(digits);
	 			}
	 			System.out.print("\n");
	 			
	 		}
	 			
		}
		while(!input.equals("Q"));
	}

}
