package Country;

/**
 * Class responsible for 
 * @author laisb
 */
public class Country {
	
	private String code;
	private String name;
	private Continent continent; //Enum class with continents listed
	private long surfaceArea;
	private String headOfState;
	
	//Implementation of builder pattern
	private Country(CountryBuilder builder) {
		this.code = builder.getCode();
		this.name = builder.getName();
		this.continent = builder.getContinent();
		this.surfaceArea = builder.getSurfaceArea();
		this.headOfState = builder.getHeadOfState();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the Continent from EnumTest Class
	 * @return continent
	 */
	public Continent getContinent() {
		return continent;
	}

	/**
	 * gets the continent value from EnumTest Class
	 */
    public void setContinent(){
        for (Continent continent : Continent.values()){
            System.out.println(continent);
        }
    }

	public long getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(long surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
	@Override
	public String toString() {
		return "Code: " + code + " Name: " + name + " Continent: " + continent +
				" Surface Area: " + surfaceArea + " Head of State: "+ headOfState;
		
	}	
	
	/**
	 * Inner class implementing builder pattern
	 */
	public static class CountryBuilder{
		private String code;
		private String name;
		private Continent continent;
		private long surfaceArea;
		private String headOfState;
		
		//constructor
		public CountryBuilder(String code, String name, 
				Continent continent, long surfaceArea, String headOfState) {
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.surfaceArea = surfaceArea;
			this.headOfState = headOfState;
	}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public CountryBuilder setCode(String code) {
			this.code = code;
			return this;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public CountryBuilder setName(String name) {
			this.name = name;
			return this;
		}

		/**
		 * @return the continent
		 */
		public Continent getContinent() {
			return continent;
		}

		/**
		 * @param continent the continent to set
		 */
		public CountryBuilder setContinent(Continent continent) {
			this.continent = continent;
			return this;
		}

		/**
		 * @return the surfaceArea
		 */
		public long getSurfaceArea() {
			return surfaceArea;
		}

		/**
		 * @param surfaceArea
		 */
		public CountryBuilder setSurfaceArea(long surfaceArea) {
			this.surfaceArea = surfaceArea;
			return this;
		}

		/**
		 * @return headOfState String
		 */
		public String getHeadOfState() {
			return headOfState;
		}

		/**Sets head of state column 
		 * @param headOfState string to set
		 */
		public CountryBuilder setHeadOfState(String headOfState) {
			this.headOfState = headOfState;
			return this;
		}
		
		/**Builds the new instance of Country objects
		 * @return instance of a new Country Object
		 */
		public Country build(){
			return new Country(this);
		}		

	}//end of CountryBuilder inner class
}//end of Country Class

