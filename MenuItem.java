class MenuItem {
	//we achieve abstraction here as methods in menus such 
	//as addMenuItem actually calls the methods in MenuItem,
	//but the user (staff/manager) doesn't know that
	//i.e. they know can addmenuitems but don't know how it works
	private int id;
	private String name;
	private float price;
	private String description;
	private int quantity=1;

	/**
	 * Creates a new menuitem with the given id, name, price and description and quantity.
	 * @param id This menuitem's id.
	 * @param name This menuitem's name.
	 * @param price This menuitem's price.
	 * @param description This menuitem's description.
	 * @param quantity This menuitem's quantity.
	 */
	public MenuItem(int id,String name,float price,String description){
		this.id=id;
		this.name=name;
		this.price=price;
		this.description=description;
	}
	/**
	 * Gets the id of this menuitem.
	 * @return this menuitem's id.
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Sets the id of this menuitem.
	 */
	public void setId(int id) {
		this.id = id;
		throw new UnsupportedOperationException();
	}
	/**
	 * Gets the name of this menuitem.
	 * @return this menuitem's name.
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Sets the name of this menuitem.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the price of this menuitem.
	 * @return this menuitem's price.
	 */
	public float getPrice() {
		return this.price;
	}
	/**
	 * Sets the price of this menuitem.
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * Gets the description of this menuitem.
	 * @return this menuitem's description.
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * Sets the description of this menuitem.
	 */
	//Set MenuItem Description
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Gets the quantity of this menuitem.
	 * @return this menuitem's quantity.
	 */
	public int getQuantity() {
		return this.quantity;
	}
	/**
	 * Sets the quantity of this menuitem.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
