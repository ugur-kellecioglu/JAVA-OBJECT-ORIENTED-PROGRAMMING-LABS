package lab5;

public class ResearchAssistant extends Assistant{
    
    private Instructor ins = null;
    public ResearchAssistant(String name, String id, String office_number, String degree) {
   	super(name, id, office_number, degree);
   	
    }
    public Instructor getIns() {
        return ins;
    }
    public void setIns(Instructor ins) {
        this.ins = ins;
    }
    
}
