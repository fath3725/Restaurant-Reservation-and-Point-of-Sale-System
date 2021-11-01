public class AlaCarte extends MenuItem {

	private AlaCarteCategory category;
	/**
	 * Creates a new AlaCarte with the given id, name, price and description, quantity and category.
	 * @param id This AlaCarte's id.
	 * @param name This AlaCarte's name.
	 * @param price This AlaCarte's price.
	 * @param description This AlaCarte's description.
	 * @param quantity This AlaCarte's quantity.
	 * @param category This AlaCarte's category.
	 */
	public AlaCarte(int id,String name, float price, String description,int quantity,AlaCarteCategory category) {
		super(id,name,price,description,quantity);
		this.category=category;
	}
	/**
	 * Gets the category of this menuitem.
	 * @return this menuitem's category.
	 */
	public String getCategory() {
		return this.category.toString();
	}
	/**
	 * Sets the category of this menuitem.
	 */
	public void setCategory(AlaCarteCategory category) {
		this.category = category;
	}

}
