import java.util.ArrayList;
import java.util.Scanner;

public class PromotionPackage extends MenuItem {

	private ArrayList<AlaCarte> packageItems;

	/**
	 * Creates a new PromotionPackage with the given packageId, name, price and description and quantity.
	 * @param packageId This PromotionPackage's packageId.
	 * @param name This PromotionPackage's name.
	 * @param price This PromotionPackage's price.
	 * @param description This PromotionPackage's description.
	 * @param ArrayList<AlaCarte>packageItems This PromotionPackage's arraylist of AlaCartes
	 */
	private PromotionPackage(int packageId,String name,float price,String description,ArrayList<AlaCarte> packageItems) {
		super(packageId,name,price,description);
		this.packageItems=packageItems;
	}

	public static PromotionPackage newPromotionPackage(){
		Scanner sc = new Scanner(System.in);
		System.out.println("New Promotion Package creation");
		ArrayList<AlaCarte>packageItems=new ArrayList<AlaCarte>();
		Menu.viewMenuAlaCartes();
		while (true){
			System.out.println("Key in id of AlaCarte from the menu to add into your Package. Enter -1 to finish adding.");
			System.out.print("Id: ");
			int id = sc.nextInt();
			if (id==-1) break;
			boolean found=false;
			for (int i=0;i<Menu.getAlaCarte().size();i++){
				if (Menu.getAlaCarte().get(i).getId()==id) {
					packageItems.add((Menu.getAlaCarte().get(i)));
					found=true;
					break;
				}
			}
			if (!found) System.out.println("Not a valid AlaCarte id.");
			else System.out.println("Added AlaCarte.");
		}
		System.out.print("\nPackage id:");
		int packageId = sc.nextInt();
		System.out.print("\nPackage name:");
		String name = sc.nextLine();
		System.out.print("\nPackage price:");
		Float price = sc.nextFloat();
		System.out.print("\nPackage description:");
		String description = sc.nextLine();
		PromotionPackage newpromotionpackage = new PromotionPackage(packageId,name,price,description,packageItems);
		sc.close();
		return newpromotionpackage;
	}

	public void editPromotionPackage(){
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println(
				"What attribute would you like to edit?"+
				"\n1.Id"+
				"\n2.Price"+
				"\n3.Name"+
				"\n4.Description"+
				"\n5.PackageItems"+
				"\n6.Exit");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			if (choice==1){
				System.out.printf("Id: %d\nNew id: ",this.getId());
				int packageid = sc.nextInt();
				this.setId(packageid);
			}else if (choice==2){
				System.out.printf("Price: %s\nNew price: ");
				float packageprice = sc.nextFloat();
				this.setPrice(packageprice);
			}else if (choice==3){
				System.out.printf("Name: %s\nNew name: ");
				String packagename = sc.nextLine();
				this.setName(packagename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ");
				String packagedescription = sc.nextLine();
				this.setDescription(packagedescription);
			}else if (choice==5){
				System.out.println("Package Items:");
				viewPackageItems();
				System.out.println("1.Remove item from package\n2.Add item to package");
				System.out.print("Choice: ");
				int option = sc.nextInt();
				if (option==1){
					System.out.println("Remove which Id: ");
					int packageitemid = sc.nextInt();
					removePackageItem(packageitemid);
				}else if (option==2){
					Menu.viewMenuAlaCartes();
					System.out.println("Add which Id: ");
					int packageitemid = sc.nextInt();
					ArrayList<AlaCarte> menuAlacartes=Menu.getAlaCarte();
					for (int i=0;i<menuAlacartes.size();i++){
						if (packageitemid==menuAlacartes.get(i).getId()){
							addPackageItem(menuAlacartes.get(i));
						}
					}
				}
			}else break;
		}
		sc.close();
	}

	public void viewPackageItems(){
		for (int i=0;i<packageItems.size();i++){
			System.out.printf("%d %s\n",packageItems.get(i).getId(),packageItems.get(i).getName());
		}
	}
	/**
	 * Gets the packageItems of this promotionPackage.
	 * @return this promotionPackages's packageItems.
	 */
	public ArrayList<AlaCarte> getPackageItems() {
		return this.packageItems;
	}
	/**
	 * Adds AlaCartes to the packageItems of this promotionPackage.
	 */
	public void addPackageItem(AlaCarte item) {
		this.packageItems.add(item);
	}
	/**
	 * Removes AlaCartes from the packageItems of this promotionPackage.
	 */
	public void removePackageItem(int index) {
		this.packageItems.remove(index);
	}
}