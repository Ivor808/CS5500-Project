# Health Data Tool Kit
## Features Delivered
### Main Page
* Users can view their loaded data and add new data from the home page. Each entry can be further viewed with the types button. They can also be edited and deleted with the respective button.
![test](https://i.imgur.com/gjcaHHM.png)

### Add an Entry
* Database etries can be added manually from this page. Only adding the date and calories is currently supported; types and activities will be missing from these entries.
![add](https://i.imgur.com/ZnXw9PB.png)

### Edit an Entry
* Date entries are edited here to change their calories idle.
![edit](https://i.imgur.com/ok6bzhT.png)

### View Activity Types
* A date entry can be further expanded to view a days activities done.
![view2](https://i.imgur.com/zWnDdCJ.png)

### View Specific Day Activity
* Each activity can then be further examined to view what was done during that activity.
![view3](https://i.imgur.com/jsYb0nT.png)

### JSON Data Loading
--Karan to write--

## How to run
Database Used:
We have used a remote database. You can look at its properties in the src/main/resources/application.properties file. In the event that the
remote database is down or the data has been erased, follow the steps below to make the program work on your local MySQL server:

1) Edit the application properties to fit your local MySQL server's configurations.
2) Uncomment the code in the saveToRemote function in the SpringbootInfrastructureApplication class. It currently saves the first 5 records but you can
modify the code in order to save more records.
3) Run the springboot application. This will execute DDL commands and you will have a populated schema on your local server.

Steps to run:

1) Run the springboot application

That's it! The remote database has been prepopulated using the commented code in the saveToRemote function in the SpringbootInfrastructureApplication class.
You can use the following REST endpoints to query the data (all of them are get operations)

## REST API
REST endpoints (they are functional):
* Get all the date objects: http://localhost:8080/activitydb/datelog
* Get all the activity objects: http://localhost:8080/activitydb/activity
* Get all the move objects: http://localhost:8080/activitydb/move
* Get all the place objects: http://localhost:8080/activitydb/place
* Get all the type objects: http://localhost:8080/activitydb/type

## Code Metrics

## Known Problems


## Resources
1) Remote Database: https://db4free.net/
2) Running Springboot Applications: https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html
3) Springboot and MySQL: https://spring.io/guides/gs/accessing-data-mysql/
4) https://www.baeldung.com/hibernate-inheritance
