import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	protected ArrayList<AlaCarte> alaCartes;
	protected ArrayList<PromotionPackage> promotionPackages;
	/**
	 * Creates a new Menu 
	 */
	public Menu() {
		alaCartes=new ArrayList<AlaCarte>();
		promotionPackages=new ArrayList<PromotionPackage>();
	}
	/**
	 * Gets the alaCartes of this Menu.
	 * @return an ArrayList of AlaCarte currently in menu
	 */
	public ArrayList<AlaCarte> getAlaCarte(){
		return this.alaCartes;
	}
	/**
	 * Gets the promotion packages of this Menu.
	 * @return an ArrayList of PromotionPackage currently in menu
	 */
	public ArrayList<PromotionPackage> getPromotionPackage(){
		return this.promotionPackages;
	}
	/**
	 * Views the alaCartes of this Menu.
	 */
	public void viewAlaCartes(){
		if (alaCartes.size()==0){
			System.out.println("No AlaCartes in menu at the moment");
			return;
		}
		boolean mainc=true,drinks=true,desserts=true;
		System.out.println("-------------Menu AlaCartes-------------");
		for (int i=0; i<alaCartes.size(); i++){
			System.out.println();
			if (alaCartes.get(i).getCategory()==AlaCarteCategory.MAIN_COURSE && mainc){
				System.out.println("Main courses-----------------");
				mainc=false;
			}else if (alaCartes.get(i).getCategory()==AlaCarteCategory.DRINK && drinks){
				System.out.println("Drinks-----------------------");
				drinks=false;
			}else if (alaCartes.get(i).getCategory()==AlaCarteCategory.DESSERT && desserts){
				System.out.println("Desserts---------------------");
				desserts=false;
			}
			System.out.println("AlaCarte Id: "+alaCartes.get(i).getId());
			System.out.println("Name: "+alaCartes.get(i).getName());
			System.out.println("Price: "+alaCartes.get(i).getPrice());
			System.out.println("Description: "+alaCartes.get(i).getDescription());
			
		}
		System.out.println("----------------------------------");
		System.out.println();
	}
	/**
	 * Views the promotionPackages of this Menu.
	 */
	public void viewPromotionPackages(){
		if (promotionPackages.size()==0){
			System.out.println("No PromotionPackages in menu at the moment");
			return;
		}
		System.out.println("----------Menu PromotionPackages----------");
		for (int i=0; i<promotionPackages.size(); i++){
			System.out.println();
			System.out.println("Promotion Package Id: "+promotionPackages.get(i).getId());
			System.out.println("Name: "+promotionPackages.get(i).getName());
			System.out.println("Price: "+promotionPackages.get(i).getPrice());
			System.out.println("Description: "+promotionPackages.get(i).getDescription());
			System.out.println("Package contains:");
			promotionPackages.get(i).viewPackageItems();
		}
		System.out.println("-------------------------------------");
		System.out.println();
	}
	/**
	 * Adds alaCartes into this Menu.
	 * @param menu Menu instance for reference when adding
	 */
	public void addItems(Menu menu) {
		Scanner sc = RRPSS.sc;
		while(true){
			System.out.print("Add Menu Item type?\n"+
											"1. Ala Carte\n"+
											"2. Promotion Package\n"+
											"3. Exit\n"+
											"Choice: ");
			int type = sc.nextInt();
			System.out.println(type);

			if (type==1){
				System.out.println("------New AlaCarte creation-----");
				AlaCarte newAlaCarte=AlaCarte.newAlaCarte();
				boolean exists=false;
				for (AlaCarte ac : alaCartes){
					if (newAlaCarte.getId()==ac.getId()){
						System.out.println("Alacarte with this id already exists. Use a different id.");
						exists=true;
						break;
					}
				}
				if (!exists){
					alaCartes.add(newAlaCarte);
					System.out.println("New alacarte added.");
					System.out.println("");
				}
			} 
			else if (type==2){
				System.out.println("-----New Promotion Package creation-----");
				menu.viewAlaCartes();
				if (alaCartes.size()==0){
					System.out.println("Cannot make new package.");
					continue;
				}
				PromotionPackage newPromotionPackage=PromotionPackage.newPromotionPackage(alaCartes);
				boolean exists=false;
				for (PromotionPackage ac : promotionPackages){
					if (newPromotionPackage.getId()==ac.getId()){
						System.out.println("PromotionPackage with this id already exists. Use a different id.");
						exists=true;
						break;
					}
				}
				if (!exists){
					System.out.println("New promotion package added.");
					promotionPackages.add(newPromotionPackage);
				}
			}else break;
		}
	}
	/**
	 * Removes from alaCartes/promotionPackages in this Menu.
	 */
	public void removeItems() {
		Scanner sc = RRPSS.sc;
		while(true){
			System.out.print("Remove Menu Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit\nType: ");
			int type = sc.nextInt();
			System.out.println(type);
			if (type==1){
				if (alaCartes.size()==0){
					System.out.println("No alacartes in menu to remove");
					continue;
				}
				while(true){
					if (alaCartes.size()==0){
						System.out.println("No alacartes in menu to remove");
						break;
					}
					viewAlaCartes();
					System.out.println("Select Ala Carte id to remove, or enter -1 to quit: ");
					System.out.print("Id: ");
					int id = sc.nextInt();
					System.out.println(id);
					if (id==-1) break;
					for (int i=0;i<alaCartes.size();i++){
						if (id == alaCartes.get(i).getId()){
							alaCartes.remove(i);
							System.out.println("AlaCarte removed.");
							//we have to remove from promotion package also
							for (PromotionPackage p : promotionPackages){
								for (AlaCarte a: p.getPackageItems()){
									if (a.getId()==id){
										//remove all such item from packageitems
										int initq=a.getQuantity();
										for (int j=0;j<initq;j++)
											p.removePackageItem(id);
										System.out.printf("Package %d has removed alacarte id %d from its packageItems\n",p.getId(),id);
										break;
									}
								}
							}
							break;
						}
					}
					System.out.println("Invalid ID");
				}
			} else if (type==2){
				if (promotionPackages.size()==0){
					System.out.println("No promotion packages in menu to remove");
					continue;
				}
				while(true){
					if (promotionPackages.size()==0){
						System.out.println("No promotion packages in menu to remove");
						break;
					}
					viewPromotionPackages();
					System.out.println("Select Promotion package id to remove, or enter -1 to quit: ");
					System.out.print("Id: ");
					int id = sc.nextInt();
					System.out.println(id);
					if (id==-1) break;
					for (int i=0;i<promotionPackages.size();i++){
						if (id == promotionPackages.get(i).getId()){
							promotionPackages.remove(i);
							break;
						}
					}
					System.out.println("Invalid ID");
				}
			} else if (type==3) break;
		}
		
	}
	/**
	 * Edit from alaCartes/promotionpackages in this Menu.
	 */
	public void editItems() {
		Scanner sc = RRPSS.sc;
		while(true){
			System.out.print("Edit Menu Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit\nType: ");
			int type = sc.nextInt();
			System.out.println(type);
			if (type==1){
				while(true){
					System.out.println("Select Ala Carte id to edit, or enter -1 to quit: ");
					viewAlaCartes();
					if (alaCartes.size()==0) break;
					System.out.print("Id: ");
					int id=sc.nextInt();
					System.out.println(id);
					if (id==-1) break;
					boolean found = false;
					for (int i=0;i<alaCartes.size();i++){
						if (id==alaCartes.get(i).getId()){
							found = true;
							alaCartes.get(i).editAlaCarte(this.alaCartes);
							//we have to edit from promotion package also
							for (int k=0;k<promotionPackages.size();k++){
								ArrayList<AlaCarte>packageitemlist = promotionPackages.get(k).getPackageItems();
								for (int j=0;j<promotionPackages.get(k).getPackageItems().size();j++){
									if (promotionPackages.get(k).getPackageItems().get(j).getId()==id){
										AlaCarte temp = AlaCarte.cloneAlaCarte(alaCartes.get(i));
										temp.setQuantity(packageitemlist.get(j).getQuantity());
										packageitemlist.set(j, temp);
										System.out.printf("Edited items in package %d\n",k);
										break;
									}
								}
							}
							System.out.println("Finished editing item.");
							break;
						}
					}
					if (!found)
						System.out.println("Invalid Ala Carte ID");
				}
			} else if (type==2){
				while(true){
					viewPromotionPackages();
					if(promotionPackages.size()==0) break;
					System.out.println("Select Promotion package id to edit, or enter -1 to quit");
					System.out.print("Id: ");
					int id = sc.nextInt();
					System.out.println(id);
					if (id==-1) break;
					boolean found = false;
					for (int i=0;i<promotionPackages.size();i++){
						if (id == promotionPackages.get(i).getId()){
							found = true;
							promotionPackages.get(i).editPromotionPackage(this.promotionPackages,this.alaCartes);
							System.out.println("Finished editing item.");
							break;
						}
					}
					if (!found)
						System.out.println("Invalid Promotion package ID");
				}
			} else if (type==3) break;
		}
		
	}

}