package lab6;
import java.util.ArrayList;
import java.util.Scanner;

//Draws simple shapes
public class Lab6DriverTemplate {
	
	public static void main(String[] args) {
		
	    	ArrayList<ShapeGroup> shapeGroups = new ArrayList<ShapeGroup>();
		ShapeGroup universalShapes = new ShapeGroup();
		shapeGroups.add(universalShapes);
		//GRAPHICS: The next line will be removed or commented out before submission to Moodle
		DrawingTool window = new DrawingTool(shapeGroups);
		
		Scanner scan = new Scanner(System.in);
		String userCommand = "";
		
		while (! userCommand.equalsIgnoreCase("exit")) {
			System.out.print("Enter the command: ");
			userCommand = scan.nextLine();

			String [] parameters = userCommand.split(" ");
			String command = parameters[0];
			
			if (command.equals("addR")) {
			    
			    Shape rec = new Rectangle(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2])
					, Integer.parseInt(parameters[3]), Integer.parseInt(parameters[4]));
			    
			    shapeGroups.get(0).addShape(rec);
			    System.out.println(rec.toString());
			    
			}
			else if (command.equals("addS")) {
			    Shape sq = new Square(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2])
					, Integer.parseInt(parameters[3]));
			    
			    shapeGroups.get(0).addShape(sq);
			    System.out.println(sq.toString());				
			}
			else if (command.equals("addC")) {
			    Shape circ = new Circle(Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2])
					, Integer.parseInt(parameters[3]));
			    
			    shapeGroups.get(0).addShape(circ);
			    System.out.println(circ.toString());				
			}
			else if (command.equals("move")) {
				//Read parameters
				int shapeNo = Integer.parseInt(parameters[1]);
				int x = Integer.parseInt(parameters[2]);
				int y = Integer.parseInt(parameters[3]);
				
				//TODO: Implement your own Movable interface according to the Lab4 example
				Movable sm = shapeGroups.get(0).getShape(shapeNo-1);
				
				//TODO: Move the object by calling the move method				
				sm.move(x, y);
				//TODO: Print the object
				System.out.println(sm.toString());
				
			}
			else if (command.equals("createEmptyGroup")) 
			{
			  
			    ShapeGroup sg = new ShapeGroup();
			    shapeGroups.add(sg);
			    System.out.println("\nNew Group Added.");
				
			}
			else if(command.equals("addToGroup")) {
			    // addToGroup 1 4
			    int groupNo = Integer.parseInt(parameters[1]);
			    int shapeNo = Integer.parseInt(parameters[2]);
			    shapeGroups.get(groupNo).addShape(shapeGroups.get(0).getShape(shapeNo - 1));
			    shapeGroups.get(groupNo).findLeftTop();
			    System.out.println("Total Perimeter: " + shapeGroups.get(groupNo).totalPerimeter());
			    for(int i = 0 ; i < shapeGroups.get(groupNo).getGroup().size(); i++) {
				System.out.println("Shape "+ (i+1) + ":");
				System.out.println(shapeGroups.get(groupNo).getGroup().get(i).toString());;
			    }
			    
			    shapeGroups.get(0).removeShape(shapeNo - 1);
			}
			else if(command.equals("moveGroup")) {
			    int groupNo = Integer.parseInt(parameters[1]);
			    int x = Integer.parseInt(parameters[2]);
			    int y = Integer.parseInt(parameters[3]);

			    shapeGroups.get(groupNo).moveGroup(x, y);

			    shapeGroups.get(groupNo).findLeftTop();
			    System.out.println("Total Perimeter: " + shapeGroups.get(groupNo).totalPerimeter());
			    for(int i = 0 ; i < shapeGroups.get(groupNo).getGroup().size(); i++) {
				System.out.println("Shape "+ (i+1) + ":");
				System.out.println(shapeGroups.get(groupNo).getGroup().get(i).toString());;
			    }
			
			}else if(command.equals("switchGroup")) {
			    //switchGroup <Previous_Group_No> <New_Group_No> <Shape_No>
			    int prev_group_no = Integer.parseInt(parameters[1]);
			    int new_group_no = Integer.parseInt(parameters[2]);
			    int shape_no = Integer.parseInt(parameters[3]);
			    
			    shapeGroups.get(new_group_no).addShape(shapeGroups.get(prev_group_no).getShape(shape_no - 1));
			    shapeGroups.get(prev_group_no).removeShape(shape_no - 1);
			    
			    shapeGroups.get(new_group_no).findLeftTop();
			    System.out.println("Total Perimeter: " + shapeGroups.get(new_group_no).totalPerimeter());
			    for(int i = 0 ; i < shapeGroups.get(new_group_no).getGroup().size(); i++) {
				System.out.println("Shape "+ (i+1) + ":");
				System.out.println(shapeGroups.get(new_group_no).getGroup().get(i).toString());;
			    }
			    shapeGroups.get(prev_group_no).findLeftTop();
			    System.out.println("Total Perimeter: " + shapeGroups.get(prev_group_no).totalPerimeter());
			    for(int i = 0 ; i < shapeGroups.get(prev_group_no).getGroup().size(); i++) {
				System.out.println("Shape "+ (i+1) + ":");
				System.out.println(shapeGroups.get(prev_group_no).getGroup().get(i).toString());;
			    }
			    
			    
				
			}
			else if(command.equals("mergeGroups")) {
				
			    int group_one = Integer.parseInt(parameters[1]);
			    int group_two = Integer.parseInt(parameters[2]);
			    int temp;
			    if(group_one > group_two) {
				temp = group_one;
				group_one = group_two;
				group_two = temp;
			    }
			    
			    int group_size = shapeGroups.get(group_two).getGroup().size();
			    for(int i = 0 ; i < group_size ; i++ ) {
				shapeGroups.get(group_one).addShape(shapeGroups.get(group_two).getGroup().get(i));
				shapeGroups.get(group_two).getGroup().remove(i);
				group_size--;
				i--;
			    }
			   shapeGroups.get(group_one).findLeftTop();
			   System.out.println("Total Perimeter: " + shapeGroups.get(group_one).totalPerimeter());
			   for(int i = 0 ; i < shapeGroups.get(group_one).getGroup().size(); i++) {
				System.out.println("Shape "+ (i+1) + ":");
				System.out.println(shapeGroups.get(group_one).getGroup().get(i).toString());;
			    }
				
			}
			
			//GRAPHICS: The next line will be removed or commented out before submission to Moodle
			window.repaint();
			
		}		
		scan.close();
		System.exit(0);
	}

}
