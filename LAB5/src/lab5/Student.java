package lab5;

public class Student extends Member  {
   
    private String year;
    public Student(String student_name, String student_id, String year) {
	
	super(student_name, student_id);
	this.year = year;
	
    }
    public String getYear() {
	return year;
    }
    public void setYear(String year) {
	this.year = year;
    }
    
    
}
