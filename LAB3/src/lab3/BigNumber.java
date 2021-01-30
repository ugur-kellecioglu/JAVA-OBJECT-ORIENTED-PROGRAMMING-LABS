package lab3;

import java.util.ArrayList;
import java.math.*;

public class BigNumber {
	private ArrayList<Integer> Digits = new ArrayList<Integer>();
	private int Sign;

	public BigNumber(ArrayList<Integer> digits, int sign) {

		this.Digits = digits;
		this.Sign = sign;
	}

	public String toString() {
		return "BigNumber [Digits=" + Digits + ", Sign=" + Sign + "]";
	}

	public ArrayList<Integer> getDigits() {
		return Digits;
	}

	public void setDigits(ArrayList<Integer> digits) {
		Digits = digits;
	}

	public int getSign() {
		return Sign;
	}

	public void setSign(int sign) {
		Sign = sign;
	}

	public BigNumber Minimum(BigNumber Compared) {
		// I can't declare those numbers into an primitive datatype so
		// i'll check their sign and size first.
		// if their size are same, i'll control every digits whenever one of their digit
		// is bigger than other that means it's bigger.
		BigNumber min = null;
		// numbers size
		int no_one_size = this.Digits.size();
		int no_two_size = Compared.Digits.size();

		// if both are positive
		if (this.Sign == 0 && Compared.Sign == 0) {
			// if their length are same -
			if (no_one_size == no_two_size) {

				for (int i = 0; i < no_one_size; i++) {

					// check their digits starting from the beginning and compare
					int digit_one = this.Digits.get(i);
					int digit_second = Compared.Digits.get(i);
					if (digit_one > digit_second) {
						min = Compared;

					} else {
						min = this;

					}
				}
			}
			// if their lenght aren't same
			else {
				if (no_one_size > no_two_size)
					min = Compared;
				else
					min = this;
			}
		}
		// if both are negative
		else if (this.Sign == 1 && Compared.Sign == 1) {

			// if their length are same -
			if (no_one_size == no_two_size) {

				for (int i = 0; i < no_one_size; i++) {

					// check their digits starting from the beginning and compare
					int digit_one = this.Digits.get(i);
					int digit_second = Compared.Digits.get(i);
					if (digit_one > digit_second) {
						min = this;

					} else {
						min = Compared;

					}
				}
			}
			// if their lenght aren't same
			else {
				if (no_one_size > no_two_size)
					min = this;
				else
					min = Compared;
			}
		} else {
			if (this.Sign == 1)
				min = this;
			else
				min = Compared;
		}
		return min;
	}

