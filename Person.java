class Person {

	private String gender;
	private String name;

	protected Person(String name,String gender){
		this.name=name;
		this.gender=gender;
	} 

	protected String getName(){
		return this.name;
	};

	protected void setName(String name){
		this.name=name;
	};

	protected String getGender(){
		return this.gender;
	};

	protected void setGender(String gender){
		this.gender=gender;
	};

}