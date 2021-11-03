public class Table {
	/**
	 * The indexing for each table added/removed.
	 */
	private static int tableIdCount=0;
	/**
	 * The ID of this table.
	 */
	private int tableID;
	/**
	 * The size of this table.
	 */
	private int tableSize;
	/**
	 * The status of this table.
	 */
	private Status status;
	/**
	 * The current pax of this table.
	 */
	private int tablePax;

	/**
	 * Creates a new table with the given ID and size.
	 * @param tableSize This table's size.
	 */
	public Table(int tableSize) {
		this.tableID = tableIdCount++;
		this.tableSize = tableSize;
		this.tablePax = 0;
		this.status = Status.AVAILABLE;
	}
	/**
	 * Gets the ID of this table.
	 * @return this table's ID.
	 */
	public int getTableID() {
		return this.tableID;
	}
	/**
	 * Changes the ID of this table.
	 * @param tableID This table's new ID.
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	/**
	 * Gets the size of this table.
	 * @return this table's size.
	 */
	public int getTableSize() {
		return this.tableSize;
	}
	/**
	 * Changes the size of this table.
	 * @param tableSize This table's new size.
	 */
	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}
	/**
	 * Gets the status of this table.
	 * @return this table's status.
	 */
	public Status getStatus() {
		return this.status;
	}
	/**
	 * Changes the status of this table.
	 * @param status This table's new status.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * Gets the pax of this table.
	 * @return this table's pax.
	 */
	public int getTablePax() {
		return this.tablePax;
	}
	/**
	 * Changes the pax of this table.
	 * @param tablePax This table's new pax.
	 */
	public void setTablePax(int tablePax) {
		this.tablePax = tablePax;
	}

}
