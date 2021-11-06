import java.util.Date;
import java.util.*;

public class Order extends Menu {
	/**
	 * The ID that belongs to the staff placing the order.
	 */
	private int orderStaffID;
	/**
	 * The table ID that the order belongs to.
	 */
	private int orderTableID;
	/**
	 * The time stamp at which the order was placed.
	 */
	private Date timeStamp;
	/**
	 * Creates a new order with the given staff ID and table ID.
	 * @param orderStaffID This staff's ID.
	 * @param orderTableID This table's ID.
	 */
	public Order(int orderStaffID, int orderTableID) {
		this.orderStaffID = orderStaffID;
		this.orderTableID = orderTableID;
		this.timeStamp = new Date();
	}
	/**
	 * Gets the table ID that the order belongs to.
	 * @return this orderTableID
	 */
	public int getOrderTableID() {
		return this.orderTableID;
	}
	/**
	 * Changes the table ID of this order.
	 * @param orderTableID This order's new table ID.
	 */
	public void setOrderTableID(int orderTableID) {
		this.orderTableID = orderTableID;
	}
	/**
	 * Gets the staff ID that placed the order.
	 * @return this orderStaffID
	 */
	public int getOrderStaffID() {
		return this.orderStaffID;
	}
	/**
	 * Changes the staff ID of this order.
	 * @param orderTableID This order's new staff ID.
	 */
	public void setOrderStaffID(int orderStaffID) {
		this.orderStaffID = orderStaffID;
	}
	/**
	 * Gets the time stamp of when the order was placed.
	 * @return this timeStamp
	 */
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	/**
	 * Changes the time stamp of this order.
	 * @param timeStamp This timeStamp's new time stamp.
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * Prints the quantity, name of menu item and the total cost of each menu item.
	 * @return finalAmount of total cost without GST.
	 */
	public double viewOrder(){
		double finalAmount=0;
		for(int i=0; i<this.alaCartes.size(); i++){
			if(this.alaCartes.get(i).getQuantity() == 0)
				continue;
			double total = (this.alaCartes.get(i).getPrice()) * (this.alaCartes.get(i).getQuantity());
			finalAmount = finalAmount + total;
			System.out.println(this.alaCartes.get(i).getQuantity()+" - "+this.alaCartes.get(i).getName()+"		"+total+"\n");
		}

		for(int i=0; i<this.promotionPackages.size(); i++){
			if(this.promotionPackages.get(i).getQuantity() == 0)
				continue;
			double total = (this.promotionPackages.get(i).getPrice()) * (this.promotionPackages.get(i).getQuantity());
			finalAmount = finalAmount + total;
			System.out.println(this.promotionPackages.get(i).getQuantity()+" - "+this.promotionPackages.get(i).getName()+"		"+total+"\n");
		}

		for(int i=0; i<this.promotionPackages.size(); i++){
			if(this.promotionPackages.get(i).getQuantity() == 0)
				continue;
			double total = (this.promotionPackages.get(i).getPrice()) * (this.promotionPackages.get(i).getQuantity());
			finalAmount = finalAmount + total;
			System.out.println(this.promotionPackages.get(i).getQuantity()+" - "+this.promotionPackages.get(i).getName()+"		"+total+"\n");
		}
		return finalAmount;
	}
	/**
	 * Prints the menu to allow user to choose from and place the order with quantity directly.
	 * @param menu So that the order can be chosen from the menu directly.
	 */
	public void addItems(Menu menu) {
		Scanner sc = new Scanner(System.in);
		int type = 0;
		while(type<3) {
			System.out.print("Add Order Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Terminate");
			type = sc.nextInt();
			if (type==1){
				menu.viewAlaCartes();
				System.out.print("Enter AlaCarte ID to add: ");
				int alaCarteID = sc.nextInt();
				System.out.print("Enter quantity: ");
				int alaCarteQuantity = sc.nextInt();
				for(int i=0; i<menu.getAlaCarte().size(); i++){
					if(menu.getAlaCarte().get(i).getId() == alaCarteID){
						AlaCarte temp = menu.getAlaCarte().get(i); //might need to clone here instead
						temp.setQuantity(alaCarteQuantity);
						this.alaCartes.add(temp);
						break;
					}
				}
			}
			else if(type==2){
				menu.viewPromotionPackages();
				System.out.print("Enter Package ID to add: ");
				int packID = sc.nextInt();
				System.out.print("Enter quantity: ");
				int packQuantity = sc.nextInt();
				for(int i=0; i<menu.getPromotionPackage().size(); i++){
					if(menu.getPromotionPackage().get(i).getId() == packID){
						PromotionPackage temp = menu.getPromotionPackage().get(i);
						temp.setQuantity(packQuantity);
						this.promotionPackages.add(temp);
						break;
					}
				}
			}
		}
		
	}
	
	/**
	 * Edit the quantity of the menu item in this order.
	 */
	public void editItems(Menu menu) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Next Action?\n"+"1. Add item\n"+"2. Remove item\n"+"3. Change quantity\n"+"4. Exit\nChoice: ");
			int type = sc.nextInt();
			if (type==1){
				addItems(menu);
			}
			else if(type==2){
				System.out.print("Remove Order Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit");
				int choice = sc.nextInt();
				if(choice == 1){
					System.out.println("Select Ala Carte id to remove, or enter -1 to quit: ");
					viewAlaCartes();
					System.out.print("Id: ");
					int id=sc.nextInt();
					if(id == -1)
						break;
					for (int i=0; i<this.alaCartes.size(); i++){
						if (id == this.alaCartes.get(i).getId()){		
							System.out.println("Ala Carte ID-"+this.alaCartes.get(i).getId()+" is removed from order");
							this.alaCartes.remove(i);
							break;
						}
					}
				}
				else if(choice==2){
					System.out.println("Select Promotion Package id to remove, or enter -1 to quit: ");
					viewPromotionPackages();
					System.out.print("Id: ");
					int id=sc.nextInt();
					if(id == -1)
						break;
					for (int i=0; i<this.promotionPackages.size(); i++){
						if (id == this.promotionPackages.get(i).getId()){		
							System.out.println("Promotion Package ID-"+this.promotionPackages.get(i).getId()+" is removed from order");
							this.promotionPackages.remove(i);
							break;
						}
					}
				}
				else
					break;
			}
			else if(type==3){
				System.out.print("Edit quantity of which Order Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit\nChoice: ");
				int choice = sc.nextInt();
				if(choice == 1){
					System.out.println("Select Ala Carte id to edit quantity, or enter -1 to quit: ");
					viewAlaCartes();
					System.out.print("Id: ");
					int id=sc.nextInt();
					if(id == -1)
						break;
					for (int i=0; i<this.alaCartes.size(); i++){
						if (id == this.alaCartes.get(i).getId()){		
							System.out.println("Enter new quantity: ");
							int newAmt = sc.nextInt();
							this.alaCartes.get(i).setQuantity(newAmt);
							break;
						}
					}
				}
				else if(choice==2){
					System.out.println("Select Promotion Package id to edit quantity, or enter -1 to quit: ");
					viewPromotionPackages();
					System.out.print("Id: ");
					int id=sc.nextInt();
					if(id == -1)
						break;
					for (int i=0; i<this.promotionPackages.size(); i++){
						if (id == this.promotionPackages.get(i).getId()){		
							System.out.println("Enter new quantity: ");
							int newAmt = sc.nextInt();
							this.promotionPackages.get(i).setQuantity(newAmt);
							break;
						}
					}
				}
			} else if (type==4) break;
		}
		
	}
	
}