public enum AlaCarteCategory {
	MAIN_COURSE("main course"),
	DRINK("drink"),
	DESSERT("dessert");
	private String alacartecategoryname;
	private AlaCarteCategory(String alacartecategory) {
			this.alacartecategoryname = alacartecategory;
	}
	
	@Override
	public String toString(){
			return alacartecategoryname;
	}

}

