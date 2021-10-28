public class AlaCarte extends MenuItem {

	private AlaCarteCategory category;

	public AlaCarte(String name, AlaCarteCategory category, String id, float price, String description,int quantity) {
		super(id,name,price,description,quantity);
		this.category=category;
	}

	public String getCategory() {
		return this.category.toString();
	}

	public void setCategory(AlaCarteCategory category) {
		this.category = category;
	}

}
