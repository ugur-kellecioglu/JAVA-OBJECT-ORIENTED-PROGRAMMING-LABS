package lab6;

import java.awt.Point;

public class Square extends Shape {
    
    private int edge_length;
    
   
    
    public Square(int x_left_top, int y_left_top, int edge_length) {
	super(x_left_top, y_left_top);
	this.edge_length = edge_length;
	
	area = calculateArea();
	perimeter = calculatePerimeter();
	calculatePoints();
    }


    public double getEdge_length() {
        return edge_length;
    }

    public void setEdge_length(int edge_length) {
        this.edge_length = edge_length;
    }


 

    @Override
    public void calculatePoints() {
	
	rightTop = new Point(( (int) getLeftTop().getX() +edge_length), ((int) getLeftTop().getY()));
	rightBottom = new Point( (int) getLeftTop().x + edge_length, (int) getLeftTop().y + edge_length );
	leftBottom = new Point((int) getLeftTop().x , (int) getLeftTop().y + edge_length);
	getPoints().add(rightTop);
	getPoints().add(rightBottom);
	getPoints().add(leftBottom);
    }

    @Override
    public double calculateArea() {
	double d = Math.pow(edge_length, 2);
	d = Math.round(d * 10) / 10.0;
	return d;
	
    }

    @Override
    public double calculatePerimeter() {
	// TODO Auto-generated method stub
	
	double d = 4 * edge_length;
	d = Math.round(d * 10) / 10.0;
	return d;
    }


    @Override
    public String toString() {
	
	String result = "\nSquare[e=" + edge_length + "]\nPoints[";
	
	for(Point p : getPoints()) {
	    result += "(" + (int) p.getX() + "," + (int) p.getY() + ")";
	
	}
	
	result += "]\nArea=" + area + "\nPerimeter=" + perimeter ;
	
	return result;
    }


    
    

}
