public class AlaCarte extends MenuItem {

	private AlaCarteCategory category;

	public AlaCarte(int id,String name, float price, String description,int quantity,AlaCarteCategory category) {
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
