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
	/**
	 * Create new Promotion Package instance.
	 * @return new PromotionPackage instance.
	 */
	public static PromotionPackage newPromotionPackage(ArrayList<AlaCarte> alaCartes){
		Scanner sc = new Scanner(System.in);
		ArrayList<AlaCarte>packageItems=new ArrayList<AlaCarte>();
		System.out.println("Key in id of AlaCarte from the menu to add into your Package. Enter -1 to finish adding.");
		while (true){
			System.out.print("Id: ");
			int id = sc.nextInt();
			if (id==-1) break;
			boolean found=false;
			for (int i=0;i<alaCartes.size();i++){
				if (alaCartes.get(i).getId()==id) {
					//check if packageitems already contains item
					for (AlaCarte a : packageItems){
						if (a.getId()==id){
							a.setQuantity(a.getQuantity()+1);
							found=true;
							break;
						}
					}
					if (!found){
						packageItems.add((alaCartes.get(i)));
						found=true;
					}
					break;
				}
			}
			if (!found) System.out.println("Not a valid AlaCarte id.");
			else System.out.println("Added AlaCarte.\nContinue?");
		}
		System.out.print("Promotion Package id: ");
		int packageId = sc.nextInt();
		System.out.print("Promotion Package name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Promotion Package price: ");
		Float price = sc.nextFloat();
		System.out.print("Promotion Package description: ");
		sc.nextLine();
		String description = sc.nextLine();
		PromotionPackage newpromotionpackage = new PromotionPackage(packageId,name,price,description,packageItems);
		
		return newpromotionpackage;
	}
	/**
	 * Edits the attributes of this promotionPackage.
	 */
	public void editPromotionPackage(ArrayList<AlaCarte> alaCartes){
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println(
				"Id: "+getId()+
				"\nName: "+getName()+
				"\nPrice: "+getPrice()+
				"\nDescription: "+getDescription()+
				"\nWhat attribute would you like to edit?"+
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
				sc.nextLine();
				String packagename = sc.nextLine();
				this.setName(packagename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ");
				sc.nextLine();
				String packagedescription = sc.nextLine();
				this.setDescription(packagedescription);
			}else if (choice==5){
				System.out.println("Package Items:");
				viewPackageItems();
				System.out.println("1.Remove item from package\n2.Add item to package");
				System.out.print("Choice: ");
				int option = sc.nextInt();
				viewPackageItems();
				if (option==1){
					System.out.println("Remove which Id: ");
					int packageitemid = sc.nextInt();
					removePackageItem(packageitemid);
				}else if (option==2){
					System.out.println("Menu AlaCarte Items: ");
					for(int i=0; i<alaCartes.size(); i++){
						System.out.printf("%d %s\n",alaCartes.get(i).getId(),alaCartes.get(i).getName());
					}
					System.out.println("Add which Id: ");
					int packageitemid = sc.nextInt();
					for (int i=0;i<alaCartes.size();i++){
						if (packageitemid==alaCartes.get(i).getId()){
							addPackageItem(alaCartes.get(i));
						}
					}
				}
			}else break;
		}
		
	}
	/**
	 * Views the packageItems of this promotionPackage.
	 */
	public void viewPackageItems(){
		System.out.println("Package Items:");
		System.out.println("Id  Quantity_and_Name");
		for (int i=0;i<packageItems.size();i++){
			System.out.printf("%d   %dx%s\n",packageItems.get(i).getId(),packageItems.get(i).getQuantity(),packageItems.get(i).getName());
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
		boolean found=false;
		for (AlaCarte packageItem : packageItems){
			if (packageItem.getId()==item.getId()){
				item.setQuantity(item.getQuantity()+1);
				found=true;
				break;
			}
		}
		if (!found)
			this.packageItems.add(item);
	}
	/**
	 * Removes AlaCartes from the packageItems of this promotionPackage.
	 */
	public void removePackageItem(int id) {
		boolean found=false;
		for (int i=0; i<packageItems.size();i++){
			if (this.packageItems.get(i).getId()==id){
				if (this.packageItems.get(i).getQuantity()==1)
					this.packageItems.remove(i);
				else
					this.packageItems.get(i).setQuantity(this.packageItems.get(i).getQuantity()-1);
				found=true;
				break;
			}
		}
		if (!found) System.out.println("Package with that id not found.");
	}
}