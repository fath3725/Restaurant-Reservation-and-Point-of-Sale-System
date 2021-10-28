public class Member extends Person {

	private static int memberIdCount=1;

	private int memberId;
	private int phoneNumber;

	public Member(String name, String gender, String id, int phoneNumber, int cardID){
		super(name,gender);
		this.memberId=++Member.memberIdCount;
		this.phoneNumber = phoneNumber;
	}


	public int getMemberId() {
		return this.memberId;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
