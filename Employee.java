public class Employee implements Person {

	private int employeeID;
	private String jobTitle;

	private Employee() {
		// TODO - implement Employee.Employee
		throw new UnsupportedOperationException();
	}

	private void addEmployee() {
		// TODO - implement Employee.addEmployee
		throw new UnsupportedOperationException();
	}

	private void removeEmployee() {
		// TODO - implement Employee.removeEmployee
		throw new UnsupportedOperationException();
	}

	private String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	private void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}