import java.util.ArrayList;

public class PromotionPackage extends MenuItem {
	//alacarte and promotionpackage have an association rlnshp
	private ArrayList<AlaCarte> packageItems;
	/**
	 * Creates a new PromotionPackage with the given packageId, name, price and description and quantity.
	 * @param packageId This PromotionPackage's packageId.
	 * @param name This PromotionPackage's name.
	 * @param price This PromotionPackage's price.
	 * @param description This PromotionPackage's description.
	 * @param quantity This PromotionPackage's quantity.
	 * @param ArrayList<AlaCarte>packageItems This PromotionPackage's arraylist of AlaCartes
	 */
	public PromotionPackage(int packageId,String name,float price,String description,int quantity,ArrayList<AlaCarte> packageItems) {
		super(packageId,name,price,description,quantity);
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