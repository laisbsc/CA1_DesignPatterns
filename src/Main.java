import java.util.ArrayList;

public class Main{

    public static void main (String[] args){
        /**
         * this will be the instance to have Singleton implementation
         */
        CountryDAO dao = new MySqlCountryDAO(); //instance of dao

        ArrayList<Country> countries = dao.getCountries();
        for (Country c : countries){
            System.out.println(c);
        }

        /**
         * retrieving findCustomerByCode method
         */
        Country c = dao.findCountryByCode(2);
        System.out.println(c);

        /**
         * save country method
         */
        //dao.saveCountry(c);
        c = dao.findCountryByCode(198);
        //System.out.println(countries.size());


    }
}