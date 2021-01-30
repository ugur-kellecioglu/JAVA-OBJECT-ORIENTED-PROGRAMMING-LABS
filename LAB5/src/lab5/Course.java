package lab5;

import java.util.ArrayList;

public class Course {
	
	
	private String course_code;
	private String course_name;
	private int year;
	private String semester;
	private int capacity;
	private Instructor ins = null;
	private ArrayList<TeachingAssistant> teachingassistants;
	private ArrayList<Student> students;
	public Course(String course_code, String course_name, int year, String semester, int capacity) {
		
		this.course_code = course_code;
		this.course_name = course_name;
		this.year = year;
		this.semester = semester;
		this.capacity = capacity;
		teachingassistants = new ArrayList<TeachingAssistant>();
		students = new ArrayList<Student>();
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Instructor getIns() {
		return ins;
	}
	public void setIns(Instructor ins) {
		this.ins = ins;
	}
	public ArrayList<TeachingAssistant> getStaff() {
		return teachingassistants;
	}
	public void addStaff(TeachingAssistant staff) {
	    teachingassistants.add(staff);
	}
	public ArrayList<Student> getStudent() {
		return students;
	}
	public void addStudent(Student student) {
	    	students.add(student);
	}
	@Override
	public String toString() {
		return "Course [course_code=" + course_code + ", course_name=" + course_name + ", year=" + year + ", semester="
				+ semester + ", capacity=" + capacity + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
