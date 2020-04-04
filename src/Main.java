import java.util.ArrayList;
import java.util.Scanner;

import Client.MySqlCountryDAO;
import Country.Continent;
import Country.Country;
import Country.Country.CountryBuilder;

public class Main{

    public static void main (String[] args){

    /**
     * testing Continent class
     * Adjust this to make sure data retrieved goes string > enum & the opposite when writing
     */
    	
        MySqlCountryDAO dao = new MySqlCountryDAO(); //instance of dao
        
        //new Country instances >> thing that I wanted to be over after implementing the builder pattern 
        Country c = null;
        Country b = null;		        

//		CLI implementation
		Scanner userInput = new Scanner(System.in);
		Scanner stringSearch = new Scanner(System.in);
		
		int choice;
		String queryKey="";
		boolean keepLooping = true;
		
		while(keepLooping) {
		System.out.println("\n\nWelcome to your DB retriever CLI interface!\n"
				+ "\nType '1' to retrieve all the database content;"
				+ "\nType '2' to find a country by typing its code;"
				+ "\nType '3' to find a country by its name;"
				+ "\nType '4' to save a country to the database (will append to the bottom of the list);"
				+ "\nType '0' to exit the program."
				+ "\nPlease enter option 1 to 4: [Type '0' to quit.]");
			choice = userInput.nextInt();
		switch(choice) {
			case 0:
				System.out.println("Good bye, now. See ya next time!");
				keepLooping = false;
				break;
			case 1:
				ArrayList<Country> countries = dao.getCountries();
				for (Country list : countries){
					System.out.println(list);
				}
				break;
			case 2:
		        try {
		        	System.out.println("Type Country code for search: ");
					queryKey = stringSearch.nextLine();
		        	c = dao.findCountryByCode(queryKey);
		       	 	System.out.println("\n***SEARCH OUTPUT***\n"
		       	 			+ "**********************************\n "+c+
		       	 			"\n**********************************");	
		        }catch(Exception e) {
		        	e.printStackTrace();
		        }
		        
		        break;
			case 3:
				try {
					System.out.println("Type Country name for search: ");
					queryKey = stringSearch.nextLine();
					ArrayList<Country> newCountry = dao.findCountryByName(queryKey);								
					for (Country country : newCountry){
						System.out.println(country);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
		        break;
			case 4:
				try {
					System.out.println("Type Country [unique] code: ");
					String codeIn = userInput.next();
					System.out.println("Type Country name: ");
					String nameIn = userInput.next();
					System.out.println("Type Country continent: ");
					Continent contIn = Continent.getEnum(userInput.next()); //this concatenation is causing the null exception on save()
					System.out.println("Type Country surface area: ");
					long areaIn = userInput.nextLong();
					System.out.println("Type Country Head of State: ");
					String hoSIn = userInput.next();
					Country d = new CountryBuilder(codeIn, nameIn, contIn, areaIn, hoSIn).build();
	       		dao.saveCountry(d);
	       		System.out.println("\n***Your addition was successful!***\n"
	       	 			+ "**********************************\n "+d+
	       	 			"\n**********************************");	
				}catch(Exception e) {
					e.printStackTrace();
				}
		        break;
		default:
			System.out.println("Not a valid choice!\\n Please try again...\n");
				}
		}
    }
}