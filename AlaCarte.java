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
	public static AlaCarte newAlaCarte(){
		Scanner sc = new Scanner(System.in);
		System.out.print("AlaCarte id: ");
		int alacarteId = sc.nextInt();
		System.out.print("AlaCarte name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("AlaCarte price: ");
		Float price = sc.nextFloat();
		System.out.print("AlaCarte description: ");
		sc.nextLine();
		String description = sc.nextLine();
		System.out.print("AlaCarte category: "+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\nCategory: ");
		int category=sc.nextInt();
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
				System.out.println("Not a valid category.");
				break;
		}
		AlaCarte newalacarte = new AlaCarte(alacarteId,name,price,description,accat);
		return newalacarte;
	}
	/**
	 * Create a clone of a AlaCarte instance.
	 * @return cloned AlaCarte instance.
	 */
	public AlaCarte cloneAlaCarte(AlaCarte ac){
		return new AlaCarte(ac.getId(),ac.getName(),ac.getPrice(),ac.getDescription(),ac.getCategory());
	}
	/**
	 * Edits the attributes of this promotionPackage.
	 */
	public void editAlaCarte(){
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println(
				"Id: "+getId()+
				"\nName: "+getName()+
				"\nPrice: "+getPrice()+
				"\nCategory: "+getCategory()+
				"\nDescription: "+getDescription()+
				"\nWhat attribute would you like to edit?"+
				"\n1.Id"+
				"\n2.Price"+
				"\n3.Name"+
				"\n4.Description"+
				"\n5.Category"+
				"\n6.Exit");
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			if (choice==1){
				System.out.printf("Id: %d\nNew id: ",this.getId());
				int alacarteid = sc.nextInt();
				this.setId(alacarteid);
			}else if (choice==2){
				System.out.printf("Price: %s\nNew price: ",this.getPrice());
				float alacarteprice = sc.nextFloat();
				this.setPrice(alacarteprice);
			}else if (choice==3){
				System.out.printf("Name: %s\nNew name: ",this.getName());
				sc.nextLine();
				String alacartename = sc.nextLine();
				this.setName(alacartename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ",this.getDescription());
				sc.nextLine();
				String alacartedescription = sc.nextLine();
				this.setDescription(alacartedescription);
			}else if (choice==5){
				System.out.print("AlaCarte category:"+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\nCategory: ");
				int category=sc.nextInt();
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
	 */
	public void setCategory(AlaCarteCategory category) {
		this.category = category;
	}

}
