import java.util.ArrayList;

public class PromotionPackage extends MenuItem {
	//alacarte and promotionpackage have an association rlnshp
	private ArrayList<AlaCarte> packageItems;

	public PromotionPackage(int id,String name,float price,String description,int quantity,ArrayList<AlaCarte> packageItems) {
		super(id,name,price,description,quantity);
		this.packageItems=packageItems;
	}

	public void addPackageItem(AlaCarte item) {
		this.packageItems.add(item);
	}

	public void removePackageItem(int index) {
		this.packageItems.remove(index);
	}

	public ArrayList<AlaCarte> getPackageItems(){
		return this.packageItems;
	}
}