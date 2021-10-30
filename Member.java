public class Member extends Person {
	/**
	 * The indexing for each member added/removed.
	 */
	private static int memberIdCount=0;
	/**
	 * The ID assign to member.
	 */
	private int memberId;
	/**
	 * The phone number of this member.
	 */
	private int phoneNumber;

	/**
	 * Creates a new member with the given name, gender and phone number.
	 * @param name This member's name.
	 * @param gender This member's gender.
	 * @param phoneNumber This member's phone number.
	 */
	public Member(String name, String gender, int phoneNumber){
		super(name,gender);
		this.memberId = Member.memberIdCount++;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Gets the ID of this member.
	 * @return this member's ID.
	 */
	public int getMemberId() {
		return this.memberId;
	}
	/**
	 * Gets the phone number of this member.
	 * @return this member's phone number.
	 */
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	/**
	 * Changes the phone number of this member.
	 * @param phoneNumber This member's new phone number.
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
