import java.util.*;
import java.io.*;

public class Restaurant {
	/**
	 * Constant number for GST.
	 */
	final double GST = 0.07;
	/**
	 * Timer for reservation.
	 */
	Timer timer;
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
	 * The array that stores current reserveration.
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
		this.tables = new ArrayList<Table>();
		this.staffs = new ArrayList<Staff>();
		this.members = new ArrayList<Member>();
		this.orders = new ArrayList<Order>();
		this.orderRecord = new ArrayList<Order>();
		this.currentReservations = new ArrayList<Reservation>();
		Scanner sc = new Scanner(System.in);
		System.out.print("How many tables will this restaurant have?\nNumber of Tables: ");
		int numOfTable = sc.nextInt();
		for(int i=0; i<numOfTable; i++){
			while(true) {
				System.out.print("Enter table size (Even number between two to ten): ");
				int tableSize = sc.nextInt();
				if(tableSize%2 != 0 || tableSize>10 || tableSize<2){
					System.out.println("Invalid size, Even number between two to ten");
					continue;
				}
				this.tables.add(new Table(tableSize)); //adds new table into arraylist
				break;
			}
		}
		System.out.print("How many staffs will this restaurant have? : ");
		int numOfStaff = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<numOfStaff; i++){
			System.out.print("Enter Staff's full name: ");
			String staffName = sc.nextLine();
			String staffGender;
			while(true){
				System.out.print("Enter Staff's gender (Female/Male): ");
				staffGender=sc.nextLine();
				if (!staffGender.equals("Female") && !staffGender.equals("Male")){
					System.out.println("Invalid gender. Gender is binary.");
					continue;
				}
				break;
			}
			System.out.print("Enter Staff's job title: ");
			String staffJob = sc.nextLine();
			staffs.add(new Staff(staffName, staffGender, staffJob)); //adds new staff into arraylist
		}

		
	}
	/**
	 * Creates and add a new staff into the staffs array.
	 * Checks whether staff already exist before addition.
	 */
	public void addStaff() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Staff's full name: ");
		String staffName = sc.nextLine();
		String staffGender;
		while(true){
			System.out.print("Enter Staff's gender (Female/Male): ");
			staffGender=sc.nextLine();
			if (!staffGender.equals("Female") && !staffGender.equals("Male")){
				System.out.println("Invalid gender. Gender is binary.");
				continue;
			}
			break;
		}
		System.out.print("Enter Staff's job title: ");
		String staffJob = sc.nextLine();
		for(int i=0; i<staffs.size(); i++){
			if(staffName.equals(staffs.get(i).getName()) && staffGender.equals(staffs.get(i).getGender()) && staffJob.equals(staffs.get(i).getJobTitle())){
				System.out.println("Staff already exist");
				return;
			}
		}
		staffs.add(new Staff(staffName, staffGender, staffJob));
		System.out.println("Staff added");
		
	}
	/**
	 * Prints all staff information.
	 */
	public void viewStaff() {
		if(staffs.size()==0) {
			System.out.println("No Staff in the restaurant");
		}
		for(int i=0; i<staffs.size(); i++){
			System.out.println((i+1)+". "+(staffs.get(i)).getName()+" -Gender: "+(staffs.get(i)).getGender()+" -Staff ID: "+(staffs.get(i)).getStaffId()+" -Job Title: "+(staffs.get(i)).getJobTitle());
		}
	}
	/**
	 * Prints all staff information and allow user to choose which staff to remove.
	 */
	public void removeStaff() {
		Scanner sc = new Scanner(System.in);
		viewStaff();
		System.out.print("Enter staff position to remove: (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > staffs.size() || temp <= 0){
			System.out.println("Invalid staff position");
			return;
		}
		staffs.remove(temp-1);
		System.out.println("Staff removed");
		
	}
		
	/**
	 * Creates and add a new table into the tables array.
	 */
	public void addTable() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter table size (Even number between two to ten): ");
		int tableSize = sc.nextInt();
		if(tableSize%2 != 0 || tableSize>10 || tableSize<2){
			System.out.println("Invalid size, Even number between two to ten");
			return;
		}
		this.tables.add(new Table(tableSize));
	}
	/**
	 * Prints all table information.
	 */
	public void viewTable() {
		if(tables.size()==0) {
			System.out.println("No Table in the restaurant");
		}
		for(int i=0; i<tables.size(); i++){
			System.out.println((i+1)+". Table ID: "+(tables.get(i)).getTableID()+" -Status: "+(tables.get(i)).getStatus()+" -Current Pax: "+(tables.get(i)).getTablePax()+"/"+(tables.get(i)).getTableSize());
		}
	}
	/**
	 * Prints all table information and allow user to choose which table to remove.
	 */
	public void removeTable() {
		Scanner sc = new Scanner(System.in);
		viewTable();
		System.out.print("Enter table position to remove: (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > tables.size()){
			System.out.println("Invalid table position");
			return;
		}
		if(tables.get(temp-1).getStatus()!=Status.AVAILABLE) {
			System.out.println("This table is reserved or occupied");
			return;
		}
		tables.remove(temp-1);
		System.out.println("Table removed");
	}
		
	/**
	 * Creates and add a new member into the members array.
	 */
	public void addMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Member's full name: ");
		String memName = sc.nextLine();
		String memGender;
		while(true){
			System.out.print("Enter Memberx's gender (Female/Male): ");
			memGender=sc.nextLine();
			if (!memGender.equals("Female") && !memGender.equals("Male")){
				System.out.println("Invalid gender. Gender is binary.");
				continue;
			}
			break;
		}
		System.out.println("Enter Member's phone number: ");
		int memPhone = sc.nextInt();
		for(int i=0; i<members.size(); i++){
			if(memName.equals(members.get(i).getName()) && memGender.equals(members.get(i).getGender()) && members.get(i).getPhoneNumber() == memPhone){
				System.out.println("Member already exist");
				
				return;
			}
		}
		members.add(new Member(memName, memGender, memPhone));
		System.out.println("New member added");
		
	}
	/**
	 * Prints all member information.
	 */
	public void viewMember() {
		if(members.size()==0) {
			System.out.println("No Member in the restaurant");
		}
		for(int i=0; i<members.size(); i++){
			System.out.println((i+1)+") "+(members.get(i)).getName()+" -Gender: "+(members.get(i)).getGender()+" -Member ID: "+(members.get(i)).getMemberId()+" -Phone Number: "+(members.get(i)).getPhoneNumber());
		}
	}
	/**
	 * Prints all member information and allow user to choose which member to remove.
	 */
	public void removeMember() {
		Scanner sc = new Scanner(System.in);
		viewMember();
		if(members.size()==0) return;
		System.out.print("Enter member position to remove: (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > members.size()){
			System.out.println("Invalid member position");
			return;
		}
		members.remove(temp-1);
		System.out.println("Member removed");
		
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
			System.out.println("No tables currently available for "+pax+ " pax");
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
			if((tables.get(i)).getStatus() == Status.OCCUPIED || (tables.get(i)).getStatus() == Status.OCCUPIED2RESERVED){
				System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Currently seated: "+(tables.get(i)).getTablePax()+"/"+(tables.get(i)).getTableSize());
				count++;
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
		if(tables.size()==0) {
			System.out.println("No table in the restaurant");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of pax: ");
		int noOfPax = sc.nextInt();
		if(noOfPax>10 || noOfPax<2) {
			System.out.println("No available for "+noOfPax+" pax");
			return;
		}
		System.out.print("Enter customer's contact number: ");
		int contactNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter customer's name: ");
		String customerName = sc.nextLine();

		Date now = new Date();
		System.out.println("Now is: "+ now.toString());
		System.out.println("Only can make reservation for this year...");
		System.out.print("What month do you want the reservation? (Enter 1-12): ");
		int month = sc.nextInt();
		System.out.print("What day do you want the reservation? (Enter 1-30/31): ");
		int day = sc.nextInt();
		System.out.print("What time do you want the reservation? (Enter the hour 1-24): ");
		int hour = sc.nextInt();
		System.out.print("What time do you want the reservation? (Enter the minutes 1-60): ");
		int min = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); //assume reservation can only make for the current year
		Calendar reservedTableTime = new GregorianCalendar(year, month-1, day, hour-1, min); // NOTE!!! : Month from 0 to 11 and book table 1hour before.
		Calendar reservedForTime = new GregorianCalendar(year, month-1, day, hour, min); //actual booking timing
		Calendar reservedTillTime = new GregorianCalendar(year, month-1, day, hour, min+30); //actual booking timing
		
		if(reservedForTime.compareTo(cal)<0) {
			System.out.println("Reservation Date cannot be before the current time");
			return;
		}
		
		HashSet <Integer> hash = new HashSet<Integer>();
		for(int i=0;i<tables.size();i++) {
			if(tables.get(i).getTableSize()>=noOfPax) {
				if(tables.get(i).getStatus()==Status.AVAILABLE) {
					System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Table Size: "+(tables.get(i)).getTableSize());
					hash.add(tables.get(i).getTableID());
				}
				else if(tables.get(i).getStatus()==Status.OCCUPIED) {
					if (reservedTableTime.compareTo(cal)>0) {
						System.out.println("Table ID: "+(tables.get(i)).getTableID()+" -Table Size: "+(tables.get(i)).getTableSize());
						hash.add(tables.get(i).getTableID());
					}
				}
				//if current status of table i is reserved or occupied2reserved
				else {
					
				}
			}
		}
		System.out.println("Enter table ID selected for reservation: ");
		int resTableID = sc.nextInt();
		if(!hash.contains(resTableID)) {
			System.out.println("Invalid table ID ");
			return;
		}
		
		currentReservations.add(new Reservation(noOfPax, contactNumber, customerName, resTableID, reservedForTime));
		timer = new Timer();
		Date time = reservedTableTime.getTime(); //table reserving time which is 1 hour before actual booking time
		timer.schedule(new TimerReservation(tables, currentReservations, resTableID, reservedForTime, reservedTillTime), time); 
		//creates a timer at 1hour before actual booking time that sets table to reserve and creates the 30min grace period timer
	}
	
	/**
	 * Prints all current reservation information and allow user to choose which reservation to cancel.
	 */
	public void removeReservation() {
		Scanner sc = new Scanner(System.in);
		viewCurrentReservations();
		if(currentReservations.size()==0) {
			System.out.println("No reservation in the restaurant");
			return;
		}
		System.out.print("Enter reservation position to remove: (Enter invalid choice to terminate process): ");
		int temp = sc.nextInt();
		if(temp > currentReservations.size()){
			System.out.println("Invalid reservation position");
			return;
		}
		int toRemove = currentReservations.get(temp-1).getTableReserved();
		currentReservations.remove(temp-1);
		System.out.println("Reservation removed");
		for(int i=0; i<tables.size(); i++){
			if(tables.get(i).getTableID() == toRemove){
				////what if the table is currently occupied?
				tables.get(i).setStatus(Status.AVAILABLE);
				
				return;
			}
		}
		
	}
	/**
	 * Prints all current reservation information.
	 */
	public void viewCurrentReservations() {
		if(currentReservations.size()==0) {
			System.out.println("No Reservation");
		}
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
		System.out.print("Reservation? (True/False): ");
		String in = sc.next();
		boolean answer = Boolean.parseBoolean(in);
		if(!answer) {
			System.out.print("How many pax?: ");
			int numberOfPeople = sc.nextInt();
			int check = printAvailableTables(numberOfPeople);
			if(check == 0) {				
				System.out.println("There is no available table for "+numberOfPeople+" people");
				return;
			}
			System.out.println("Choose table ID to seat customer? (Enter invalid choice to terminate process): ");
			int temp = sc.nextInt();
			for(int i=0; i<tables.size(); i++){
				if((tables.get(i)).getTableID() == temp && tables.get(i).getStatus()==Status.AVAILABLE){
					System.out.println("Customer Seated at Table "+(tables.get(i)).getTableID());
					tables.get(i).setStatus(Status.OCCUPIED);
					tables.get(i).setTablePax(numberOfPeople);
					
					return;
				}
			}
			System.out.println("Invalid table ID");
			return;
		}
		else{
			System.out.print("Name reserved under: ");
			String reservedBy = sc.nextLine();
			sc.nextLine();
			System.out.print("Contact Number reserved under: ");
			int reservedCon = sc.nextInt();
			for(int i=0; i<currentReservations.size(); i++){
				if(reservedBy.equals(currentReservations.get(i).getNameReservedUnder()) && currentReservations.get(i).getContactReservedUnder() == reservedCon){
					for(int j=0; j<tables.size(); j++) {
						if(tables.get(j).getTableID() == currentReservations.get(i).getTableReserved() && tables.get(j).getStatus() == Status.RESERVED){
							System.out.println("Customer Seated at Table "+currentReservations.get(i).getTableReserved());
							tables.get(j).setStatus(Status.OCCUPIED);
							tables.get(j).setTablePax(currentReservations.get(i).getPaxReserved());
							return;
						}
					}
				}
			}
			System.out.println("Invalid Reservation!");
			System.out.println("Returning to main page");
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
			
			return;
		}
		System.out.println("Choose table ID for payment (Enter -1 to terminate process): ");
		int choice = sc.nextInt();
		if(choice == -1){
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
				if(tables.get(i).getStatus() == Status.OCCUPIED){
					tables.get(i).setStatus(Status.AVAILABLE);
				}
				else if(tables.get(i).getStatus() == Status.OCCUPIED2RESERVED){
					tables.get(i).setStatus(Status.RESERVED);
				}
				tables.get(i).setTablePax(0);
				orderRecord.add(orders.get(i));
				removeOrder(choice);
				return;
			}
		}
		System.out.println("Invalid table ID");
	}
	/**
	 * Allows user to create a new order to add into the orders array.
	 */
	public void addOrder() {
		Scanner sc = new Scanner(System.in);
		int temp = printOccupiedTables();
		if(temp == 0) {
			System.out.println("No table occupied to place order");
			return;
		}
		System.out.print("Choose table ID to place order (Enter -1 to terminate process): ");
		int orderTableID = sc.nextInt();

		if(orderTableID == -1){
			
			return;
		}
		for(int i=0;i<tables.size();i++) {
			if(tables.get(i).getTableID()==orderTableID && (tables.get(i).getStatus() == Status.OCCUPIED || tables.get(i).getStatus() == Status.OCCUPIED2RESERVED)) {
				for(int j=0;j<orders.size();j++) {
					if(orders.get(i).getOrderTableID()==orderTableID) {
						System.out.println("This table has an order already");
						return;
					}
				}
				viewStaff();
				System.out.print("Enter Staff's ID: ");
				int orderStaffID = sc.nextInt();
				for(int j=0; j<staffs.size(); j++) {
					if(staffs.get(j).getStaffId()==orderStaffID) {
						orders.add(new Order(orderStaffID, orderTableID));
						orders.get(orders.size()-1).addItems(menu);
						return;
					}
				}
				System.out.println("Invalid Staff ID");
				return;
			}
		}
		System.out.println("Invalid Table ID");
	}
	/**
	 * Allows user to remove an order from the orders array.
	 */
	public void removeOrder() {
		if (orders.size()==0) {
			System.out.println("No orders to remove");
			return;
		}
		Scanner sc = new Scanner(System.in);
		int temp = printOccupiedTables();
		if(temp == 0) {
			System.out.println("No table occupied to remove order");
			
			return;
		}
		System.out.print("Choose table ID having an order (Enter -1 to terminate process): ");
		int orderTableID = sc.nextInt();
		if(orderTableID == -1){
			
			return;
		}
		System.out.print("Enter Staff's ID: ");
		int orderStaffID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID && orders.get(i).getOrderStaffID() == orderStaffID) {
				System.out.println("Order for table ID "+orders.get(i).getOrderTableID()+" removed");
				orders.remove(i);
				
				return;
			}
		}
		System.out.print("Invalid Staff ID or table ID");
	}
	/**
	 * Allows user to remove a specific order from the orders array when customers made payment.
	 */
	public void removeOrder(int tableID) {
		if (orders.size()==0) {
			System.out.println("No orders to remove");
			return;
		}
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == tableID) {
				System.out.print("Order for table ID "+orders.get(i).getOrderTableID()+" paid and removed");
				orders.remove(i);
				return;
			}
		}
		System.out.print("This table has no order");
	}
	/**
	 * Allows user to view specific order in the orders array.
	 */
	public void printSpecificOrder() {
		if (orders.size()==0) {
			System.out.println("No orders to print");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Table's ID: ");
		int orderTableID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID){
				double finalAmt = orders.get(i).viewOrder();
				System.out.printf("Current Total exclude GST: %.2f", finalAmt);
				
				return;
			}
		}
		System.out.print("This table has no order");
	}
	/**
	 * Allows user to view all order in the orders array.
	 */
	public void printAllOrder() {
		if (orders.size()==0) {
			System.out.println("No orders to print");
			return;
		}
		for(int i=0; i<orders.size(); i++) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Order for Table ID: "+orders.get(i).getOrderTableID());
			double finalAmt = orders.get(i).viewOrder();
			System.out.printf("Current Total for Table ID-"+orders.get(i).getOrderTableID()+" exclude GST: %.2f", finalAmt);
		}
		System.out.println();
	}
	/**
	 * Allows user to edit a existing order.
	 */
	public void editOrder() {
		Scanner sc = new Scanner(System.in);
		if (orders.size()==0) {
			System.out.println("No orders to edit");
			return;
		}
		printAllOrder();
		
		System.out.print("Choose Table ID of order to edit: ");
		int orderTableID = sc.nextInt();
		for(int i=0; i<orders.size(); i++){
			if(orders.get(i).getOrderTableID() == orderTableID){
				orders.get(i).editItems(menu);
				return;
			}
		}
		System.out.print("This table has no order");
	}
	public void transferToTxt() throws FileNotFoundException {
		// Open the file.
        PrintWriter out = new PrintWriter("Final Sales Report.txt"); // Step 2
		double finalAmt = 0;
        // Write the name of four oceans to the file
		if(orderRecord.size()==0) {
			System.out.println("No item sold");
			return;
		}
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
			out.println("Time stamp of order: "+orderRecord.get(i).getTimeStamp().getTime());
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