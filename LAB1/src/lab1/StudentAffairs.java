package lab1;


import java.util.*;

public class StudentAffairs {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		List<Student> students = new ArrayList<Student>();
		List<Course> courses = new ArrayList<Course>();
				
		int studentNumber = 0;
		int courseNumber = 0;
	 	 do {
	 		System.out.println("Enter a command: ");
	 		input = keyboard.nextLine();
	 		String[] commands = input.split("\\s+");
	 		String fnc = commands[0];
	 		
	 		if(fnc.equals("createStudent")) {
	 			students.add(new Student(commands[1], commands[2]));
	 			System.out.println("Student " + students.get(studentNumber).toString() + " successfully added.");
	 			studentNumber++;
	 		}
	 		
	 		if(fnc.equals("addGradeStudent")) {
	 			for( Student student: students) {
					if (student.getId().equals(commands[1]))
					{	
						
						if (student.addGrade(commands[2]) )
						{
							System.out.println("Success");
						}
						else {
							System.out.println("Capacity(4) reached.");
						}
					}
				}
	 		}
	 		
	 		if(fnc.equals("averageGradeStudent")) {
	 			for( Student student: students) {
					if (student.getId().equals(commands[1]))
					{	
						System.out.println("Average Grade of Student " + student.toString() + " is " + student.averageGrade());
					}
				}
	 		}
	 		
	 		if(fnc.equals("printGradesStudent")) {
	 			for( Student student: students) {
					if (student.getId().equals(commands[1]))
					{	
						System.out.println(student.printGrades());
					}
				}
	 		}
	 		
	 		if(fnc.equals("removeGradeStudent")) {
	 			for( Student student: students) {
					if (student.getId().equals(commands[1]))
					{	
						
						if(student.removeGrade(Integer.parseInt(commands[2])))
						{
							System.out.println("Success");
						}
						else {
							System.out.println("Grade count already zero or wrong index");
						}
					}
				}
	 		}
	 		
	 		if(fnc.equals("createCourse")) {
	 			
	 			courses.add(new Course(commands[1], commands[3], Integer.parseInt(commands[4]),Integer.parseInt(commands[2]), Double.parseDouble(commands[5])));
	 			System.out.println("Course " + courses.get(courseNumber).getCourseCode() + " successfully added.");
	 			courseNumber++;
	 		}
	 	 
	 		if(fnc.equals("addGradeCourse")) {
	 			for( Course course: courses) {
					if( course.getCourseCode().equals(commands[1])) {
						
						if(course.addGrade(Double.parseDouble(commands[2])))
						{
							System.out.println("Success");
						}
						else {
							System.out.println("Capacity("+ course.getCapacity()  +  ") reached.");
						}
					}
				}
	 		}
	 		
	 		
	 		if(fnc.equals("averageGradeCourse")) {
	 			for( Course course: courses) {
					if( course.getCourseCode().equals(commands[1])) {
						System.out.println("Average Grade of Course " + course.getCourseCode() + " is " + course.getAverageGrade());
						
					}
				}
	 		}
	 		
	 		if(fnc.equals("removeGradeCourse")) {
	 			for( Course course: courses) {
					if( course.getCourseCode().equals(commands[1])) {
						
						if (course.removeGrade(Double.parseDouble(commands[2])))
						{
							System.out.println("Success");
						}
						else {
							System.out.println("Number of student in course is already 0.");
						}
					}
				}
	 		}
	 		
	 		
	 	}
	 	while(!input.equals("Q"));

	 
	}

}
