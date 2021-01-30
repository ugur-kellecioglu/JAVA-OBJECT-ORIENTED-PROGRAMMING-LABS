
package lab4;

import java.util.*;


public class InventoryProgram {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String [] input = keyboard.nextLine().split(" ");
		String cmd = input[0];
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Grocery> groceryList = new ArrayList<Grocery>();
		Hashtable<Integer,ArrayList<Grocery>> hm=new Hashtable<Integer,ArrayList<Grocery>>();  

		Product prod;
		Grocery groc;
		do {
			switch(cmd) {
			case "np":
				
				String name = input[1];
				String type = input[2];
				int cost = Integer.parseInt(input[3]);
				prod = new Product(name, type, cost);
			
				productList.add(prod);
				
				System.out.println("Created " +prod);
				break;
			case "lp":
				int sz = productList.size();
				for(int i = 0 ; i < sz; i++) {
					
					System.out.println(productList.get(i));
				}
				break;
			
			case "ns":
				int itemNo = Integer.parseInt(input[1]);
				int amount = Integer.parseInt(input[2]);
				int salePrice = Integer.parseInt(input[3]);
				Product selling_product = productList.get(itemNo - 1);
				
				//Product.productNo = itemNo;
				if(salePrice < selling_product.getCost()) {
					System.out.println("Warning, sale price is lower than product cost ");
				}
				System.out.println("Now selling " + selling_product + ", selling at " 
								+ salePrice + "$ with " + amount + " left");
				groc = new Grocery(selling_product, salePrice, amount);
				if(!hm.containsKey(itemNo)){
					ArrayList<Grocery> arr_list = new ArrayList<Grocery>();
					arr_list.add(groc);
					hm.put(itemNo, arr_list);
				}
				else {
					hm.get(itemNo).add(groc);
				}
				groceryList.add(groc);
				
				
				break;
			case "ls":
				
				sz = groceryList.size();
				for(int i = 0 ; i < sz; i++) {
					int min = 9;
					for(int j = 0 ; j < sz; j++) {
						String n = groceryList.get(i).getProduct().getName();
						String n2 = groceryList.get(j).getProduct().getName();
						if(n.equals(n2) && min > j) {
							min = j + 1;
						}
					}
					//Product.productNo =min;
					System.out.println(groceryList.get(i).getProduct() +", selling at " 
							+ groceryList.get(i).getPrice() + "$ with " + groceryList.get(i).getAmount() + " left" );
				}
				break;
			case "sp":
				int product_no = Integer.parseInt(input[1]);
				int selling_amount = Integer.parseInt(input[2]);
				int selling_price = Integer.parseInt(input[3]);
				
				//Product pr = productList.get(product_no);
				ArrayList<Grocery> gr = new ArrayList<Grocery>(hm.get(product_no));
				boolean check = false;
				for(int i = 0 ; i < gr.size(); i++) {
					
					int price = gr.get(i).getPrice();
					int amoun = gr.get(i).getAmount();
					
					if(price == selling_price) {
						check = true;
						if(amoun >= selling_amount) {
							int after_selling = amoun - selling_amount;
							gr.get(i).setAmount(after_selling);
							
							System.out.println("Remaining Stock = " + gr.get(i).getProduct() +", selling at " 
									+ gr.get(i).getPrice() + "$ with " + gr.get(i).getAmount() + " left");
						}
						else {
							System.out.println("There are not enough products. Amount of the product in the stock: " + gr.get(i).getStockAmount());
						}
						
					}
					
					
				
				}
				if(check != true) {
					System.out.println("There is no such product selling at 20$. Please try again with correct price.");
				}
				break;
				
			default:
				System.out.println("Wrong keyword. Try again.");
			}
			input = keyboard.nextLine().split(" ");
			cmd = input[0]; 
		}
		while(!cmd.equals("q"));
		//While end
		if(cmd.equals("q")) {
			int sz = groceryList.size();
			
			for(int i = 1 ; i < sz; i++) {
				ArrayList<Grocery> g = hm.get(i);
				for( int j = 0; j < g.size(); j++) {
					Product p = g.get(j).getProduct();
					//Product.productNo = i;
					System.out.println(p+", selling at " 
							+ g.get(j).getPrice() + "$ with " + g.get(j).getAmount() + " left" );
				}
			}
			
		}
		
			
	}

}
