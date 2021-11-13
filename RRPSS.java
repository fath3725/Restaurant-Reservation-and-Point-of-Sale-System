import java.io.*;
import java.util.*;

public class RRPSS {
	public static Scanner sc;
	public static void main(String[] args){
		// start readwrite
		try {
			PrintStream o = new PrintStream(new File("Output.txt"));
			System.setOut(o);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			File f= new File("Test Case Project CZ2002.txt"); // file to read testcaseinput from
			sc = new Scanner(f);
		} catch (FileNotFoundException e1) {
			sc = new Scanner(System.in);
			e1.printStackTrace();
		}
		//end of readwrite
		// sc = new Scanner(System.in); //comment this out when readwrite
		Restaurant restaurant = new Restaurant();
		while (true) {
			System.out.println("-----------------------RRPSS MAIN MENU-------------------------");
			System.out.println("(1) Menu options");
			System.out.println("(2) Staff options");
			System.out.println("(3) Table options");
			System.out.println("(4) Member options");
			System.out.println("(5) Order options");
			System.out.println("(6) Reservation options");
			System.out.println("(7) Seat customer");
			System.out.println("(8) Payment");
			System.out.println("(9) Generate Total Revenue Report");
			System.out.println("(10) Exit");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					MenuOptions(restaurant);
					break;
				case 2:
					StaffOptions(restaurant);
					break;
				case 3:
					TableOptions(restaurant);
					break;
				case 4:
					MemberOptions(restaurant);
					break;
				case 5:
					OrderOptions(restaurant);
					break;
				case 6:
					ReservationOptions(restaurant);
					break;
				case 7:
					restaurant.seatCustomer();
					break;
				case 8:
					restaurant.paymentCustomer();
					break;
				case 9:
					try {
						restaurant.transferToTxt();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 10:
					System.out.println("Program terminating ...");
					sc.close();
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void MenuOptions(Restaurant restaurant){
		while(true){
			System.out.println("------------------------Menu Options---------------------------");
			System.out.println("(1) Add item into Menu"); //add menu item into menu
			System.out.println("(2) Remove item from Menu"); //remove menu item from menu
			System.out.println("(3) View Menu"); //view current menu
			System.out.println("(4) Edit current Menu"); //edit current menu 
			System.out.println("(5) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.getMenu().addItems(restaurant.getMenu());
					break;
				case 2:
					restaurant.getMenu().removeItems();
					break;
				case 3:
					System.out.println("(1) View Ala Carte Menu");
					System.out.println("(2) View Promotion Packages Menu");
					System.out.print("Choice: ");
					int innerChoice = sc.nextInt();
					switch(innerChoice) {
						case 1: 
							restaurant.getMenu().viewAlaCartes();
							break;
						case 2:
							restaurant.getMenu().viewPromotionPackages();
							break;
						default:
							System.out.println("Returning to menu options page");
					}
					break;
				case 4:
					restaurant.getMenu().editItems();
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void StaffOptions(Restaurant restaurant){
		while(true){
			System.out.println("------------------------Staff Options---------------------------");
			System.out.println("(1) Add Staff into Restaurant"); //add staff into restaurant 
			System.out.println("(2) Remove Staff from Restaurant"); //remove staff from restaurant 
			System.out.println("(3) View all Staffs"); //view all staff
			System.out.println("(4) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.addStaff();
					break;
				case 2:
					restaurant.removeStaff();
					break;
				case 3:
					restaurant.viewStaff();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void TableOptions(Restaurant restaurant){
		while(true){
			System.out.println("------------------------Table Options---------------------------");
			System.out.println("(1) Add Tables into Restaurant"); //add table into restaurant
			System.out.println("(2) Remove Tables from Restaurant"); //remove table from restaurant
			System.out.println("(3) View all Tables"); //view all table either all or available only
			System.out.println("(4) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.addTable();
					break;
				case 2:
					restaurant.removeTable();
					break;
				case 3:
					System.out.println("(1) View all Tables");
					System.out.println("(2) View available Tables only");
					System.out.print("Choice: ");
					int innerChoice = sc.nextInt();
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
				case 4:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void MemberOptions(Restaurant restaurant){
		while(true){
			System.out.println("------------------------Member Options--------------------------");
			System.out.println("(1) Add Member into Restaurant"); //add member into restaurant
			System.out.println("(2) Remove Member from Restaurant"); //remove member from restaurant
			System.out.println("(3) View all Members"); //view all member
			System.out.println("(4) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.addMember();
					break;
				case 2:
					restaurant.removeMember();
					break;
				case 3:
					restaurant.viewMember();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void OrderOptions(Restaurant restaurant){
		while(true){
			System.out.println("------------------------Order Options---------------------------");
			System.out.println("(1) Create Order"); //create order
			System.out.println("(2) Remove Order"); //remove order 
			System.out.println("(3) View specific Order"); //view specific order
			System.out.println("(4) View all Orders"); //view all current order
			System.out.println("(5) Edit Orders"); //edit an order
			System.out.println("(6) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.addOrder();
					break;
				case 2:
					restaurant.removeOrder();
					break;
				case 3:
					restaurant.printSpecificOrder();
					break;
				case 4:
					restaurant.printAllOrder();
					break;
				case 5:
					restaurant.editOrder();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}

	private static void ReservationOptions(Restaurant restaurant){
		while(true){
			System.out.println("--------------------Reservation Options------------------------");
			System.out.println("(1) Create Reservation"); //create reservation
			System.out.println("(2) Cancel Reservation"); //cancel reservation, if reserved customer is seated, reservation will be removed and placed into records automatically
			System.out.println("(3) View all Reservations"); //view current reservations
			System.out.println("(4) Back to RRPSS main");
			System.out.println("---------------------------------------------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					restaurant.addReservation();
					break;
				case 2:
					restaurant.removeReservation();
					break;
				case 3:
					restaurant.viewCurrentReservations();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid Command.");
					break;
			}
		}
	}
}

	

	