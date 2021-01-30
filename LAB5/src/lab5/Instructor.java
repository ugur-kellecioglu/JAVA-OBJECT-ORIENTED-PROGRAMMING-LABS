package lab5;

import java.util. * ;

public class Instructor extends AcademicStaff {


  private String title;
  private ResearchAssistant ra = null;
  
  public Instructor(String instructor_name, String instructor_id, String office_number, String title) {

    super(instructor_name, instructor_id, office_number);
    this.title = title;
    
    
    
  }
  
  

  public ResearchAssistant getRa() {
    return ra;
}



public void setRa(ResearchAssistant ra) {
    this.ra = ra;
}



public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

}