	public BigNumber Max(BigNumber Compared) {
		// I can't declare those numbers into an primitive datatype so
		// i'll check their sign and size first.
		// if their size are same, i'll control every digits whenever one of their digit
		// is bigger than other that means it's bigger.
		BigNumber max = null;
		// numbers size
		int no_one_size = this.Digits.size();
		int no_two_size = Compared.Digits.size();

		// if both are positive
		if (this.Sign == 0 && Compared.Sign == 0) {
			// if their length are same -
			if (no_one_size == no_two_size) {

				for (int i = 0; i < no_one_size; i++) {

					// check their digits starting from the beginning and compare
					int digit_one = this.Digits.get(i);
					int digit_second = Compared.Digits.get(i);

					if (digit_one > digit_second) {

						max = this;

					} else {

						max = Compared;

					}
				}
			}
			// if their lenght aren't same
			else {
				if (no_one_size > no_two_size)
					max = this;
				else
					max = Compared;
			}
		}
		// if both are negative
		else if (this.Sign == 1 && Compared.Sign == 1) {

			// if their length are same
			if (no_one_size == no_two_size) {

				for (int i = 0; i < no_one_size; i++) {

					// check their digits starting from the beginning and compare
					int digit_one = this.Digits.get(i);
					int digit_second = Compared.Digits.get(i);

					if (digit_one > digit_second) {

						max = Compared;

					} else {
						max = this;

					}
				}
			}
			// if their lenght aren't same
			else {
				if (no_one_size > no_two_size)
					max = Compared;
				else
					max = this;
			}
		} else {
			if (this.Sign == 1)
				max = Compared;
			else
				max = this;
		}
		return max;
	}
	public String fill(String str, int len) {
		int a = str.length();
		for(int i = 0; i < len - a; i++) {
			str = '0' + str;
			
		}
		return str;
	}
	public BigNumber Add(BigNumber Second) {
		BigNumber result = null;
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		String str1 = "";
		String str2 = "";
		String str = "";
		
		if (this.absCompare(Second) == this) {
			for(int digit : this.Digits) {
				str1 += digit;
			}
			for(int digit : Second.Digits) {
				str2 += digit;
			}
		}
		else {
			for(int digit : Second.Digits) {
				str1 += digit;
			}
			for(int digit : this.Digits) {
				str2 += digit;
			}
		}
		
	
		int lenStr1 = str1.length();
		int lenStr2 = str2.length();
		
	
		str2 = fill(str2, lenStr1);
	
	    int carryout = 0;
	    int sum = 0;
	    lenStr1 = str1.length();
		lenStr2 = str2.length();
	    for (int i = lenStr1 - 1 ; i >= 0; i--) {
	    	sum = Integer.parseInt(String.valueOf(str1.charAt(i))) + Integer.parseInt(String.valueOf(str2.charAt(i))) + carryout;
	  

	    	str = Integer.toString((sum) % 10 ) + str;
	    	carryout = (sum) / 10;
	    	
	    }
	    if ( carryout >= 1) {
	    	str = "1" +str;
	    }
	    for (char ch: str.toCharArray()) {
	    	resultArrayList.add(Integer.parseInt(String.valueOf(ch)));
	    }
		result = new BigNumber(resultArrayList, this.getSign());
		return result;
	}


	
	/// SUBS
	public BigNumber Substract(BigNumber Second) {
		BigNumber result = null;
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		String str1 = "";
		String str2 = "";
		String str = "";
		if (this.absCompare(Second) == this) {
			for(int digit : this.Digits) {
				str1 += digit;
			}
			for(int digit : Second.Digits) {
				str2 += digit;
			}
		}
		else {
			for(int digit : Second.Digits) {
				str1 += digit;
			}
			for(int digit : this.Digits) {
				str2 += digit;
			}
		}
		
	
		int lenStr1 = str1.length();
		int lenStr2 = str2.length();
		
	
		str2 = fill(str2, lenStr1);
		
		
		 
		
		
		
		 lenStr1 = str1.length();
		 lenStr2 = str2.length();
		int carryout = 0;
		int sub = 0;
		for (int i = lenStr1 -1  ; i >= 0; i--) {
	    	sub = Integer.parseInt(String.valueOf(str1.charAt(i))) - Integer.parseInt(String.valueOf(str2.charAt(i))) - carryout ;
	    	
	    	if (sub < 0) {
	    		
	    		carryout = 1;
	    		sub += 10;
	    		
	    	}
	    	else {
	    		carryout = 0;
	    	}
	    	
	    	
	    	
	    	str = sub + str;
		}
		
	
		for (char ch: str.toCharArray()) {
			resultArrayList.add(Integer.parseInt(String.valueOf(ch)));
		}
		int arrlen = resultArrayList.size();
		for(int i = 0 ; i < arrlen - 1 ;i++) {
			if (resultArrayList.get(0) == 0 ) {
				resultArrayList.remove(0);
			}
			else {
				break;
			}
		}
		
		if (compareTo(Second) == -1) {
			result = new BigNumber(resultArrayList,1);
		
		}
		else {
			result = new BigNumber(resultArrayList,0);
			
		}
		if(result.Digits.get(0) == 0) {
			this.setSign(0);
			Second.setSign(0);
		}
		return result;
	}

	public int compareTo(BigNumber Second) {
		
		if (this.Max(Second) == this) {
			return 1;
		}
		else if (this.Digits == Second.Digits){
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public BigNumber absCompare(BigNumber Second) {
		BigNumber result = null;
		
		String str1 = "";
		String str2 = "";
		
		
		for(int digit : this.Digits) {
			str1 += digit;
		}
		for(int digit : Second.Digits) {
			str2 += digit;
		}

		int lenStr1 = str1.length();
		int lenStr2 = str2.length();
		if(lenStr1 > lenStr2) {
			result = this ;
		}
		else if(lenStr1 < lenStr2) {
			result =  Second;
		}
		else {
			for(int i = 0; i < lenStr1; i++) {
				if(this.Digits.get(i) > Second.Digits.get(i)) {
					result =  this;
					break;
				}
				else if(Second.Digits.get(i) > this.Digits.get(i)) {
					result =  Second;
					break;
				}
				else {
					continue;
				}
			}
		}
		return result;
	}
	
}
