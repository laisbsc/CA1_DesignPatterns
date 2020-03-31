
public class Country {
	
	private int code;
	private String name;
	private String continent;  //has to be an enum w the the types especified
		//https://meet.google.com/linkredirect?authuser=0&dest=https%3A%2F%2Fwww.w3schools.com%2Fjava%2Fjava_enums.asp
	private long surfaceArea;
	private String headOfState;
//	private Status status;
	
	public Country(int code, String name, String continent, long surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
		//this.status = status; //will be an enum >> for what? 
	}

	public Country(String name, String continent, long surfaceArea, String headOfState) {
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
		//this.status = status; //will be an enum >> for what? 
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setcontinent(String continent) {
		this.continent = continent;
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
		return "Code: " + code + " Name: " + name + " Continent: " + continent + " Surface Area: " + surfaceArea + "head of State: "+ headOfState;
	}	

}
