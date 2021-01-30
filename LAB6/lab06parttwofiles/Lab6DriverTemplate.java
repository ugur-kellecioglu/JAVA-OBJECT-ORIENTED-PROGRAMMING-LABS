import java.util.ArrayList;
import java.util.Scanner;

//Draws simple shapes
public class Lab6DriverTemplate {
	
	public static void main(String[] args) {
		ArrayList<ShapeGroup> shapeGroups = new ArrayList<ShapeGroup>();
		ShapeGroup universalShapes = new ShapeGroup();
		shapeGroups.add(universalShapes);
		//GRAPHICS: The next line will be removed or commented out before submission to Moodle
		//DrawingTool window = new DrawingTool(shapeGroups);
		
		Scanner scan = new Scanner(System.in);
		String userCommand = "";
				
		while (! userCommand.equalsIgnoreCase("exit")) {
			System.out.print("Enter the command: ");
			userCommand = scan.nextLine();

			String [] parameters = userCommand.split(" ");
			String command = parameters[0];
			
			if (command.equals("addR")) {
						
			}
			else if (command.equals("addS")) {
						
			}
			else if (command.equals("addC")) {
					
			}
			else if (command.equals("move")) {
				
			}else if (command.equals("createEmptyGroup")) {
				
			}else if(command.equals("addToGroup")) {
				
			}else if(command.equals("moveGroup")) {
			
			}else if(command.equals("switchGroup")) {
				
			}else if(command.equals("mergeGroups")) {
				
				
				
			}
			
			//GRAPHICS: The next line will be removed or commented out before submission to Moodle
			//window.repaint();
			
		}		
		scan.close();
		System.exit(0);
	}

}