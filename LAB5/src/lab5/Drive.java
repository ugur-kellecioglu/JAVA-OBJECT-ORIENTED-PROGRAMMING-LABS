package lab5;

import java.util. * ;
public class Drive {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System. in );
    int program_year = 2020;
    System.out.println("Program Year: " + program_year);
    String[] input = keyboard.nextLine().split(";");
    String command = input[0];
    ArrayList < Course > courses = new ArrayList < Course > ();
    ArrayList < Instructor > instructors = new ArrayList < Instructor > ();
    ArrayList < TeachingAssistant > teachingassistants = new ArrayList < TeachingAssistant > ();
    ArrayList < ResearchAssistant > researchassistants = new ArrayList < ResearchAssistant > ();
    ArrayList < Student > students = new ArrayList < Student > ();
    ArrayList < Member > members  = new ArrayList < Member >();
        
    do {
      switch (command) {

      case "create":
        if (input[1].equals("course")) {
          boolean find_one = false;
          for (Course course: courses) {
            String code = course.getCourse_code();
            if (input[2].equals(code)) {
              find_one = true;
            }

          }
          if (find_one == true) {
            System.out.println("A course with code " + input[2] + " already exists.");
          }
          else {
            courses.add(new Course(input[2], input[3], Integer.parseInt(input[4]), input[5], Integer.parseInt(input[6])));
            System.out.println("success");
          }
        }
        else if (input[1].equals("instructor")) {
          boolean check_instructor = false;
          for (Member i: members) {
            if (i.getId().equals(input[3])) {
              check_instructor = true;
            }
          }
          if (check_instructor == false) {
            Instructor instructor = new Instructor(input[2], input[3], input[4], input[5]);
            instructors.add(instructor);
            members.add(instructor);
            System.out.println("success");
          }
          else {
            System.out.println("A person with ID " + input[3] + " already exists.");
          }
          break;
        }
        else if (input[1].equals("TA") || input[1].equals("ta")) {
            boolean check_academicstaff = false;
            for (Member i: members) {
              if (i.getId().equals(input[3])) {
        	  check_academicstaff = true;
              }
            }
            if (check_academicstaff == false) {
        	TeachingAssistant  teachingassistant = new TeachingAssistant(input[2], input[3], input[4], input[5]);
        	teachingassistants.add(teachingassistant);
        	members.add(teachingassistant);
        	System.out.println("success");
            }
            else {
        	System.out.println("A person with ID " + input[3] + " already exists.");
            }
            break;
        }
        else if (input[1].equals("ra") || input[1].equals("RA")) {
            boolean check_academicstaff = false;
            for (Member i: members) {
              if (i.getId().equals(input[3])) {
        	  check_academicstaff = true;
              }
            }
            if (check_academicstaff == false) {
        	ResearchAssistant  researchassistant = new ResearchAssistant(input[2], input[3], input[4], input[5]);
        	researchassistants.add(researchassistant);
        	members.add(researchassistant);
        	System.out.println("success");
            }
            else {
        	System.out.println("A person with ID " + input[3] + " already exists.");
            }
            break;
        }
        else if (input[1].equals("student")) {
            boolean check_student = false;
            for (Member i: members) {
              if (i.getId().equals(input[3])) {
        	  check_student = true;
              }
            }
            if (check_student == false) {
        	Student  student = new Student(input[2], input[3], input[4]);
        	students.add(student);
        	members.add(student);
        	System.out.println("success");
            }
            else {
        	System.out.println("A person with ID " + input[3] + " already exists.");
            }
            break;
        }


        break;

      case "report":
        if (input[1].equals("course")) {
          for (Course course:
          courses) {
            if (course.getCourse_code().equals(input[2])) {
              System.out.println(course.getCourse_code() + " - " + course.getCourse_name() + " - " + course.getYear() + course.getSemester().toUpperCase(Locale.ENGLISH));
              System.out.println("Capacity: " + course.getCapacity());
              if (course.getIns() == null) {
                System.out.println("Lecturer: Not Assigned Yet.");
              }
              else {
                System.out.println("Lecturer: " + course.getIns().getTitle() + " " + course.getIns().getName());
              }
          
              if (course.getStaff().size()==0) {
        	  System.out.println("Teaching Assistants: None");
              }
              else {
        	  System.out.println("Teaching Assistants:");
                  for(AcademicStaff staff: course.getStaff()) {
                     
                      System.out.println(staff.getName());
                  }
                  
              }
              if(course.getStudent().size() != 0) {
                  System.out.print("Roster:");
                  String roster = "";
                  for(Student i : course.getStudent()) {
                      roster += (i.getName() + ", ");
                  }
                  
                  System.out.println(roster.substring(0,roster.length()-2));
              }
              break;
            }
          }
        }
        else if (input[1].equals("instructor")) {

          for (Instructor instructor: instructors) {
            if (instructor.getId().equals(input[2])) {
              System.out.println(instructor.getTitle() + " " + instructor.getName() + " - " + instructor.getId() + " @" + instructor.getOffice_number());
              for (Course course: instructor.getCourses()) {
                if(course.getYear() == program_year) {
                    System.out.println(course.getCourse_code() + " - " + course.getCourse_name());
                    
                }
              }
              if(instructor.getRa() == null) System.out.println("Assistant= None");
              else System.out.println("Assistant= " + instructor.getRa().getName());
              break;
            }
          }
        }
        else if(input[1].equals("ta")|| input[1].equals("TA")) {
            for ( TeachingAssistant staff : teachingassistants ) {
        	if ( staff.getId().equals( input[2] )) {
        	    System.out.println( "(" + staff.getDegree() + ") " + staff.getName() + " - " + staff.getId()+" " 
        		    +"@"+staff.getOffice_number());
        	    for( Course course: staff.getCourses()) {
        		if(course.getYear() == program_year) {
        		    System.out.println(course.getCourse_code() + " - " + course.getCourse_name() );
        		}
        	    }
        	}
            }
        }
        else if(input[1].equals("ra")|| input[1].equals("RA")) {
            for ( ResearchAssistant ra : researchassistants ) {
        	if ( ra.getId().equals( input[2] )) {
        	    System.out.println( "(" + ra.getDegree() + ") " + ra.getName() + " - " + ra.getId()+" " 
        		    +"@"+ra.getOffice_number());
        	    for(Instructor i : instructors) {
        		if(ra == i.getRa()) {
        		    System.out.println("Assistant of " + i.getTitle() + " " + i.getName());
        		}
        		
        	    }
        	}
            }
        }
        else if (input[1].equals("student")) {
            for (Student student: students) {
        	if(student.getId().equals(input[2])) {
        	    System.out.println(student.getYear() + " " + student.getName()+ " - " + student.getId());
        	    
        	    if(student.getCourses().size() > 0) {
        		System.out.print("Courses: ");
        		for(Course course: student.getCourses()) {
        		    if(course.getYear() == program_year) {
        			System.out.println(course.getCourse_code());
        		    }
        		}
        	    }
        	}
        
            }
        }
        else {
          System.out.println("Unknown command");
        }

        break;

      case "assign":
        if (input[1].equals("course")) {

        }
        else if (input[1].equals("instructor") || input[1].equals("Instructor")) {
          Course temp;
          for (Instructor instructor: instructors) {
            String id = instructor.getId();
            if (id.equals(input[2])) {
              if (instructor.getCourseNumber() < 3) {
                for (Course course: courses) {
                  if (input[3].equals(course.getCourse_code())) {
                    if (course.getIns() != null) {
                      System.out.println("Instructor " + course.getIns().getTitle() + " " + course.getIns().getName() 
                	      + " is already teaching " + course.getCourse_code() + " - " + course.getCourse_name() + ".");
                      break;
                    }
                    else {

                      temp = course;
                      instructor.addCourse(temp);
                      course.setIns(instructor);
                      System.out.println("success");
                      break;
                    }
                  }

                }

              }
              
              else {
                System.out.println(instructor.getId() + " - " + instructor.getName() + " cannot teach more than 3 courses.");
              }

              break;
            }
          }
        }
        else if (input[1].equals("student")) {
  	 
  	  boolean ch = false;
  	  for ( Student student: students) {
  	      if (student.getId().equals(input[2])) {
  		  for(Course course: courses) {
  		       if(course.getCourse_code().equals(input[3])) {
  			   if(course.getCapacity() > course.getStudent().size() ) {
  			     for(Student st: course.getStudent()) {
    			       if (st.getId().equals(student.getId())) {
    				   ch = true;
    				   System.out.println("It is already taking that class.");
    				   break;
    			       }
    			   }
    			
        			   if(!ch) {
        			       
        			       student.addCourse(course);
        			       course.addStudent(student);
        			       System.out.println("success");
        			   }
  			  }
  			   else {
  			      System.out.println(course.getCourse_name() + " is full.");
  			   }
  			   
  		       }
  		       
  		  }
  	      }
  	  }
        }
        else if (input[1].equals("TA") || input[1].equals("ta")) {
            boolean ch = false;
            Course temp;
            
            for(Instructor c: instructors) {
        	if(input[3].equals(c.getId())) {
        	    System.out.println("Teaching assistants cannot assign to any instructors.");
        	    ch = true;
        	}
            }
            for (TeachingAssistant teachingassistant: teachingassistants) {
              String id = teachingassistant.getId();
              if(ch==true) break;
              if (id.equals(input[2])) {
        	  
        	  TeachingAssistant ta = null;
        	  Course c = null;
                  for (Course course: courses) {
                    if (input[3].equals(course.getCourse_code())) {
                	boolean checkStaff = false;
                	
                	    for(TeachingAssistant staff : course.getStaff()) {
                		
                		if(staff.getId().equals(input[2])) {
                		    checkStaff = true;
                		    c = new Course(course.getCourse_code(), course.getCourse_name(), course.getYear(), course.getSemester(), course.getCapacity());
                		    ta = new TeachingAssistant(staff.getName(), staff.getId(), staff.getOffice_number(), staff.getDegree());
                		}
                	    }
                	    
                	
                	if(checkStaff == false) {
                	    temp = course;
                	    teachingassistant.addCourse(temp);
                            course.addStaff(teachingassistant);
                            System.out.println("success");
                            break;
                	}
                	else {
                	    System.out.println("Assistant " + ta.getName() + " is already teaching " 
                	+ c.getCourse_code() + " - "+ c.getCourse_name() + ".");
                	}
                    }
                  }

               }

            }
        }
        else if (input[1].equals("RA") || input[1].equals("ra")) {
            
            boolean ch = false;
            for(Course i: courses) {
        	if(input[3].equals(i.getCourse_code())) {
        	    System.out.println("Research assistants cannot assign to any course.");
        	    ch = true;
        	}
            }
            for (ResearchAssistant researchassistant: researchassistants) {
        	if (ch == true) break;
              String id = researchassistant.getId();
              if (id.equals(input[2])) {
        	  
                      for (Instructor i: instructors) {
                          if (input[3].equals(i.getId())) {
                      	
                      	if(i.getRa() != null) {
                      	    //Instructor Asst.Prof. Tayfun Kucukyilmaz already has an assistant.  
                      	    System.out.println("Instructor" + i.getTitle() + " " + i.getName() + " already has an assistant.");
                      	}
                      	else {
                      	    i.setRa(researchassistant);
                      	    researchassistant.setIns(i);
                      	    System.out.println("success");
                      	}
                      	    
                          }
                         }
                    }
                  }

               }

        
        break;
      
      case "change":
	  
	  if(input[1].equals("year")){
	      program_year = Integer.parseInt(input[2]);
	  }
	  System.out.println("success");
	  System.out.println("Program Year: " + program_year);
	  break;
      default:
        if (input[0].equals("exit")) break;
        System.out.println("Unknown command");
        break;
      }
      if (input[0].equals("exit")) break;
      input = keyboard.nextLine().split(";");
      command = input[0];
    }
    while (! input [ 0 ].equals("exit"));
    
  
  }

}