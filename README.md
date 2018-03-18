GitHubRepository: https://github.com/jokeyweb/Sainsbury-sG.git
Author: Matteo Gagliardi
Date: 18/03/2018

The application is reading an HTML page and returns the products info in a JSON string. The IDE used is NetBeans 8.0.
---Dependencies
		- Java 8 JDK installed in the system
		- Build tool: Maven 3.5.3 (please follow link to install and configure properly)
						https://maven.apache.org/download.cgi
---How to build the app
		Windows: execute Build.bat
		Unix: execute the command line '$ mvn clean dependency:copy-dependencies package' line from home folder '..\SainsburyGroceries'

---How to run the app
		Windows: execute Run.bat
		Unix: execute the command line '$ java -cp target/SainsburyGroceries-1.0-SNAPSHOT.jar com.mg.sainsburygroceries.ScraperMain' line from home folder '..\SainsburyGroceries'
		
---How to run tests
		Windows: execute Test.bat
		Unix: execute the command line '$ mvn test' from home folder '..\SainsburyGroceries'
	note: tests are executed also during the building
