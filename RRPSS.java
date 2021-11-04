import java.util.*;

public class RRPSS {

	public static void main(String[] args){
		
		Restaurant restaurant = new Restaurant();
		Scanner sc = new Scanner(System.in);
		int choice, innerChoice;
		do {
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
			System.out.println("(18) Creat Reservation"); //create reservation
			System.out.println("(19) Cancel Reservation"); //cancel reservation, if reserved customer is seated, reservation will be removed and placed into records automatically
			System.out.println("(20) View all Reservations"); //view current reservations
			System.out.println("(21) Seat Customer"); //set tables status to occupy and set pax
			System.out.println("(22) Pay and Print Invoice"); //set tables status to available and set pax to 0, print invoice, order move to old order(reservation too) 
			System.out.println("(23) Exit");
			System.out.println("---------------------------------------------------------------");
			System.out.println("Enter the number of your choice: ");
			choice = sc.nextInt();
		
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
					restaurant.addReservation();
					break;
				case 19:
					restaurant.removeReservation();
					break;
				case 20:
					restaurant.viewCurrentReservations();
					break;
				case 21:
					restaurant.seatCustomer();
					break;
				case 22:
					restaurant.paymentCustomer();
					break;
				case 23:
					break;
				default:
					System.out.println("Program terminating ...");
				}
			}
		while(choice <24);
		sc.close();
		}

		
		public void salesRevenueReport() {
			// TODO - implement RRPSS.salesRevenueReport
			throw new UnsupportedOperationException();
		}

		public void viewMenu() {
			// TODO - implement RRPSS.viewMenu
			throw new UnsupportedOperationException();
		}

		public void viewOrder() {
			// TODO - implement RRPSS.viewOrder
			throw new UnsupportedOperationException();
		}

		public void createOrder() {
			// TODO - implement RRPSS.createOrder
			throw new UnsupportedOperationException();
		}

		public void removeOrder() {
			// TODO - implement RRPSS.removeOrder
			throw new UnsupportedOperationException();
		}

		public void editOrder() {
			// TODO - implement RRPSS.editOrder
			throw new UnsupportedOperationException();
		}

		public void printOrderInvoice() {
			// TODO - implement RRPSS.printOrderInvoice
			throw new UnsupportedOperationException();
		}

		public void createReservation() {
			// TODO - implement RRPSS.createReservation
			throw new UnsupportedOperationException();
		}

		public void viewReservations() {
			// TODO - implement RRPSS.viewReservations
			throw new UnsupportedOperationException();
		}

		public void removeReservation() {
			// TODO - implement RRPSS.removeReservation
			throw new UnsupportedOperationException();
		}

		public void editReservation() {
			// TODO - implement RRPSS.editReservation
			throw new UnsupportedOperationException();
		}
		
	}

	