public class Table {

	private int tableID;
	private int tableSize;
	private Status status;

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

	public int getTableSize() {
		return this.tableSize;
	}

	/**
	 * 
	 * @param tableSize
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public Status getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}