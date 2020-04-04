# CA1_DesignPatterns
## Continuous Assessment I - Objected Oriented Design Patterns

This assignment requires the development of a Java-based application to a Database hosted on MySQL.
The app should output all records from a given database, retrieve records by name, by code(ID) and add new records into the database.

The app should be implemented using Data Access Object Pattern, used to access the DataSource class, obeying the principles of encapsulation. In addition, to 2 other creational patters were used on this application.

The Thread Safe Singleton Pattern implementation was done on the connection from the application to the database. The goal is to  mantained that connection singly instantiated, even on a multithreaded environment. To accomplish such, the getInstance() method was made 'synchronized' (use of the key word) so that multiple threads cannot access the same (unique) instance of the database concurrently. The idea behind this pattern is to make sure the class is responsible for its own instantiation (which should be unique). the hidden constructor in the class guarantees the class won't be instantiated outside the class and the public static makes possible to be accessed by the Sinlgeton.getInstance() method.

The second creational design pattern chosen was the Builder Pattern. This helped with the design of the program, by implementing  encapsulation, creating and assembling the several parameters in the Country class in a separate Builder object, called CountryBuilder. This class allows the object creation to the handles by the 'builder', instead of creating the objects directly.

### TO-DO ###
 > Builder pattern DEBUG;
 > CLI - save country method - allow for param. to be inserted by user.
 > CLI > validation on string characters for user input.

### Testing
The user interaction is provided by a CLI client. The front-end allows the user to interact and test the application throughly.
When the program runs, the user will be prompted with a series of options to type and their respective actions. Typing '0' when prompted exists the application.
    

### Submission
- .zip file with a .txt with the link to this repo uploaded to Moodle [link to this repo];
- README.md with the justification of the chosen design patterns and a basic manual of how to interact with the CLI.
