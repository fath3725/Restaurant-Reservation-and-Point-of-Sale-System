public class MenuItem {

	protected String id;
	protected String name;
	protected float price;
	protected String description;
	protected int quantity;

	public String getId() {
		return this.id;
	}

	/**
	 * Set MenuItem ID
	 * @param String id
	 */
	public void setId(String id) {
		this.id = id;
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * Set MenuItem Name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	/**
	 * Set MenuItem Price
	 * @param float price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * Set MenuItem Description
	 * @param String description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * Set MenuItem Quantity
	 * @param int quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
