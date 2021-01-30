package lab5;

import java.util.ArrayList;

public  class Member {

    private String name;
    private String id;
    private ArrayList < Course > courses;

    
    public Member(String name, String id) {
	this.name = name;
	this.id = id;
	courses = new ArrayList < Course > ();
	
    }
    public String getId() {
	
	return id;
    }
    
    public String getName() {
	
	return this.name;
    }
    public void addCourse(Course c) {
	this.courses.add(c);
    }
    public ArrayList < Course > getCourses() {
	return this.courses;
    }
    public int getCourseNumber() {
	return courses.size();

    }
}
