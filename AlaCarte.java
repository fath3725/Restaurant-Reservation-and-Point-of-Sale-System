public class AlaCarte extends MenuItem {

	private Category category;

	public AlaCarte(String name, Category category, String id, float price, String description) {
		this.name = name;
		this.category = category;
		this.id = id;
		this.price = price;
		this.description = description;
		throw new UnsupportedOperationException();
	}

	public String getCategory() {
		return this.category;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
		throw new UnsupportedOperationException();
	}

}
