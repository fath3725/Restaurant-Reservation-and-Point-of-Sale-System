import java.util.*;
import java.io.*;

public class Restaurant {
	/**
	 * Constant number for GST.
	 */
	final double GST = 0.07;
	/**
	 * The array that stores all staffs.
	 */
	private ArrayList<Staff> staffs;
	/**
	 * The array that stores all members.
	 */
	private ArrayList<Member> members;
	/**
	 * The array that stores all tables.
	 */
	private ArrayList<Table> tables;
	/**
	 * The array that stores all order.
	 */
	private ArrayList<Order> orders;
	/**
	 * The array that stores all order.
	 */
	private ArrayList<Reservation> currentReservations;
	/**
	 * The array that stores all order records.
	 */
	private ArrayList<Order> orderRecord;
	/**
	 * Creates new menu object that will hold all menu items.
	 */
	private Menu menu = new Menu();
	/**
	 * Creates a new restaurant.
	 */
	 public Restaurant(){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tables will this restaurant have? : ");
		int numOfTable = sc.nextInt();
		for(int i=0; i<numOfTable; i++){
			while(true) {
				System.out.println("Enter table size (Even number up to ten): ");
				int tableSize = sc.nextInt();
				if(tableSize%2 != 0 || tableSize>10 || tableSize<2){
					System.out.println("Invalid size, even numbers up to ten");
					continue;
				}
				tables.add(new Table(tableSize)); //adds new table into arraylist
				break;
			}
		}
		System.out.println("How many staffs will this restaurant have? : ");
		int numOfStaff = sc.nextInt();
		for(int i=0; i<numOfStaff; i++){
			System.out.println("Enter Staff's full name: ");
			String staffName = sc.nextLine();
			System.out.println("Enter Staff's gender (Female/Male): ");
			String staffGender = sc.nextLine();
			System.out.println("Enter Staff's job title: ");
			String staffJob = sc.nextLine();
			staffs.add(new Staff(staffName, staffGender, staffJob)); //adds new staff into arraylist
		}

		System.out.println("How many special member will this restaurant have? : ");
		int numOfMem = sc.nextInt();
		for(int i=0; i<numOfMem; i++){
			System.out.println("Enter Member's full name: ");
			String memName = sc.nextLine();
			System.out.println("Enter Member's gender (Female/Male): ");
			String memGender = sc.nextLine();
			System.out.println("Enter Member's phone number: ");
			int memPhoneNumber = sc.nextInt();
			members.add(new Member(memName, memGender, memPhoneNumber)); //adds new member into arraylist
		}
		sc.close();
	}
	/**
	 * Creates and add a new staff into the staffs array.
	 * Checks whether staff already exist before addition.
	 */
	public void addStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff's full name: ");
		String staffName = sc.nextLine();
		System.out.println("Enter Staff's gender (Female/Male): ");
		String staffGender = sc.nextLine();
		System.out.println("Enter Staff's job title: ");
		String staffJob = sc.nextLine();
		
