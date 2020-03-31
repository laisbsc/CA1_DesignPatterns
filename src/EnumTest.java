
public class EnumTest{
    Continent continent;   

    /**
     * I think there's something wrong here on this constructor
     * Shall I skip this and work on setting the Continent only on Country Class?
     * @param continent
     */
public EnumTest(Continent continent){
    this.continent = continent;

    }
    /**
    * Switch statement that choses between the options of continents
    */ 
    public void setContinent(){
        switch(continent){
            case ASIA:
                System.out.println("Asia");
            case EUROPE:
                System.out.println("Europe");
            case AFRICA:
                System.out.println("Africa");
            case NORTH_AMERICA:
                System.out.println("North America");
            case OCEANIA:
                System.out.println("Oceania");            
            case ANTARTICA:
                System.out.println("Antartica");
            case SOUTH_AMERICA:
                System.out.println("South America");
        }
    }
}
