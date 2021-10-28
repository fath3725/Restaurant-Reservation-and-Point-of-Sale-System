public class Staff extends Person {

	private static int staffIdCount=0; //auto increment every employee added

	private int staffId; //unique identifier for staff
	private String jobTitle;

	public Staff(String name, String gender, String jobTitle) {
		super(name,gender);
		this.jobTitle = jobTitle;
		this.staffId=++Staff.staffIdCount;
	}

	public int getStaffId(){
    return staffId;
  }

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
