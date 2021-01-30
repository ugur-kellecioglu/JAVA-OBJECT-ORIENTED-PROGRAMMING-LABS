/**
 * 
 */
package lab6;

import java.awt.Point;

/**
 * @author ugurk
 *
 */
public class Circle extends Shape{

    /**
     * 
     */
    private int radius;

    public Circle(int x_left_top, int y_left_top, int radius) {
	// TODO Auto-generated constructor stub
	super(x_left_top, y_left_top);
	this.radius = radius;
	isCircular = true;
	area = calculateArea();
	perimeter = calculatePerimeter();
	calculatePoints();
	
    }

    
    public double getRadius() {
        return radius;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }



    @Override
    public void calculatePoints() {
	
	rightTop = new Point(( (int) getLeftTop().getX() + (2*radius)), ((int) getLeftTop().getY()));
	rightBottom = new Point( (int) getLeftTop().x + (2*radius), (int) getLeftTop().y + (2*radius) );
	leftBottom = new Point((int) getLeftTop().x , (int) getLeftTop().y + (2*radius));
	getPoints().add(rightTop);
	getPoints().add(rightBottom);
	getPoints().add(leftBottom);
	
    }

    @Override
    public double calculateArea() {
	// TODO Auto-generated method stub
	double d = Math.PI * Math.pow(radius, 2);
	d = Math.round(d * 10) / 10.0; 
	
	return d;
    }

    @Override
    public double calculatePerimeter() {
	double d = 2 * Math.PI * radius;
	d = Math.round(d * 10) / 10.0;
	return d;
    }


    @Override
    public String toString() {
	
	String result = "\nCircle[r=" + radius + "]\nPoints[";
	
	result += "(" + (int) points.get(0).getX() + "," + (int) points.get(0).getY() + ")";
	result += "(" + (int) points.get(2).getX() + "," + (int) points.get(2).getY() + ")";
	
	
	result += "]\nArea=" + area + "\nPerimeter=" + perimeter ;
	
	return result;
    }
    
}
