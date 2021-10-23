public class Order {

	private Staff staff;
	private Table table;
	private ArrayList<MenuItem> oderItems;
	private Timestamp timeStamp;
	private float discount;

	public Order() {
		// TODO - implement Order.Order
		throw new UnsupportedOperationException();
	}

	public void print() {
		// TODO - implement Order.print
		throw new UnsupportedOperationException();
	}

	public void addOrderItem() {
		// TODO - implement Order.addOrderItem
		throw new UnsupportedOperationException();
	}

	public void removeOrderItem() {
		// TODO - implement Order.removeOrderItem
		throw new UnsupportedOperationException();
	}

	public void editOrderItem() {
		// TODO - implement Order.editOrderItem
		throw new UnsupportedOperationException();
	}

	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public float getDiscount() {
		return this.discount;
	}

	/**
	 * 
	 * @param discount
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

}