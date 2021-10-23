public class Reservation {

	private int pax;
	private String contact;
	private String name;
	private Table table;
	private Timestamp timeStamp;

	public Reservation() {
		// TODO - implement Reservation.Reservation
		throw new UnsupportedOperationException();
	}

	public int getPax() {
		return this.pax;
	}

	/**
	 * 
	 * @param pax
	 */
	public void setPax(int pax) {
		this.pax = pax;
	}

	public String getContact() {
		return this.contact;
	}

	/**
	 * 
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getTableID() {
		// TODO - implement Reservation.getTableID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tableID
	 */
	public void setTableID(String tableID) {
		// TODO - implement Reservation.setTableID
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

}