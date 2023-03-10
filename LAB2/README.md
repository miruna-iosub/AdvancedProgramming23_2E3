Homework
- First I created the Location class which is extended by the Airport, City, GasStation classes and they contain information about certain locations;
- Secondly I created Country, Express and Highway classes which extend the main class Road;
- ProblemInstance class has under consideration mainly: 
- - isValid() method which verifies if a problem's instance is valid by checking if all the locations declared before and added to the array are part of at least one road (using the overridden method called equals);
- - canReach() method that checks if there is an actual way to reach an end point "end" that starts from a start point "start" via a connected bigger road (to do that I just created a loop and checked each location mentioned as "unvisited" followed by its neighbor until I actually got the the "end" point);
- - and also two methods that are used to add new locations and roads to the lists that the main class holds;

![image](https://user-images.githubusercontent.com/100404656/224396524-5ced3195-699f-4c38-b362-627caf04d50f.png)


Bonus
