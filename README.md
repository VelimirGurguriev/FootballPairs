# Final Project For Sirma Academy - Java Backend

## I. Task given:
Create an application that identifies the pair of football players who have played together in common matches for the longest time and the duration for each of those matches.  
  
(We are given the specific CSV files that hold the records that we need. We also need to work on reading from the CSV files.)
### Sample output:
>113,128,84  
101,52  
120,32
## II. Task comprehension:
### My understanding of the _**algorithmic**_ problem is:  
We need to pair the two football players who have played together for the longest time in common matches.  
When we find that out, we need to display the player ID's and the duration of the total time they have played in common matches.  
After that we need to display the match ID's and the duration of each of the matches that are part of the above equation.  
  
- Or for a more simple and visual explanation:

>**113** (Player1_ID), **128**(Player2_ID), **84** (TotalDurationPlayed)  
**101** (Match1_ID), **52** (Match1_Duration)
**120** (Match2_ID), **32** (Match2_Duration)

### My understanding of the whole project as a whole is:  
* To create a back-end Java application using the Spring framework.  
* There also has to be a native CSV file reader conversion approach without the use of external CSV reading libraries.  
* The application needs to have an SQL database connected and populated by the records in the CSV files.  
* Implement the algorithm that finds the pair of football players who have played together for the longest period of time in common matches and the duration for each of the matches.
* (optional) - to include CRUD - create, read, update, delete functions to the project.
## III. My approach to the problem:
1. Firstly I created a basic Java Spring application and introduced the tables as classes, which later on turned into entities for the DB.
2. After that I created a CSV file reader, which allowed me to process each record in the CSV files.
3. I crated the required services. I needed a FootballService (to pass to my controller) and a CSVReading service (to read the files line by line).
4. I added a controller, which I used to map the different methods to local URLs in order to visualise what is happening.
5. During the testing, I encountered a problem with the dates, since the dates in the CSV are in a different date format than the Java LocalDate one. In order to solve this issue, I created the class DateFormatConverter, with the help of with I managed to solve the issue. I also included support for different types of date formats.
6. When everything was working correctly I implemented a PostgreSQL connection and persistence of the entities.
7. I included Spring Data JPA repositories.
8. Later on I encountered a problem with the CSV reading operations and decided it would be cleaner and more structured to divide the CSV file readers into separate ones for each table.
9. After testing, I made a config class file in order to execute the methods that load the CSV info into the PostgreSQL database.
10. In order to connect the tables, however, I had to implement table relations within the table columns.
