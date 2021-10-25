public class Member implements Person {

	private int phoneNumber;
	private int cardID;
	
	public Person(String name, String gender, String id, int phoneNumber, int cardID){
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.cardID = cardID;
	}
	public String getName() {
		return this.name;
	}

	/**
	 * Set member's name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return this.gender;
	}

	/**
	 * Set member's gender
	 * @param String gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getID() {
		return this.id;
	}

	/**
	 * Set member's ID
	 * @param String ID
	 */
	public void setID(String id) {
		this.id = id;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Set member's phoneNumber
	 * @param int phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getCardID() {
		return this.cardID;
	}

	/**
	 * Set member's cardID
	 * @param int cardID
	 */
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

}
