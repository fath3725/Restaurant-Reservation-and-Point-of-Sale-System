public class Staff implements Person {

	private String jobTitle;

	public Staff(String name, String gender, String id, String jobTitle) {
		this.name = name;
		this.gender = gender;
		this.id - id;
		this.jobTitle = jobTitle;
		throw new UnsupportedOperationException();
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Set employee's job title
	 * @param String jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getName() {
		return this.name;
	}

	/**
	 * Set employee's name
	 * @param String name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return this.gender;
	}

	/**
	 * Set employee's gender
	 * @param String gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getID() {
		return this.id;
	}

	/**
	 * Set employee's ID
	 * @param String ID
	 */
	public void setID(String id) {
		this.id = id;
	}

}
