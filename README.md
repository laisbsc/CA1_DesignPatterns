# CA1_DesignPatterns
## Continuous Assessment I - Objected Oriented Design Patterns

This assignment requires the development of a Java-based application to a Database hosted on MySQL.
The app should output all records from a given database, retrieve records by name, by code(ID) and add new records into the database.

The app should be implemented using Data Access Object Pattern, used on to access the DataSource class. In addition, to 2 other creational patters should be used on this application.

I chose to utilise the Thread Safe Singleton Pattern implementation on the connection from the application to the database. The goal is to  mantained that connection singly instantiated, even on a multithreaded environment. To accomplish such, the getInstance() method was made synchronized so that multiple threads cannot access the instance concurrently.
The second creational design pattern chosen to build this application was the Builder Pattern. This helped on the modularity of the program design, such as [exempligy why and where].

### TO-DO ###
 > ENUM implementation of the continents (have a look at db schema);
 > Builder pattern implementation & reporting;
 > CLI. User-input and instructions on command-line (System.in);
 > quick manual "How-to" for the CL interface.

### Testing
It is required to create a CLI client program to test the implementation of the design patterns for this application.

### Submission
- .zip file with a .txt with the link to this repo uploaded to Moodle;
- README.md with the explanation of the design patterns chosen on the application design and a basic manual of how to interact with the CLI.
