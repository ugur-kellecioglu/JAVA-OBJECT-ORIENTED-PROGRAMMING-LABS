package lab1;



public class Course {
	private String CourseCode, day;
	private int studentCount, Capacity;
	private double averageGrade;
	
	public Course(String CourseCode, String day, int studentCount, int Capacity, double averageGrade) {
		this.CourseCode = CourseCode;
		this.day = day;
		this.studentCount = studentCount;
		this.Capacity = Capacity;
		this.averageGrade = averageGrade;
	}
	public boolean addGrade (double grade) {
		
		if (studentCount < this.Capacity)
		{
			this.averageGrade *= this.studentCount;
			this.averageGrade += grade;
			this.studentCount++;
			if(this.studentCount != 0) {
				this.averageGrade = this.averageGrade / this.studentCount;
			}
			return true;
		}
		else {
			return false;
		}
	}
	public boolean removeGrade (double grade) {
		if (this.studentCount != 0) {
			this.averageGrade *= this.studentCount;
			this.averageGrade -= grade;
			this.studentCount--;
			if(this.studentCount != 0) {
				this.averageGrade = this.averageGrade / this.studentCount;
			}
			return true;
		}
		else {
			return false;
		}
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String CourseCode) {
		this.CourseCode = CourseCode;
	}
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int Capacity) {
		this.Capacity = Capacity;
	}
	
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	
	
	
	
	
	
	
}
