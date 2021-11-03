import java.util.Date;
import java.util.*;

public class Order extends Menu {
	
	private int orderStaffID;
	private int orderTableID;
	private Date timeStamp;

	public Order(int orderStaffID, int orderTableID) {
		super();
		this.orderStaffID = orderStaffID;
		this.orderTableID = orderTableID;
		this.timeStamp = new Date();
	}

	public int getOrderTableID() {
		return this.orderTableID;
	}
	public void setOrderTableID(int orderTableID) {
		this.orderTableID = orderTableID;
	}
	public int getOrderStaffID() {
		return this.orderStaffID;
	}
	public void setOrderStaffID(int orderStaffID) {
		this.orderStaffID = orderStaffID;
	}
	public double viewOrder(){
		double finalAmount=0;
		for(int i=0; i<this.alaCartes.size(); i++){
			double total = (this.alaCartes.get(i).getPrice()) * (this.alaCartes.get(i).getQuantity());
			finalAmount = finalAmount + total;
			System.out.println(this.alaCartes.get(i).getQuantity()+" - "+this.alaCartes.get(i).getName()+"		"+total);
		}
		return finalAmount;
	}
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
						AlaCarte temp = menu.getAlaCarte().get(i);
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
		sc.close();
	}

	public void removeOrderItem() {
		// TODO - implement Order.removeOrderItem
		throw new UnsupportedOperationException();
	}

	public void editOrderItem() {
		// TODO - implement Order.editOrderItem
		throw new UnsupportedOperationException();
	}
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}