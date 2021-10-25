public class AlaCarte extends MenuItem {

	private Category category;

	public AlaCarte(String name, Category category, String id, float price, String description) {
		super();
		super.name = name;
		this.category = category;
		super.id = id;
		super.price = price;
		super.description = description;
		throw new UnsupportedOperationException();
	}

	public String getCategory() {
		return this.category;
		throw new UnsupportedOperationException();
	}

	/**
	 * Set the food's category (MainCourse, Drink, Dessert)
	 * @param Category category
	 */
	public void setCategory(Category category) {
		this.category = category;
		throw new UnsupportedOperationException();
	}

}
