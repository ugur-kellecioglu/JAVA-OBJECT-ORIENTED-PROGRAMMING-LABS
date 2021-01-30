package lab1;

import java.util.*;






public class Student {

	private String name;
	private String id;
	private int gradeCount;
	private Grade[] Grades;

	public Student(String name, String id) {
		this.name = name;
		this.id = id;
		Grades = new Grade[4];
		this.gradeCount = 0;
		
	}
	/// GET AND SET METHODS BEGIN
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/// GET AND SET METHODS END
	
	boolean addGrade (String letterGrade) {
		if (this.gradeCount != 4)
		{
			Grade g = new Grade(letterGrade);
			//System.out.println(g.getGrade());
			this.Grades[gradeCount] = g;
			//System.out.println(this.Grades[gradeCount].getGrade());
			this.gradeCount++;
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean removeGrade (int index) {
		if(index <  this.gradeCount)
		{
			System.arraycopy(this.Grades, index + 1, this.Grades, index, this.Grades.length - index - 1);
			//test = ArrayUtils.remove(test, 2);
			
			this.gradeCount--;
			return true;
		}
		else
		{
			return false;
		}
	}
	public String printGrades() {
		String grades = "";
		for (int i = 0; i < this.gradeCount; i++) {
			
				grades = grades + this.Grades[i].getGrade() + " ";
			
		}
		return "Grades of Student " + toString() + ": " +   grades;
	}
	public double averageGrade() {
		double avGrade = 0;
		for (int i = 0; i < this.gradeCount; i++) {
			
				avGrade += this.Grades[i].getGrade();
		}
		avGrade /= this.gradeCount;
		return avGrade;
	}
	public String toString() {
		 return this.getName()+"("+this.getId()+")";
	 }
}
