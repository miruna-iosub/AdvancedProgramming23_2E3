Homework

- First I created Person and Company classes and then extended from Person the following two classes: Designer and Programmer;
- The most important class is actually Network class which contains all the nodes within a network, memorizing them all via a List;
- - checkImportance() method simply returns a node's importance within a network by counting all the relationships it has either with another node that is an instance of Person class or Company class (thus why I used maps);
- - To print the network I used showNetwork() method that creates an ArrayList of all the nodes and sorts them all in order to display them on the screen in ascending order based on their importance;

![image](https://user-images.githubusercontent.com/100404656/226111589-1cafa76f-c4d9-4bf7-9d36-7d81100febe2.png)

Bonus

- The structure of the Bonus is overall the same when it comes to the classes that I used, I just implemented Network class so that it actually checks if the network has disconnectiong nodes;
- - The main method is checkDisconnectingNode() method where in the beginning I just saved all the nodes that have been visited in an ArrayList;
- - First I had to check if the node is unvisited. If so, I added it as visited;
- - I specially created checkTotalConnected() method to use recursion as a way to compare if the actual node I'm at is connected to the same number of nodes as the size of the actual network. Calling the method multiple times till I reach the last node its neighbors are connected to (some sort of Depth First Search).

![image](https://user-images.githubusercontent.com/100404656/226113335-c5855e45-6aa7-4cf0-9b92-0e9d8aeebfd9.png)
