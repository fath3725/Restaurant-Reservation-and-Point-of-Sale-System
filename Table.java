public class Table {

	private int tableID;
	private int tablePax;
	private ENUM status;

	/**
	 * 
	 * @param tableID
	 */
	public Table(int tableID) {
		// TODO - implement Table.Table
		throw new UnsupportedOperationException();
	}

	public int getTableID() {
		return this.tableID;
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public int getTablePax() {
		return this.tablePax;
	}

	/**
	 * 
	 * @param tablePax
	 */
	public void setTablePax(int tablePax) {
		this.tablePax = tablePax;
	}

	public ENUM getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(ENUM status) {
		this.status = status;
	}

	public void addOrderItem() {
		// TODO - implement Table.addOrderItem
		throw new UnsupportedOperationException();
	}

	public void viewOrder() {
		// TODO - implement Table.viewOrder
		throw new UnsupportedOperationException();
	}

	public void removeReservation() {
		// TODO - implement Table.removeReservation
		throw new UnsupportedOperationException();
	}

	public void printOrderInvoice() {
		// TODO - implement Table.printOrderInvoice
		throw new UnsupportedOperationException();
	}

}