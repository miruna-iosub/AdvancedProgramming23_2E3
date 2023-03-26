Homework

First I created Problem class which describes the main problem and contains all the methods needed to find the students that have the number of preferences of the projects less than the average number of projects preferences;
To do that, we first needed the averageNumOfPref() that checks via an entrySet taken from a map (which contains the students and all their preferences) and returns the number after computing via a formula;
The main method is called solvingAlgorithm() and modifies the preferences map by creating greedyMap. In order to assign the first project to the first student it takes again an entrySet of the preferences and first checks if the greedyMap is empty. If not, it keeps assigning a project that is not assigned to any other student as long as the iterator hasn't reached the end of the preferences;
![image](https://user-images.githubusercontent.com/100404656/227784925-81e8578b-67b2-4cec-b8dc-1504fbc3d9f6.png)
