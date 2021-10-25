import java.util.*;

public class Menu {

	private ArrayList<AlaCarte> alaCartes;
	private ArrayList<Package> pakages;
	private ArrayList<PromotionPackage> promotionPackages;

	public Menu() {
		alaCartes = new ArrayList<AlaCarte>();
		packages = new ArrayList<Package>();
		promotionPackages = new ArrayList<PromotionPackage>();
		throw new UnsupportedOperationException();
	}

	public void addMenuItems() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose which of the following to remove: ");
		System.out.println("1) Ala Carte");
		System.out.println("2) Package");
		System.out.println("3) Promotion Package");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Enter menu item's name: ");
				String foodName = sc.nextString();
				System.out.println("Enter menu item's category: MAIN COURSE/DRINK/DESSERT ");
				Category foodCategory = sc.nextCategory();
				System.out.println("Enter menu item's ID: ");
				String foodID = sc.nextString();
				System.out.println("Enter menu item's price: ");
				float foodPrice = sc.nextFloat();
				System.out.println("Enter menu item's description: ");
				String foodDescription = sc.nextString();
				
				alaCartes.add(new alaCarte(foodName, foodCategory, foodID, foodPrice, foodDescription);
				break;
			case 2:
			      //to be continued
					      }
	}
					     

	public void removeMenuItems() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose which of the following to remove: ");
		System.out.println("1) Ala Carte");
		System.out.println("2) Package");
		System.out.println("3) Promotion Package");
		int choice = sc.nextInt();
		
		switch (choice){
			case 1:
				
				
				
		throw new UnsupportedOperationException();
	}

	public void editMenuItems() {
		// TODO - implement Menu.editMenuItems
		throw new UnsupportedOperationException();
	}

}
