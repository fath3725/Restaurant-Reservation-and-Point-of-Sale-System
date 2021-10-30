class Person {

	/**
	 * The gender of this person.
	 */
	private String gender;
	/**
	 * The first and last name of this person.
	 */
	private String name;
	/**
	 * Creates a new person with the given name and gender.
	 * @param name This person's name.
	 * @param gender This person's gender.
	 */
	
	protected Person(String name,String gender){
		this.name=name;
		this.gender=gender;
	} 
	/**
	 * Gets the first and last name of this person.
	 * @return this person's name.
	 */
	protected String getName(){
		return this.name;
	};
	/**
	 * Changes the first and last name of this person.
	 * @param name This person's new name.
	 */
	protected void setName(String name){
		this.name=name;
	};
	/**
	 * Gets the gender of this person.
	 * @return this person's gender.
	 */
	protected String getGender(){
		return this.gender;
	};
	/**
	 * Changes the gender of this person.
	 * @param gender This person's new gender.
	 */
	protected void setGender(String gender){
		this.gender=gender;
	};

}