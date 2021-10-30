public class Staff extends Person {
	/**
	 * The indexing for each staff added/removed.
	 */
	private static int staffIdCount=0;
	/**
	 * The ID assign to staff.
	 */
	private int staffId; 
	/**
	 * The job title of this staff.
	 */
	private String jobTitle;
	
	/**
	 * Creates a new staff with the given name, gender and job title.
	 * @param name This staff's name.
	 * @param gender This staff's gender.
	 * @param jobTitle This staff's job title.
	 */
	public Staff(String name, String gender, String jobTitle) {
		super(name,gender);
		this.jobTitle = jobTitle;
		this.staffId = Staff.staffIdCount++;
	}
	/**
	 * Gets the ID of this staff.
	 * @return this staff's ID.
	 */
	public int getStaffId(){
    return staffId;
  	}
	/**
	 * Gets the job title of this staff.
	 * @return this staff's job title.
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
	/**
	 * Changes the job title of this staff.
	 * @param jobTitle This staff's new job title.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
