/**
 * 
 */
package lab6;

import java.awt.Point;

/**
 * @author ugurk
 *
 */
public class Rectangle extends Shape {

    /**
     * 
     */
    private int height;
    private int width;
  
    public Rectangle(int x_left_top, int y_left_top, int height, int width) {
	// TODO Auto-generated constructor stub
	super(x_left_top, y_left_top);
	this.height = height;
	this.width = width;

	area = calculateArea();
	perimeter = calculatePerimeter();
	calculatePoints();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void calculatePoints() {
	
	rightTop = new Point(( (int) getLeftTop().getX() +width), ((int) getLeftTop().getY()));
	rightBottom = new Point( (int) getLeftTop().x + width, (int) getLeftTop().y + height );
	leftBottom = new Point((int) getLeftTop().x , (int) getLeftTop().y + height);
	getPoints().add(rightTop);
	getPoints().add(rightBottom);
	getPoints().add(leftBottom);
    }

    @Override
    public double calculateArea() {
	
	double d = height * width;
	d = Math.round(d * 10) / 10.0;
	return d;
    }

    @Override
    public double calculatePerimeter() {
	// TODO Auto-generated method stub
	 ;
	double d = 2 * ( height + width);
	d = Math.round(d * 10) / 10.0;
	return d;
    }

    @Override
    public String toString() {
	String result = "\nRectangle[h=" + height + ",w=" + width + "]\nPoints[";
	
	for(Point p : getPoints()) {
	    result += "(" + (int) p.getX() + "," + (int) p.getY() + ")";
	
	}
	
	result += "]\nArea=" + area + "\nPerimeter=" + perimeter ;
	
	return result;
    }

}
