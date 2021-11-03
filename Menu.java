import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private ArrayList<AlaCarte> alaCartes;
	private ArrayList<PromotionPackage> promotionPackages;

	public Menu() {
		alaCartes=new ArrayList<AlaCarte>();
		promotionPackages=new ArrayList<PromotionPackage>();
	}

	public ArrayList<AlaCarte> getAlaCarte(){
		return alaCartes;
	}

	public ArrayList<PromotionPackage> getPromotionPackage(){
		return promotionPackages;
	}

	public void viewAlaCartes(){
		if (alaCartes.size()==0){
			System.out.println("No AlaCartes in menu at the moment");
			return;
		}
		boolean mainc=true,drinks=true,desserts=true;
		System.out.println("----------AlaCartes----------");
		for (int i=0; i<alaCartes.size(); i++){
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
			System.out.println("");
		}
	}

	public void viewPromotionPackages(){
		if (promotionPackages.size()==0){
			System.out.println("No PromotionPackages in menu at the moment");
			return;
		}
		System.out.println("----------PromotionPackages----------");
		for (int i=0; i<promotionPackages.size(); i++){
			System.out.println("Promotion Package Id: "+promotionPackages.get(i).getId());
			System.out.println("Name: "+promotionPackages.get(i).getName());
			System.out.println("Price: "+promotionPackages.get(i).getPrice());
			System.out.println("Description: "+promotionPackages.get(i).getDescription());
			System.out.println("Package contains:");
			ArrayList<AlaCarte> packageitems = promotionPackages.get(i).getPackageItems();
			for (int j=0;j<packageitems.size();j++){
				System.out.printf("%d %s",packageitems.get(j).getId(),packageitems.get(j).getName());
			}
			System.out.println("");
		}
	}

	public void addItems(Menu menu) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Add Menu Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package");
		int type = sc.nextInt();
		if (type==1){
			alaCartes.add(AlaCarte.newAlaCarte());
		} 
		else if (type==2){
			System.out.println("New Promotion Package creation");
			menu.viewAlaCartes();
			promotionPackages.add(PromotionPackage.newPromotionPackage(alaCartes));
		}
		sc.close();
	}

	public void removeItems() {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Remove Menu Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit");
			int type = sc.nextInt();
			if (type==1){
				while(true){
					System.out.println("Select Ala Carte id to remove, or enter -1 to quit: ");
					viewAlaCartes();
					System.out.print("Id: ");
					int id = sc.nextInt();
					if (id==-1) break;
					for (int i=0;i<alaCartes.size();i++){
						if (id == alaCartes.get(i).getId()){
							alaCartes.remove(i);
							break;
						}
					}
				}
			} else if (type==2){
				while(true){
					System.out.println("Select Promotion package id to remove, or enter -1 to quit: ");
					viewPromotionPackages();
					System.out.print("Id: ");
					int id = sc.nextInt();
					if (id==-1) break;
					for (int i=0;i<promotionPackages.size();i++){
						if (id == promotionPackages.get(i).getId()){
							promotionPackages.remove(i);
							break;
						}
					}
				}
			} else if (type==3) break;
		}
		sc.close();
	}

	public void editItems() {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("Edit Menu Item type?\n"+"1. Ala Carte\n"+"2. Promotion Package\n"+"3. Exit");
			int type = sc.nextInt();
			if (type==1){
				while(true){
					System.out.println("Select Ala Carte id to edit, or enter -1 to quit: ");
					viewAlaCartes();
					System.out.print("Id: ");
					int id=sc.nextInt();
					for (int i=0;i<alaCartes.size();i++){
						if (id==alaCartes.get(i).getId()){
							alaCartes.get(i).editAlaCarte();
							break;
						}
					}
				}
			} else if (type==2){
				while(true){
					System.out.println("Select Promotion package id to edit, or enter -1 to quit: ");
					viewPromotionPackages();
					System.out.print("Id: ");
					int id = sc.nextInt();
					if (id==-1) break;
					for (int i=0;i<promotionPackages.size();i++){
						if (id == promotionPackages.get(i).getId()){
							promotionPackages.get(i).editPromotionPackage(alaCartes);
							break;
						}
					}
				}
			} else if (type==3) break;
		}
		sc.close();
	}

}