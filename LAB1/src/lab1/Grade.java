package lab1;

public class Grade {
	
	double grade;
	
	public Grade(String letterGrade) {
		
		double grade = convertLetter(letterGrade);
		this.grade = grade;
		
	}
	double convertLetter (String letterGrade) {
		
		if (letterGrade.equals("A+"))
		{
			return 4.0;
		}
		else if (letterGrade.equals("A-"))
		{
			return 3.7;
		}
		else if (letterGrade.equals("B+"))
		{
			return 3.3;
		}
		else if (letterGrade.equals("B"))
		{
			return 3.0;
		}
		else if (letterGrade.equals("B-"))
		{
			return 2.7;
		}
		else if (letterGrade.equals("C+"))
		{
			return 2.3;
		}
		else if (letterGrade.equals("C"))
		{
			return 2.0;
		}
		else if (letterGrade.equals("C-"))
		{
			return 1.7;
		}
		else if (letterGrade.equals("D+"))
		{
			return 1.3;
		}
		else if (letterGrade.equals("D-"))
		{
			return 1.0;
		}
		else if (letterGrade.equals("F"))
		{
			return 0;
		}
		else return -99;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
}
