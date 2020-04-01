public enum Continent{
    ASIA ("Asia"),
    EUROPE ("Europe"),
    NORTH_AMERICA ("North America"),
    AFRICA ("Africa"),
    OCEANIA ("Oceania"),
    ANTARTICA ("Antartica"),
    SOUTH_AMERICA ("South America");

    private String value;
    
    //constructor
	Continent(String value) {
		this.value = value;
    }
    
	public String getValue() {
		return this.value;
	}
	public static Continent getEnum(String continent) {
		for (Continent cont : Continent.values()) {
			if(cont.getValue().equals(continent)) {
				return cont;
			}
		}
		return null;
	}
}