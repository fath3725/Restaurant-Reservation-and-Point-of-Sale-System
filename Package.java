import java.util.*;

public class Package extends MenuItem {

	private ArrayList<AlaCarte> deals;
	private int numOfAlaCarte;
	private static int totalNumOfPakages=0;

	public Package(int numOfAlaCarte) {
		this.numOfAlaCarte = numOfAlaCarte;
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<numOfAlaCarte; i++){ //add items into package till package full
			System.out.println("Choose from the following: ");
			viewMenu(); //displays menu for reference while adding items in package
			int choice = sc.nextInt();
			
			switch(choice){
				case 1: deal[i] = ??
		}
			
		throw new UnsupportedOperationException();
	}

	public int getNumOfAlaCarte() {
		return this.numOfAlaCarte;
	}

	/**
	 * Set the number of MenuItem in the package
	 * @param numOfAlaCarte
	 */
	public void setNumOfAlaCarte(int numOfAlaCarte) {
		this.numOfAlaCarte = numOfAlaCarte;
	}

	public void addPackageItems() {
		
		}
		throw new UnsupportedOperationException();
	}

	public void removePackageItems() {
		// TODO - implement Package.removePackageItems
		throw new UnsupportedOperationException();
	}

}
