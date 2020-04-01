
/**
 * Class responsible for the implementation of the Singleton Pattern
 * on the instantiation of the DataSource class (database connection).
 */
public class SingletonInstance{
    
    private static DataSource db;

    private SingletonInstance(){} //private constructor
    
    /**
     * Thread safe singleton implementation to instantiate the connection from this class to teh MySQL database
     * @return databaseInstance
     */ 
    public static synchronized DataSource getInstance(){
        if(db == null){
            db = new DataSource(); // stablishing connection to the db
        }
        return db;
        
    }

}