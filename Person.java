public interface Person {

	String name = '';
	String gender = '';
	String title = '';

	String getName();

	/**
	 * 
	 * @param name
	 */
	void setName(String name);

	String getGender();

	/**
	 * 
	 * @param gender
	 */
	void setGender(String gender);

	String getTitle();

	/**
	 * 
	 * @param title
	 */
	void setTitle(String title);

	void addPerson();

	void removePerson();

}