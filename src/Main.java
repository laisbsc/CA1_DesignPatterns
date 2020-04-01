import java.util.ArrayList;

public class Main{

    public static void main (String[] args){

    /**
     * testing Continent class
     * Adjust this to make sure data retrieved goes string > enum & the opposite when writing
     */
        System.out.println(Continent.EUROPE.getValue());
    	Continent cont = Continent.AFRICA;
    	cont.getValue();
    	String contfromDB = "North America";
    	Continent cont2 = Continent.getEnum(contfromDB);
    	System.out.println(cont2);


        /**
         * this will be the instance to have Singleton implementation
         */
        MySqlCountryDAO dao = new MySqlCountryDAO(); //instance of dao

        ArrayList<Country> countries = dao.getCountries();
        for (Country c : countries){
            System.out.println(c);
        }

        /**
         * retrieving findCustomerByCode method
         */
        // Country c = dao.findCountryByCode("*");
        // System.out.println(c);

        // /**
        //  * save country method
        //  */
        // dao.saveCountry(c);
        // c = dao.findCountryByCode("198");
        // System.out.println(countries.size());


    }
}