import java.io.FileNotFoundException;
import java.util.*;

public class RRPSS {
	public static void main(String[] args){
		
		Restaurant restaurant = new Restaurant();
		Scanner sc = new Scanner(System.in);
		int choice, innerChoice;
		while (true) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("(1) Add item into Menu"); //add menu item into menu
			System.out.println("(2) Remove item from Menu"); //remove menu item from menu
			System.out.println("(3) View Menu"); //view current menu
			System.out.println("(4) Edit current Menu"); //edit current menu 
			System.out.println("(5) Add Staff into Restaurant"); //add staff into restaurant 
			System.out.println("(6) Remove Staff from Restaurant"); //remove staff from restaurant 
			System.out.println("(7) View all Staffs"); //view all staff
			System.out.println("(8) Add Tables into Restaurant"); //add table into restaurant
			System.out.println("(9) Remove Tables from Restaurant"); //remove table from restaurant
			System.out.println("(10) View all Tables"); //view all table either all or available only
			System.out.println("(11) Add Member into Restaurant"); //add member into restaurant
			System.out.println("(12) Remove Member from Restaurant"); //remove member from restaurant
			System.out.println("(13) View all Members"); //view all member
			System.out.println("(14) Create Order"); //create order
			System.out.println("(15) Remove Order"); //remove order 
			System.out.println("(16) View specific Order"); //view specific order
			System.out.println("(17) View all Orders"); //view all current order
			System.out.println("(18) Edit Orders"); //edit an order
			System.out.println("(19) Create Reservation"); //create reservation
			System.out.println("(20) Cancel Reservation"); //cancel reservation, if reserved customer is seated, reservation will be removed and placed into records automatically
			System.out.println("(21) View all Reservations"); //view current reservations
			System.out.println("(22) Seat Customer"); //set tables status to occupy and set pax
			System.out.println("(23) Pay and Print Invoice"); //set tables status to available and set pax to 0, print invoice
			System.out.println("(24) Create Total Revenue Report"); //create txt file which contains all order information
			System.out.println("(25) Exit");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Enter the number of your choice: ");
			choice = sc.nextInt();
			if (choice==25)break;
			switch(choice) {
				case 1:
					restaurant.getMenu().addItems(restaurant.getMenu());
					break;
				case 2:
					restaurant.getMenu().removeItems();
					break;
				case 3:
					System.out.println("(1) View Ala Carte Menu");
					System.out.println("(2) View Promotion Packages Menu");
					System.out.println("Enter the number of your choice: ");
					innerChoice = sc.nextInt();
					switch(innerChoice) {
						case 1: 
							restaurant.getMenu().viewAlaCartes();
							break;
						case 2:
							restaurant.getMenu().viewPromotionPackages();
							break;
						default:
							System.out.println("Returning to main page");
					}
					break;
				case 4:
					restaurant.getMenu().editItems();
					break;
				case 5:
					restaurant.addStaff();
					break;
				case 6:
					restaurant.removeStaff();
					break;
				case 7:
					restaurant.viewStaff();
					break;
				case 8:
					restaurant.addTable();
					break;
				case 9:
					restaurant.removeTable();
					break;
				case 10:
					System.out.println("(1) View all Tables");
					System.out.println("(2) View available Tables only");
					System.out.println("Enter the number of your choice: ");
					innerChoice = sc.nextInt();
					switch(innerChoice) {
						case 1: 
							restaurant.viewTable();
							break;
						case 2:
							restaurant.printAvailableTables();
							break;
						default:
							System.out.println("Returning to main page");
							break;
					}
					break;
				case 11:
					restaurant.addMember();
					break;
				case 12:
					restaurant.removeMember();
					break;
				case 13:
					restaurant.viewMember();
					break;
				case 14:
					restaurant.addOrder();
					break;
				case 15:
					restaurant.removeOrder();
					break;
				case 16:
					restaurant.printSpecificOrder();
					break;
				case 17:
					restaurant.printAllOrder();
					break;
				case 18:
					restaurant.editOrder();
					break;
				case 19:
					restaurant.addReservation();
					break;
				case 20:
					restaurant.removeReservation();
					break;
				case 21:
					restaurant.viewCurrentReservations();
					break;
				case 22:
					restaurant.seatCustomer();
					break;
				case 23:
					restaurant.paymentCustomer();
					break;
				case 24:
					try {
						restaurant.transferToTxt();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 25:
					System.out.println("Program terminating ...");
					break;
				default:
					System.out.println("Invalid Command.");
					break;
				}
			
			}
		sc.close();
	}
}

	