Homework
- First I created the Location class which is extended by the Airport, City, GasStation classes and they contain information about certain locations;
- Secondly I created Country, Express and Highway classes which extend the main class Road;
- ProblemInstance class has under consideration mainly: 
- - isValid() method which verifies if a problem's instance is valid by checking if all the locations declared before and added to the array are part of at least one road (using the overridden method called equals);
- - canReach() method that checks if there is an actual way to reach an end point "end" that starts from a start point "start" via a connected bigger road (to do that I just created a loop and checked each location mentioned as "unvisited" followed by its neighbor until I actually got the the "end" point);
- - and also two methods that are used to add new locations and roads to the lists that the main class holds;

![image](https://user-images.githubusercontent.com/100404656/224396524-5ced3195-699f-4c38-b362-627caf04d50f.png)

Bonus
- The bonus contains 4 main classes: Bonus, Location, Road and Solution;
- Location and Road classes represent the information about each location and road in a nutshell, I also added the "toString()" method;
- Solution class is the one that describes the solution of the problem which has to find either the shortest route between two location or the fastest one;
- - First I implemented addLocation and addRoad methods which allow you to add as many locations and roads as you want, as long as they are not the same ones declared before;
- - Secondly I mostly focused on "findShortestPath" method (using Dijkstra's algorithm) that was meant to display the shortest route between "start" and "end" points 
- - - I used 2 Maps (distances and previousLocations) to keep the track of distances for each location (for the start point I marked it as being 0 in the beginning) and the previousLocation that was reached before, and also a Set in which all unvisited locations were saved;
- - - Then a simple algorithm for finding the minimum value for the distances in order to update the current location and eventually check if I have reached the "end" point, either way that one is going to be removed from the unvisited set;
- - - I updated the distance and the previousLocation for each neighbor of the current location;
- - - And lastly I constructed the route by following as long as I had a previous location to add to my path till i reached the beginning of the shortest route;
- - For the implementation of "findFastestPath" I used the same algorithm but based on the travelTime of each road and not the distance between the locations;

![image](https://user-images.githubusercontent.com/100404656/224404467-85a29f51-2823-4aad-8644-5481b0f6ba8c.png)
