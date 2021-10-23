public class Reservations {

	private String date;
	private String time;
	private String name;
	private int pax;
	private String contact;
	private Table[] availabilityOfTables;

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
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

	public void getAvailabilityOfTables() {
		// TODO - implement Reservations.getAvailabilityOfTables
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param index
	 */
	public void setAvailabilityOfTables(int index) {
		// TODO - implement Reservations.setAvailabilityOfTables
		throw new UnsupportedOperationException();
	}

}