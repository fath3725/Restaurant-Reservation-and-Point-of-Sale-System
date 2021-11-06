import java.util.*;

public class Reservation {
	/**
	 * The pax reserved.
	 */
	private int paxReserved;
	/**
	 * The phone number used for reservation.
	 */
	private int contactReservedUnder;
	/**
	 * The name used for reservation.
	 */
	private String nameReservedUnder;
	/**
	 * The table ID reserved.
	 */
	private int tableReserved;
	/**
	 * The time of reservation was made.
	 */
	private Date timeStamp;
	/**
	 * The time customer wish to reserve table for.
	 */
	private Calendar reservedForTime;

	/**
	 * Creates a new reservation with the given pax, contact, name, table and time reserved.
	 * @param pax number of people
	 * @param contact contact number
	 * @param name name reserved under
	 * @param table table id
	 * @param timeStamp time of reservation
	 * @param reservedForTime duration of reservation
	 */
	public Reservation(int pax, int contact, String name, int table,  Calendar reservedForTime) {
		this.paxReserved = pax;
		this.contactReservedUnder = contact;
		this.nameReservedUnder = name;
		this.tableReserved = table;
		Calendar cal = Calendar.getInstance();
		this.timeStamp = cal.getTime();
		this.reservedForTime = reservedForTime;
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
	public int getContactReservedUnder() {
		return this.contactReservedUnder;
	}
	/**
	 * Changes the contact number used for this reservation.
	 * @param contactReservedUnder This reservation's new contactReservedUnder.
	 */
	public void setContactReservedUnder(int contactReservedUnder) {
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
	 * Gets the table ID used for this reservation.
	 * @return this reservation's tableReserved.
	 */
	public int getTableReserved() {
		return this.tableReserved;
	}
	/**
	 * Changes the table ID used for this reservation.
	 * @param tableReserved This reservation's new tableReserved.
	 */
	public void setTableReserved(int tableReserved) {
		this.tableReserved = tableReserved;
	}
	/**
	 * Gets the time stamp of this reservation.
	 * @return this reservation's timeStamp.
	 */
	public Date getTimeStamp() {
		return this.timeStamp;
	}
	/**
	 * Changes the time stmap of this reservation.
	 * @param timeStamp This reservation's new timeStamp.
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * Gets the time reserved for this reservation.
	 * @return this reservation's reservedForTime.
	 */
	public Calendar getReservedForTime() {
		return this.reservedForTime;
	}
}