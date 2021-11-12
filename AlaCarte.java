import java.util.ArrayList;
import java.util.Scanner;

public class AlaCarte extends MenuItem {
	
	private AlaCarteCategory category;
	/**
	 * Creates a new AlaCarte with the given alacarteId, name, price and description, quantity and category.
	 * @param alacarteId This AlaCarte's alacarteId.
	 * @param name This AlaCarte's name.
	 * @param price This AlaCarte's price.
	 * @param description This AlaCarte's description.
	 * @param category This AlaCarte's category.
	 */
	private AlaCarte(int alacarteId,String name, float price, String description,AlaCarteCategory category) {
		super(alacarteId,name,price,description);
		this.category=category;
	}
	/**
	 * Create new AlaCarte instance.
	 * @return new AlaCarte instance.
	 */
	public static AlaCarte newAlaCarte(){
		Scanner sc = RRPSS.sc;
		System.out.print("AlaCarte id: ");
		int alacarteId = sc.nextInt();
		System.out.println(alacarteId);
		System.out.print("AlaCarte name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println(name);
		System.out.print("AlaCarte price: ");
		Float price = sc.nextFloat();
		System.out.println(price);
		System.out.print("AlaCarte description: ");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.println(description);
		System.out.print("AlaCarte category: "+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\nCategory: ");
		int category=sc.nextInt();
		System.out.println(category);
		AlaCarteCategory accat = AlaCarteCategory.MAIN_COURSE;
		switch(category){
			case 1:
				break;
			case 2:
				accat=AlaCarteCategory.DRINK;
				break;
			case 3:
				accat=AlaCarteCategory.DESSERT;
				break;
			default:
				System.out.println("Not a valid category. It is set as Main Course");
				break;
		}
		AlaCarte newalacarte = new AlaCarte(alacarteId,name,price,description,accat);
		return newalacarte;
	}
	/**
	 * Create a clone of a AlaCarte instance.
	 * @param ac AlaCarte instance to clone
	 * @return cloned AlaCarte instance.
	 */
	public static AlaCarte cloneAlaCarte(AlaCarte ac){
		return new AlaCarte(ac.getId(),ac.getName(),ac.getPrice(),ac.getDescription(),ac.getCategory());
	}
	/**
	 * Edits the attributes of this promotionPackage.
	 * @param alaCartes The list of AlaCartes in menu
	 */
	public void editAlaCarte(ArrayList<AlaCarte> alaCartes){
		Scanner sc = RRPSS.sc;
		while (true){
			System.out.println(
				"--------------EDITING ALACARTE INFO-------------"+
				"\nId: "+getId()+
				"\nName: "+getName()+
				"\nPrice: "+getPrice()+
				"\nCategory: "+getCategory()+
				"\nDescription: "+getDescription()+
				"\n----------------------------------------------"+
				"\nWhat attribute would you like to edit?"+
				"\n1.Id"+
				"\n2.Price"+
				"\n3.Name"+
				"\n4.Description"+
				"\n5.Category"+
				"\n6.Exit");
			System.out.println("----------------------------");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			System.out.println(choice);
			System.out.println("----------------------------");
			if (choice==1){
				while(true){
					System.out.printf("Id: %d\nNew id: ",this.getId());
					int packageid = sc.nextInt();
					System.out.println(packageid);
					boolean exists=false;
					for (AlaCarte ac : alaCartes){
						if (ac.getId()==packageid){
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
				float alacarteprice = sc.nextFloat();
				System.out.println(alacarteprice);
				this.setPrice(alacarteprice);
			}else if (choice==3){
				System.out.printf("Name: %s\nNew name: ",this.getName());
				sc.nextLine();
				String alacartename = sc.nextLine();
				System.out.println(alacartename);
				this.setName(alacartename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ",this.getDescription());
				sc.nextLine();
				String alacartedescription = sc.nextLine();
				System.out.println(alacartedescription);
				this.setDescription(alacartedescription);
			}else if (choice==5){
				System.out.print("AlaCarte category:"+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\nCategory: ");
				int category=sc.nextInt();
				System.out.println(category);
				switch(category){
					case 1:
						this.setCategory(AlaCarteCategory.MAIN_COURSE);
						System.out.println("Category set as main course");
						break;
					case 2:
						this.setCategory(AlaCarteCategory.DRINK);
						System.out.println("Category set as drink");
						break;
					case 3:
						this.setCategory(AlaCarteCategory.DESSERT);
						System.out.println("Category set as dessert");
						break;
					default:
						System.out.println("Not a valid category.");
						break;
				}
			}else break;
		}
	}
	/**
	 * Gets the category of this menuitem.
	 * @return this menuitem's category.
	 */
	public AlaCarteCategory getCategory() {
		return this.category;
	}
	/**
	 * Sets the category of this menuitem.
	 * @param category category to be set for this AlaCarte
	 */
	public void setCategory(AlaCarteCategory category) {
		this.category = category;
	}

}
