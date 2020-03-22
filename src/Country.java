
public class Country {
	
	private int code;
	private String name;
	private String continent;
	private long surfaceArea;
	private String headOfState;
	
	public Country(int code, String name, String continent, long surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
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
