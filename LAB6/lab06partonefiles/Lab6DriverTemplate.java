import java.util.ArrayList;
import java.util.Scanner;

//Draws simple shapes
public class Lab6DriverTemplate {
	
	public static void main(String[] args) {
		//TODO: Implement your own Shape class according to the Lab3 description
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		//GRAPHICS: The next line will be removed or commented out before submission to Moodle, we will provide
		//and talk about the DrawingTool class during lab hours to introduce graphics support
		//DrawingTool window = new DrawingTool(shapes);
			
		Scanner scan = new Scanner(System.in);
		String userCommand = "";
				
		while (! userCommand.equalsIgnoreCase("exit")) {
			System.out.print("Enter the command: ");
			userCommand = scan.nextLine();

			String [] parameters = userCommand.split(" ");
			String command = parameters[0];
			
			if (command.equals("addR")) {
				//TODO: Read parameters and create a Rectangle object
				
				//TODO: Add the object to the shapes list
				
				//TODO: Print the object
			}
			else if (command.equals("addS")) {
				//TODO: Read parameters and create a Square object
				
				//TODO: Add the object to the shapes list
				
				//TODO: Print the object				
			}
			else if (command.equals("addC")) {
				//TODO: Read parameters and create a Circle object
				
				//TODO: Add the object to the shapes list
				
				//TODO: Print the object				
			}
			else if (command.equals("move")) {
				//Read parameters
				int shapeNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				
				//TODO: Implement your own Movable interface according to the Lab4 example
				Movable sm = shapes.get(shapeNo-1);
				
				//TODO: Move the object by calling the move method				
				
				//TODO: Print the object
				
			}
			
			//GRAPHICS: The next line will be removed or commented out before submission to Moodle
			//window.repaint();
			
		}		
		scan.close();
		System.exit(0);
	}

}
