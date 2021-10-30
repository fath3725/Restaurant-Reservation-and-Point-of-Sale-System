public class Reservation {

	/**
	 * The pax reserved.
	 */
	private int paxReserved;
	/**
	 * The phone number used for reservation.
	 */
	private String contactReservedUnder;
	/**
	 * The name used for reservation.
	 */
	private String nameReservedUnder;
	/**
	 * The table ID reserved.
	 */
	private int tableReserved;
	/**
	 * The time of reservation.
	 */
	private Timestamp timeStamp;

	/**
	 * Creates a new reservation with the given pax, contact, name, table and timeStamp.
	 * @param pax
	 * @param contact
	 * @param name
	 * @param table
	 * @param timeStamp
	 */
	public Reservation(int pax, int contact, String name, int table, Timestamp timeStamp) {
		this.paxReserved = pax;
		this.contactReservedUnder = contact;
		this.nameReservedUnder = name;
		this.tableReserved = table;
		this.timeStamp = timeStamp;
	}
	/**
	 * Gets the pax reserved for this reservation.
	 * @return this reservation's paxReserved.
	 */
	public int getPaxReserved() {
		return this.paxReserved;
	}
	/**
	 * Changes the pax reserved for this reservation.
	 * @param paxReserved This reservation's new paxReserved.
	 */
	public void setPaxReserved(int paxReserved) {
		this.paxReserved = paxReserved;
	}
	/**
	 * Gets the contact number used for this reservation.
	 * @return this reservation's getContactReservedUnder.
	 */
	public String getContactReservedUnder() {
		return this.contactReservedUnder;
	}
	/**
	 * Changes the contact number used for this reservation.
	 * @param contactReservedUnder This reservation's new contactReservedUnder.
	 */
	public void setContactReservedUnder(String contactReservedUnder) {
		this.contactReservedUnder = contactReservedUnder;
	}
	/**
	 * Gets the name used for this reservation.
	 * @return this reservation's getNameReservedUnder.
	 */
	public String getNameReservedUnder() {
		return this.nameReservedUnder;
	}
	/**
	 * Changes the name used for this reservation.
	 * @param nameReservedUnder This reservation's new nameReservedUnder.
	 */
	public void setNameReservedUnder(String nameReservedUnder) {
		this.nameReservedUnder = nameReservedUnder;
	}
	/**
	 * Gets the time stamp of this reservation.
	 * @return this reservation's timeStamp.
	 */
	publi
	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}
	/**
	 * Changes the time stmap of this reservation.
	 * @param timeStamp This reservation's new timeStamp.
	 */
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}