package lab6;

import java.awt.Point;
import java.util.ArrayList;

public class ShapeGroup {
    
    private ArrayList<Shape> shapes;
    private Point leftTop;
    private static int i;
    public ShapeGroup() {
	

	shapes = new ArrayList<Shape>();
	this.i = 1;
    }
    
    public void addShape(Shape newOne) {
	shapes.add(newOne);
    }
    public Shape getShape(int idx) {
	return shapes.get(idx);
    }
    public ArrayList<Shape> getGroup(){
	return shapes;
    }
    
    public void moveGroup(int newx,int newy) {
	
	for (Shape s : shapes) {
	  
	int x = leftTop.x - newx;
	int y = leftTop.y - newy;
	   
	 
	  
	s.leftTop.x = s.leftTop.x - x;
	s.leftBottom.x = s.leftBottom.x - x;
	s.rightBottom.x = s.rightBottom.x - x;
	s.rightTop.x = s.rightTop.x - x;
	    
	    
	    
	    
	s.leftTop.y = s.leftTop.y - y;
	s.leftBottom.y = s.leftBottom.y - y;
	s.rightBottom.y = s.rightBottom.y - y;
	s.rightTop.y = s.rightTop.y - y;
	    
	}
	leftTop = new Point(newx, newy);
	
    }
 
    public void findLeftTop() {
	
	int minx = 9999;
	int miny = 9999;
	for(Shape s: shapes) {
	   if (minx >  s.getLeftTop().x) {
	       minx =  s.getLeftTop().x;
	   }
	   
	   if(miny > s.getLeftTop().y) {
	       miny = s.getLeftTop().y;
	   }
	}
	leftTop = new Point(minx, miny);
	
	System.out.println("\nLeft Top Point: x: " + leftTop.x + ", y: " + leftTop.y);
	
    }
    public Shape removeShape(int idx) {
	return shapes.remove(idx);
    }
    
    public double totalPerimeter() {
	double perimeter = 0;
	
	for(Shape shape: shapes) {
	    perimeter += shape.perimeter;
	}
	
	return perimeter;
    }

}
