package lab6;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape implements Movable {
    protected Point leftTop;
    protected boolean isCircular = false;
    protected ArrayList < Point > points;
    protected double area;
    protected double perimeter;
    protected Point rightTop, rightBottom, leftBottom, tmpPoint;
    public Shape(int x_left_top, int y_left_top) {
	points = new ArrayList < Point >();
	leftTop = new Point(x_left_top, y_left_top);
	points.add(leftTop);
	
	
    }
    public void move(int a, int b) {
	/*
	 * int x = leftTop.x - newx;
	   int y = leftTop.y - newy;
	   
	 
	    if(x > 0) {
		s.leftTop.x = s.leftTop.x - x;
		s.leftBottom.x = s.leftBottom.x - x;
		s.rightBottom.x = s.rightBottom.x - x;
		s.rightTop.x = s.rightTop.x - x;
	    }
	    else if(x < 0){
		s.leftTop.x = s.leftTop.x - x;
		s.leftBottom.x = s.leftBottom.x - x;
		s.rightBottom.x = s.rightBottom.x - x;
		s.rightTop.x = s.rightTop.x - x;
	    }
	    
	    if(y > 0) {
		s.leftTop.y = s.leftTop.y - y;
		s.leftBottom.y = s.leftBottom.y - y;
		s.rightBottom.y = s.rightBottom.y - y;
		s.rightTop.y = s.rightTop.y - y;
	    }
	    else if(y < 0){
		s.leftTop.y = s.leftTop.y - y;
		s.leftBottom.y = s.leftBottom.y - y;
		s.rightBottom.y = s.rightBottom.y - y;
		s.rightTop.y = s.rightTop.y - y;
	    }*/
	    int x = leftTop.x - a;
	    int y = leftTop.y - b;
	   
	 
	  
	this.leftTop.x = this.leftTop.x - x;
	this.leftBottom.x = this.leftBottom.x - x;
	this.rightBottom.x = this.rightBottom.x - x;
	this.rightTop.x = this.rightTop.x - x;
	    
	     
	    
	
	this.leftTop.y = this.leftTop.y - y;
	this.leftBottom.y = this.leftBottom.y - y;
	this.rightBottom.y = this.rightBottom.y - y;
	this.rightTop.y = this.rightTop.y - y;
	    
	    
	
	
    }
    public abstract void calculatePoints();
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract String toString();
    public Point getLeftTop() {
        return leftTop;
    }
    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop;
    }
    public boolean isCircular() {
        return isCircular;
    }
    public void setCircular(boolean isCircular) {
        this.isCircular = isCircular;
    }
    public ArrayList<Point> getPoints() {
        return points;
    }
    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
    
    
}
