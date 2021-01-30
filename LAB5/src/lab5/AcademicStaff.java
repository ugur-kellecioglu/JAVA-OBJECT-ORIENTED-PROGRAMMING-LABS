package lab5;

import java.util.ArrayList;

public class AcademicStaff extends Member {
    
    private String office_number;
    
   
    public AcademicStaff(String name, String id, String office_number) {
	super(name, id);
	this.office_number = office_number;
	
	
	
    }
    
    
    
    public String getOffice_number() {
	return office_number;
    }
    public void setOffice_number(String office_number) {
	 this.office_number = office_number;
    }
    
    
}
