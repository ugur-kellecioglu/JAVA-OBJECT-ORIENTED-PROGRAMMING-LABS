package lab5;

public class Assistant extends AcademicStaff{
    private String degree;
    
    
    public Assistant(String name, String id, String office_number, String degree) {
	super(name, id, office_number);
	this.degree = degree;
    }
    
    
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
