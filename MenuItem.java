class MenuItem {
	//we achieve abstraction here as methods in menus such 
	//as addMenuItem actually calls the methods in MenuItem,
	//but the user (staff/manager) doesn't know that
	//i.e. they know can addmenuitems but don't know how it works
	private String id;
	private String name;
	private float price;
	private String description;
	private int quantity;

	public MenuItem(String id,String name,float price,String description,int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.description=description;
		this.quantity=quantity;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	//Set MenuItem Description
	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
