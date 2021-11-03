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
		System.out.print("\nAlaCarte id:");
		int alacarteId = sc.nextInt();
		System.out.print("\nAlaCarte name:");
		String name = sc.nextLine();
		System.out.print("\nAlaCarte price:");
		Float price = sc.nextFloat();
		System.out.print("\nAlaCarte description:");
		String description = sc.nextLine();
		System.out.print("\nAlaCarte category:"+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\n");
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
			default:
				System.out.println("Not a valid category.");
				break;
		}
		AlaCarte newalacarte = new AlaCarte(alacarteId,name,price,description,accat);
		sc.close();
		return newalacarte;
	}

	public void editAlaCarte(){
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println(
				"What attribute would you like to edit?"+
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
				System.out.printf("Price: %s\nNew price: ");
				float alacarteprice = sc.nextFloat();
				this.setPrice(alacarteprice);
			}else if (choice==3){
				System.out.printf("Name: %s\nNew name: ");
				String alacartename = sc.nextLine();
				this.setName(alacartename);
			}else if (choice==4){
				System.out.printf("Description: %s\nNew description: ");
				String alacartedescription = sc.nextLine();
				this.setDescription(alacartedescription);
			}else if (choice==5){
				System.out.print("\nAlaCarte category:"+"\n1.MAIN_COURSE\n2.DRINK\n3.DESSERT\n");
				int category=sc.nextInt();
				switch(category){
					case 1:
						this.setCategory(AlaCarteCategory.MAIN_COURSE);
						break;
					case 2:
						this.setCategory(AlaCarteCategory.DRINK);
						break;
					case 3:
						this.setCategory(AlaCarteCategory.DESSERT);
						break;
					default:
						System.out.println("Not a valid category.");
						break;
				}
			}else break;
		}
		sc.close();
	}
	/**
	 * Gets the category of this menuitem.
	 * @return this menuitem's category.
	 */
	public AlaCarteCategory getCategory() {
		return category;
	}
	/**
	 * Sets the category of this menuitem.
	 */
	public void setCategory(AlaCarteCategory category) {
		this.category = category;
	}

}