		for(int i=0; i<staffs.size(); i++){
			if((staffs.get(i)).getName() == staffName && (staffs.get(i)).getGender() == staffGender && (staffs.get(i)).getJobTitle() == staffJob){
				System.out.println("Staff already exist");
				sc.close();
				return;
			}
		}
		staffs.add(new Staff(staffName, staffGender, staffJob));
		System.out.println("Staff added");
		sc.close();
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all staff information.
	 */
	public void viewStaff() {
		for(int i=0; i<staffs.size(); i++){
			System.out.println((i+1)+") "+(staffs.get(i)).getName()+" -Gender: "+(staffs.get(i)).getGender()+" -Staff ID: "+(staffs.get(i)).getStaffId()+" -Job Title: "+(staffs.get(i)).getJobTitle());
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all staff information and allow user to choose which staff to remove.
	 */
	public void removeStaff() {
		Scanner sc = new Scanner(System.in);
		viewStaff();
		System.out.println("Which staff to remove? (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > staffs.size()){
			sc.close();
			return;
		}
		staffs.remove(temp-1);
		System.out.println("Staff removed");
		sc.close();
	}
		
	/**
	 * Creates and add a new table into the tables array.
	 */
	public void addTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter table size: ");
		int tableSize = sc.nextInt();
		tables.add(new Table(tableSize));
		sc.close();
	}
	/**
	 * Prints all table information.
	 */
	public void viewTable() {
		for(int i=0; i<tables.size(); i++){
			System.out.println((i+1)+") Table ID: "+(tables.get(i)).getTableID()+" -Status: "+(tables.get(i)).getStatus()+" -Current Pax: "+(tables.get(i)).getTablePax()+"/"+(tables.get(i)).getTableSize());
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all table information and allow user to choose which table to remove.
	 */
	public void removeTable() {
		Scanner sc = new Scanner(System.in);
		viewTable();
		System.out.println("Which table to remove? (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > tables.size()){
			sc.close();
			return;
		}
		tables.remove(temp-1);
		System.out.println("Table removed");
		sc.close();
	}
		
	/**
	 * Creates and add a new member into the members array.
	 */
	public void addMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Member's full name: ");
		String memName = sc.nextLine();
		System.out.println("Enter Member's gender (Female/Male): ");
		String memGender = sc.nextLine();
		System.out.println("Enter Member's phone number: ");
		int memPhone = sc.nextInt();
		for(int i=0; i<members.size(); i++){
			if((members.get(i)).getName() == memName && (members.get(i)).getGender() == memGender && (members.get(i)).getPhoneNumber() == memPhone){
				System.out.println("Member already exist");
				sc.close();
				return;
			}
		}
		members.add(new Member(memName, memGender, memPhone));
		sc.close();
	}
	/**
	 * Prints all member information.
	 */
	public void viewMember() {
		for(int i=0; i<members.size(); i++){
			System.out.println((i+1)+") "+(members.get(i)).getName()+" -Gender: "+(members.get(i)).getGender()+" -Member ID: "+(members.get(i)).getMemberId()+" -Phone Number: "+(members.get(i)).getPhoneNumber());
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all member information and allow user to choose which member to remove.
	 */
	public void removeMember() {
		Scanner sc = new Scanner(System.in);
		viewMember();
		System.out.println("Which member to remove? (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > members.size()){
			sc.close();
			return;
		}
		members.remove(temp-1);
		System.out.println("Member removed");
		sc.close();
	}
	
	/**
	 * Prints all available table.
	 */
	public int printAvailableTables() {
		int count = 0;
		System.out.println("List of available tables are as follows: ");
		for(int i=0; i<tables.size(); i++){
			if((tables.get(i)).getStatus() == Status.AVAILABLE){
				System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Table Size: "+(tables.get(i)).getTableSize());
			}
		}
		if(count == 0){
			System.out.println("No tables currently available");
		}
		return count;
	}
	/**
	 * Prints all available table with table size larger than user's input.
	 * @param pax user's input for pax
	 */
	public int printAvailableTables(int pax) {
		int count = 0;
		System.out.println("List of available tables for "+pax+" or more pax are as follows: ");
		for(int i=0; i<tables.size(); i++){
			if((tables.get(i)).getStatus() == Status.AVAILABLE && (tables.get(i)).getTableSize() >= pax){
				System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Table Size: "+(tables.get(i)).getTableSize());
				count++;
			}
		}
		if(count == 0){
			System.out.println("No tables currently available");
		}
		return count;
	}
	/**
	 * Prints all occupied table.
	 */
	public int printOccupiedTables() {
		int count = 0;
		System.out.println("List of occupied tables are as follows: ");
		for(int i=0; i<tables.size(); i++){
			if((tables.get(i)).getStatus() == Status.OCCUPIED){
				System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Currently seated: "+(tables.get(i)).getTablePax()+"/"+(tables.get(i)).getTableSize());
			}
		}
		if(count == 0){
			System.out.println("No tables currently occupied");
		}
		return count;
	}
	/**
	 * Creates and add a new reservation into the current reservation array.
	 */
	public void addReservation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of pax: ");
		int noOfPax = sc.nextInt();
		System.out.println("Enter customer's contact number: ");
		int contactNumber = sc.nextInt();
		System.out.println("Enter customer's name: ");
		String customerName = sc.nextLine();
		int check = printAvailableTables();
		if(check == 0) {
			sc.close();
			return;
		}
		System.out.println("Enter table selected for reservation: ");
		int resTableID = sc.nextInt();
		Date now = new Date();
		System.out.println("Now is: "+ now.toString());
		System.out.println("What time do you want the reservation? (Enter the hour 1-24): ");
		int hour = sc.nextInt();
		System.out.println("What time do you want the reservation? (Enter the minutes 1-60): ");
		int min = sc.nextInt();
		currentReservations.add(new Reservation(noOfPax, contactNumber, customerName, resTableID, hour, min));
		for(int i=0; i<tables.size(); i++){
			if(tables.get(i).getTableID() == resTableID){
				tables.get(i).setStatus(Status.RESERVED);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Prints all current reservation information and allow user to choose which reservation to cancel.
	 */
	public void removeReservation() {
		Scanner sc = new Scanner(System.in);
		viewCurrentReservations();
		System.out.println("Which reservation to remove? (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > currentReservations.size()){
			sc.close();
			return;
		}
		int toRemove = currentReservations.get(temp-1).getTableReserved();
		currentReservations.remove(temp-1);
		System.out.println("Reservation removed");
		for(int i=0; i<tables.size(); i++){
			if(tables.get(i).getTableID() == toRemove){
				tables.get(i).setStatus(Status.AVAILABLE);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Prints all current reservation information.
	 */
	public void viewCurrentReservations() {
		for(int i=0; i<currentReservations.size(); i++){
			System.out.println((i+1)+") "+(currentReservations.get(i)).getNameReservedUnder()+" -Contact No.: "+(currentReservations.get(i)).getContactReservedUnder()+
			" -Table ID: "+(currentReservations.get(i)).getTableReserved()+" -Pax: "+(currentReservations.get(i)).getPaxReserved()+ " -Date Reserved: "
			+(currentReservations.get(i)).getReservedForTime().getTime());
		}
	}
	/**
	 * Check if customer has reservation.
	 * If yes: check for a valid reservation and assign the table reserved and sets the table's status to OCCUPIED
	 * If no: check for table availability and assign a table based on pax and sets the table's status to OCCUPIED
	 */
	public void seatCustomer(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Reservation? (True/False): ");
		boolean answer = sc.nextBoolean();
		if(!answer) {
			System.out.println("How many pax?: ");
			int numberOfPeople = sc.nextInt();
			int check = printAvailableTables(numberOfPeople);
			if(check == 0) {				
				sc.close();
				return;
			}
			System.out.println("Choose table ID to seat customer? (Enter invalid choice to terminate process): ");
			int temp = sc.nextInt();
			for(int i=0; i<tables.size(); i++){
				if((tables.get(i)).getTableID() == temp){
					System.out.println("Customer Seated at Table "+(tables.get(i)).getTableID());
					tables.get(i).setStatus(Status.OCCUPIED);
					tables.get(i).setTablePax(numberOfPeople);
					sc.close();
					return;
				}
			}
		}
		else{
			System.out.println("Name reserved under: ");
			String reservedBy = sc.nextLine();
			System.out.println("Contact Number reserved under: ");
			int reservedCon = sc.nextInt();
			for(int i=0; i<currentReservations.size(); i++){
				if((currentReservations.get(i)).getNameReservedUnder() == reservedBy && (currentReservations.get(i)).getContactReservedUnder() == reservedCon){
					for(int j=0; j<tables.size(); i++) {
						if((tables.get(j)).getTableID() == (currentReservations.get(i)).getTableReserved()){
							System.out.println("Customer Seated at Table "+(currentReservations.get(i)).getTableReserved());
							tables.get(j).setStatus(Status.OCCUPIED);
							tables.get(j).setTablePax((currentReservations.get(i)).getPaxReserved());
							sc.close();
							return;
						}
					}
				}
			}
			System.out.println("Invalid Reservation!");
			System.out.println("Returning to main page");
			sc.close();
		}
	}
	/**
	 * Allows user to choose with table is going for payment.
	 * Print this final invoice and moves old order into array to be stored under records.
	 */
	public void paymentCustomer(){
		Scanner sc = new Scanner(System.in);
		int temp = printOccupiedTables();
		if(temp == 0) {
			System.out.println("No table to checkout");
			sc.close();
			return;
		}
		System.out.println("Choose table ID for payment (Enter -1 to terminate process): ");
		int choice = sc.nextInt();
		if(choice == -1){
			sc.close();
			return;
		}
			
		for(int i=0; i<orders.size(); i++){
			if((orders.get(i)).getOrderTableID() == choice){
				System.out.println("----------------Invoice----------------");
				System.out.println("---------------------------------------");
				double finalAmt = (orders.get(i)).viewOrder();
				System.out.println("---------------------------------------");
				System.out.printf("Sub Total: %.2f\n",finalAmt);
				System.out.printf("7% GST: %.2f\n",(finalAmt*GST));
				System.out.printf("Total: %.2f\n",((finalAmt*GST)+finalAmt));
				System.out.println("-----Thank you for dining with us!-----");
				tables.get(i).setStatus(Status.AVAILABLE);
				tables.get(i).setTablePax(0);
				orderRecord.add(orders.get(i));
				removeOrder(choice);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Allows user to create a new order to add into the orders array.
	 */
	public void addOrder() {
		Scanner sc = new Scanner(System.in);
		int temp = printOccupiedTables();
		if(temp == 0) {
			System.out.println("No table occupied to place order");
			sc.close();
			return;
		}
		System.out.println("Choose table ID to place order (Enter -1 to terminate process): ");
		int orderTableID = sc.nextInt();

		if(orderTableID == -1){
			sc.close();
			return;
		}
		System.out.println("Enter Staff's ID: ");
		int orderStaffID = sc.nextInt();
		orders.add(new Order(orderStaffID, orderTableID));
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID){
				orders.get(i).addItems(menu);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Allows user to remove an order from the orders array.
	 */
	public void removeOrder() {
		Scanner sc = new Scanner(System.in);
		int temp = printOccupiedTables();
		if(temp == 0) {
			System.out.println("No table occupied to remove order");
			sc.close();
			return;
		}
		System.out.println("Choose table ID to remove order (Enter -1 to terminate process): ");
		int orderTableID = sc.nextInt();
		if(orderTableID == -1){
			sc.close();
			return;
		}
		System.out.println("Enter Staff's ID: ");
		int orderStaffID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID && orders.get(i).getOrderStaffID() == orderStaffID) {
				System.out.println("Order for table ID "+orders.get(i).getOrderTableID()+" removed");
				orders.remove(i);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Allows user to remove a specific order from the orders array when customers made payment.
	 */
	public void removeOrder(int tableID) {
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == tableID) {
				System.out.println("Order for table ID "+orders.get(i).getOrderTableID()+" paid and removed");
				orders.remove(i);
				return;
			}
		}
	}
	/**
	 * Allows user to view specific order in the orders array.
	 */
	public void printSpecificOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Table's ID: ");
		int orderTableID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID){
				double finalAmt = orders.get(i).viewOrder();
				System.out.printf("Current Total exclude GST: %.2f", finalAmt);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	/**
	 * Allows user to view all order in the orders array.
	 */
	public void printAllOrder() {
		for(int i=0; i<orders.size(); i++) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Order for Table ID: "+orders.get(i).getOrderTableID());
			double finalAmt = orders.get(i).viewOrder();
			System.out.printf("Current Total for Table ID-"+orders.get(i).getOrderTableID()+" exclude GST: %.2f", finalAmt);
		}
	}
	/**
	 * Allows user to edit a existing order.
	 */
	public void editOrder() {
		Scanner sc = new Scanner(System.in);
		printAllOrder();
		System.out.println("Choose Table ID of order to edit: ");
		int orderTableID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID){
				orders.get(i).editItems(menu);
				sc.close();
				return;
			}
		}
		sc.close();
	}
	public void transferToTxt() throws FileNotFoundException {
		// Open the file.
        PrintWriter out = new PrintWriter("Final Sales Report.txt"); // Step 2
		double finalAmt = 0;
        // Write the name of four oceans to the file
        for(int i=0; i<orderRecord.size(); i++){
			out.println((i+1)+") Order --------");
			double finalAmount=0;
			for(int j=0; j<orderRecord.get(i).alaCartes.size(); j++){
				if(orderRecord.get(i).alaCartes.get(j).getQuantity() == 0)
					continue;
				double total = (orderRecord.get(i).alaCartes.get(j).getPrice()) * (orderRecord.get(i).alaCartes.get(j).getQuantity());
				finalAmount = finalAmount + total;
				finalAmt = finalAmt + total;
				out.println(orderRecord.get(i).alaCartes.get(j).getQuantity()+" - "+orderRecord.get(i).alaCartes.get(j).getName()+"		"+total+"\n");
			}

			for(int j=0; j<orderRecord.get(i).promotionPackages.size(); j++){
				if(orderRecord.get(i).promotionPackages.get(j).getQuantity() == 0)
					continue;
				double total = (orderRecord.get(i).promotionPackages.get(j).getPrice()) * (orderRecord.get(i).promotionPackages.get(j).getQuantity());
				finalAmount = finalAmount + total;
				finalAmt = finalAmt + total;
				out.println(orderRecord.get(i).promotionPackages.get(j).getQuantity()+" - "+orderRecord.get(i).promotionPackages.get(j).getName()+"		"+total+"\n");
			}
			out.printf("Total amount for the order above = %.2f\n", finalAmount);
		}
		out.printf("Total Sales Revenue = %.2f\n", finalAmt);
        // Close the file.
        out.close();
	}
	/**
	 * Gets the menu of this restaurant.
	 * @return this menu.
	 */
	public Menu getMenu(){
		return this.menu;
	}
	/**
	 * Gets the table array of this restaurant.
	 * @return this tables.
	 */
	public ArrayList<Table> getTableArray(){
		return this.tables;
	}
	/**
	 * Gets the staff array of this restaurant.
	 * @return this staffs.
	 */
	public ArrayList<Staff> getStaffArray(){
		return this.staffs;
	}
	/**
	 * Gets the member array of this restaurant.
	 * @return this members.
	 */
	public ArrayList<Member> getMemberArray(){
		return this.members;
	}
	/**
	 * Gets the order record array of this restaurant.
	 * @return this orderRecord.
	 */
	public ArrayList<Order> getOrderRecord(){
		return this.orderRecord;
	}
}