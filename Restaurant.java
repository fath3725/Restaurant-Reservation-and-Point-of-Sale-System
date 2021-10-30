import java.util.*;
import java.io.*;

public class Restaurant {
	/**
	 * Constant number for GST.
	 */
	final float GST = 0.07;
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
	 * Creates a new restaurant.
	 */
	public Restaurant(){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tables will this restaurant have? : ");
		int numOfTable = sc.nextInt();
		for(int i=0; i<numOfTable; i++){
			System.out.println("Enter table size: ");
			int tableSize = sc.nextInt();
			tables.add(new Table(tableSize)); //adds new table into arraylist
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
			if((staffs.get(i)).name == staffName && (staffs.get(i)).gender == staffGender && (staffs.get(i)).jobTitle == staffJob){
				System.out.println("Staff already exist");
				return;
			}
		}
		staffs.add(new Staff(staffName, staffGender, staffJob));
		System.out.println("Staff added");
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all staff information.
	 */
	public void viewStaff() {
		for(int i=0; i<staffs.size(); i++){
			System.out.println((i+1)+") "+(staffs.get(i)).name+" -Gender: "+(staffs.get(i)).gender+" -Staff ID: "+(staffs.get(i)).staffId+" -Job Title: "+(staffs.get(i)).jobTitle);
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
		if(temp > staffs.Size()){
			return;
		}
		staffs.remove(temp-1);
		System.out.println("Staff removed");
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Creates and add a new table into the tables array.
	 */
	public void addTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter table size: ");
		int tableSize = sc.nextInt();
		tables.add(new Table(tableSize));
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all table information.
	 */
	public void viewTable() {
		for(int i=0; i<tables.size(); i++){
			System.out.println((i+1)+") Table ID: "+(tables.get(i)).tableID+" -Status: "+(tables.get(i)).status+" -Current Pax: "+(tables.get(i)).tablePax+"/"+(tables.get(i)).tableSize);
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
		if(temp > tables.Size()){
			return;
		}
		tables.remove(temp-1);
		System.out.println("Table removed");
		}
		throw new UnsupportedOperationException();
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
			if((members.get(i)).name == memName && (members.get(i)).gender == memGender && (members.get(i)).phoneNumber == memPhone){
				System.out.println("Member already exist");
				return;
			}
		}
		members.add(new Member(memName, memGender, memPhone));
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all member information.
	 */
	public void viewMember() {
		for(int i=0; i<members.size(); i++){
			System.out.println((i+1)+") "+(members.get(i)).name+" -Gender: "+(members.get(i)).gender+" -Member ID: "+(members.get(i)).memberId+" -Phone Number: "+(members.get(i)).phoneNumber);
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
		if(temp > members.Size()){
			return;
		}
		members.remove(temp-1);
		System.out.println("Member removed");
		}
		throw new UnsupportedOperationException();
	}
	/**
	 * Prints all available table.
	 */
	public void printAvailableTables() {
		for(int i=0; i<tables.Size(); i++){
			if((tables.get(i)).status == AVAILABLE){
				System.out.println("Table ID: "+(tables.get(i)).tableID+" -Table Size: "+(tables.get(i)).tableSize);
			}
		}
		throw new UnsupportedOperationException();
	}

}