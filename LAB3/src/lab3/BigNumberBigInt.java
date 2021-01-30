package lab3;

import java.util.ArrayList;
import java.math.*;

public class BigNumberBigInt {
	private ArrayList<Integer> Digits = new ArrayList<Integer>();
	private int Sign;

	public BigNumberBigInt(ArrayList<Integer> digits, int sign) {

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

	public BigNumberBigInt Minimum(BigNumberBigInt Compared) {
		// I can't declare those numbers into an primitive datatype so
		// i'll check their sign and size first.
		// if their size are same, i'll control every digits whenever one of their digit
		// is bigger than other that means it's bigger.
		BigNumberBigInt min = null;
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

	public BigNumberBigInt Max(BigNumberBigInt Compared) {
		// I can't declare those numbers into an primitive datatype so
		// i'll check their sign and size first.
		// if their size are same, i'll control every digits whenever one of their digit
		// is bigger than other that means it's bigger.
		BigNumberBigInt max = null;
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

	public BigNumberBigInt Add(BigNumberBigInt Second) {
		BigNumberBigInt result = null;
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		String one = "";
		String two = "";
		if (this.Sign == 1)
			one = "-";
		if (Second.Sign == 1)
			two = "-";
		for (int number : this.Digits) {
			one += number;
		}

		for (int number : Second.Digits) {
			two += number;
		}
		BigInteger A, B, C;
		A = new BigInteger(one);
		B = new BigInteger(two);
		C = A.add(B);
		String str = C.toString();
		char[] chars = str.toCharArray();
		for (char ch : chars) {
			if (ch != '-') {
				resultArrayList.add(Integer.parseInt(String.valueOf(ch)));
			}
		}
		int sign = C.signum();
		if (sign == -1)
			sign = 1;
		else
			sign = 0;
		result = new BigNumberBigInt(resultArrayList, sign);

		return result;
	}

	public BigNumberBigInt Substarct(BigNumberBigInt Second) {
		BigNumberBigInt result = null;
		ArrayList<Integer> resultArrayList = new ArrayList<Integer>();
		String one = "";
		String two = "";
		if (this.Sign == 1)
			one = "-";
		if (Second.Sign == 1)
			two = "-";
		for (int number : this.Digits) {
			one += number;
		}

		for (int number : Second.Digits) {
			two += number;
		}
		BigInteger A, B, C;
		A = new BigInteger(one);
		B = new BigInteger(two);

		C = A.subtract(B);
		String str = C.toString();
		char[] chars = str.toCharArray();
		for (char ch : chars) {
			if (ch != '-') {
				resultArrayList.add(Integer.parseInt(String.valueOf(ch)));
			}
		}
		int sign = C.signum();
		if (sign == -1)
			sign = 1;
		else
			sign = 0;

		result = new BigNumberBigInt(resultArrayList, sign);

		return result;
	}

	public int compareTo(BigNumberBigInt Second) {
		String one = "";
		String two = "";
		for (int number : this.Digits) {
			one += number;
		}

		for (int number : Second.Digits) {
			two += number;
		}
		BigInteger A, B, C;
		A = new BigInteger(one);
		B = new BigInteger(two);

		return A.compareTo(B);
	}

}
