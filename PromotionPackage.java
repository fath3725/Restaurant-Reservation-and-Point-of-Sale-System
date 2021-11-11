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
	 * @param alaCartes alaCartes currently in Menu
	 * @return new PromotionPackage instance.
	 */
	public static PromotionPackage newPromotionPackage(ArrayList<AlaCarte> alaCartes){
		Scanner sc = RRPSS.sc;
		ArrayList<AlaCarte>packageItems=new ArrayList<AlaCarte>();
		System.out.println("Key in id of AlaCarte from the menu to add into your Package. Enter -1 to finish adding.");
		while (true){
			System.out.print("Id: ");
			int id = sc.nextInt();
			System.out.println(id);
			if (id==-1) break;
			boolean found=false;
			for (int i=0;i<alaCartes.size();i++){
				if (alaCartes.get(i).getId()==id) {
					AlaCarte newalacarte = AlaCarte.cloneAlaCarte(alaCartes.get(i)); 
					System.out.print("Quantity: ");
					int quantity = sc.nextInt();
					System.out.println(quantity);
					//check if packageitems already contains item
					for (AlaCarte a : packageItems){
						if (a.getId()==id){
							a.setQuantity(quantity);
							found=true;
							break;
						}
					}
					if (!found){
						newalacarte.setQuantity(quantity);
						packageItems.add(newalacarte);
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
		System.out.println(packageId);
		System.out.print("Promotion Package name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println(name);
		System.out.print("Promotion Package price: ");
		Float price = sc.nextFloat();
		System.out.println(price);
		System.out.print("Promotion Package description: ");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.println(description);
		PromotionPackage newpromotionpackage = new PromotionPackage(packageId,name,price,description,packageItems);
		return newpromotionpackage;
	}
	/**
	 * Create a clone of a Promotion Package instance.
	 * @param pp promotion package to clone
	 * @return cloned PromotionPackage instance.
	 */
	public static PromotionPackage clonePromotionPackage(PromotionPackage pp){
		return new PromotionPackage(pp.getId(),pp.getName(),pp.getPrice(),pp.getDescription(),pp.getPackageItems());
	}
	/**
	 * Edits the attributes of this promotionPackage.
	 * @param alaCartes currently in Menu
	 */
	public void editPromotionPackage(ArrayList<PromotionPackage> promotionPackages,ArrayList<AlaCarte> alaCartes){
		Scanner sc = RRPSS.sc;
		while (true){
			System.out.println(
				"------ITEM INFO------"+
				"\nId: "+getId()+
				"\nName: "+getName()+
				"\nPrice: "+getPrice()+
				"\nDescription: "+getDescription()+
				"\n---------------------"+
				"\nWhat attribute would you like to edit?"+
				"\n1.Id"+
				"\n2.Price"+
				"\n3.Name"+
				"\n4.Description"+
				"\n5.PackageItems"+
				"\n6.Exit");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			System.out.println(choice);
			if (choice==1){
				while(true){
					System.out.printf("Id: %d\nNew id: ",this.getId());
					int packageid = sc.nextInt();
					System.out.println(packageid);
					boolean exists=false;
					for (PromotionPackage pp : promotionPackages){
						if (pp.getId()==packageid){
							System.out.println("Id already exists. Try again.");
							exists=true;
							break;
						}
					}
					if (!exists){
						this.setId(packageid);
						break;
					}
				}
			}else if (choice==2){
				System.out.printf("Price: %s\nNew price: ",this.getPrice());
				float packageprice = sc.nextFloat();
				System.out.println(packageprice);
				this.setPrice(packageprice);
			}else if (choice==3){
				System.out.printf("Name: %s\nNew name: ",this.getName());
				sc.nextLine();
				String packagename = sc.nextLine();
				System.out.println(packagename);
				this.setName(packagename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ",this.getDescription());
				sc.nextLine();
				String packagedescription = sc.nextLine();
				System.out.println(packagedescription);
				this.setDescription(packagedescription);
			}else if (choice==5){
				System.out.println("Package Items:");
				viewPackageItems();
				System.out.println("1.Remove item from package\n2.Add item to package");
				System.out.print("Choice: ");
				int option = sc.nextInt();
				System.out.println(option);
				viewPackageItems();
				if (option==1){
					System.out.println("Remove which Id: ");
					int packageitemid = sc.nextInt();
					System.out.println(packageitemid);
					removePackageItem(packageitemid);
				}else if (option==2){
					System.out.println("Menu AlaCarte Items: ");
					for(int i=0; i<alaCartes.size(); i++){
						System.out.printf("%d %s\n",alaCartes.get(i).getId(),alaCartes.get(i).getName());
					}
					System.out.println("Add which Id: ");
					int packageitemid = sc.nextInt();
					System.out.println(packageitemid);
					for (int i=0;i<alaCartes.size();i++){
						if (packageitemid==alaCartes.get(i).getId()){
							AlaCarte toadd = AlaCarte.cloneAlaCarte(alaCartes.get(i));
							System.out.print("How many of it?\nQuantity: ");
							int quantity = sc.nextInt();
							System.out.println(quantity);
							toadd.setQuantity(quantity);
							addPackageItem(toadd);
							break;
						}
					}
				}
			}else if (choice==6) break;
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
	 * @param item AlaCarte instance to add
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
	 * @param id id of AlaCarte packageitem to remove
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