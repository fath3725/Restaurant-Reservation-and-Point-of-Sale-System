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

}
