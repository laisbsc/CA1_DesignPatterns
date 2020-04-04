package Country;

/**
 * Enum class that controls the IO for the Continents
 * columns on the database
 */

public enum Continent{
    ASIA ("Asia"),
    EUROPE ("Europe"),
    NORTH_AMERICA ("North America"),
    AFRICA ("Africa"),
    OCEANIA ("Oceania"),
    ANTARCTICA ("Antarctica"),
    SOUTH_AMERICA ("South America");

    private String value;
    
    //constructor
	Continent(String value) {
		this.value = value;
    }
	
    /**
     * Returns the string value correspondent to the ENUM chosen
     * @return the continent String correspondent to the ENUM
     */
	public String getValue() {
		return this.value;
	}
	
	/**
	 * Returns the ENUM correspondent to the string input 
	 * @param continent
	 * @return Continent ENUM
	 */
	public static Continent getEnum(String continent) {
		for (Continent cont : Continent.values()) {
			if(cont.getValue().equals(continent)) {
				return cont;
			}
		}
		return null;
	}
}