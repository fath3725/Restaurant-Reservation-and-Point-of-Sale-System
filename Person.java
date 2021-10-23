public interface Person {

	string name = blank;
	string gender = blank;
	string id = blank;

	string getName();

	/**
	 * 
	 * @param name
	 */
	void setName(string name);

	string getGender();

	/**
	 * 
	 * @param gender
	 */
	void setGender(string gender);

	string getId();

	/**
	 * 
	 * @param id
	 */
	void setId(string id);

}