public class Customer implements Person {

	private String phoneNumber;
	private boolean isMember;

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	/**
	 * 
	 * @param isMember
	 */
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public void addMember() {
		// TODO - implement Customer.addMember
		throw new UnsupportedOperationException();
	}

	public void removeMember() {
		// TODO - implement Customer.removeMember
		throw new UnsupportedOperationException();
	}

}