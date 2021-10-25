public class Table {

	private int tableID;
	private int tableSize;
	private Status status;

	/**
	 * Class constructor specifying objects index
	 * @param tableID
	 */
	public Table(int tableID) {
		this.tableID;
		this. tableSize = 0;
		this.status = AVAILABLE;
		throw new UnsupportedOperationException();
	}
	/**
	 * Class constructor specifying objects index and table size for accomodation
	 * @param tableID
	 */
	public Table(int tableID, int tableSize) {
		this.tableID;
		this. tableSize = tableSize;
		this.status = AVAILABLE;
		throw new UnsupportedOperationException();
	}

	public int getTableID() {
		return this.tableID;
	}

	/**
	 * Set table's ID
	 * @param int tableID
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public int getTableSize() {
		return this.tableSize;
	}

	/**
	 * Set table's accomodation size
	 * @param int tableSize
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public Status getStatus() {
		return this.status;
	}

	/**
	 * Set table's status (occupied, available, reserved)
	 * @param Status status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
