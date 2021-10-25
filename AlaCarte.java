public class AlaCarte extends MenuItem {

	private Category category;

	public AlaCarte(String name) {
		this.name = name;
		this.id = "blank";
		this.price = 0.0;
		this.description = "blank";
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
