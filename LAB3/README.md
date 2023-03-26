Homework

- First I created Person and Company classes and then extended from Person the following two classes: Designer and Programmer;
- The most important class is actually Network class which contains all the nodes within a network, memorizing them all via a List;
- - checkImportance() method simply returns a node's importance within a network by counting all the relationships it has either with another node that is an instance of Person class or Company class (thus why I used maps);
- - To print the network I used showNetwork() method that creates an ArrayList of all the nodes and sorts them all in order to display them on the screen in ascending order based on their importance;

![image](https://user-images.githubusercontent.com/100404656/226111589-1cafa76f-c4d9-4bf7-9d36-7d81100febe2.png)

Bonus

- The structure of the first half of Bonus is overall the same when it comes to the classes that I used, I just implemented Network class so that it contains methods that actually check if the network has disconnectiong nodes;
- - The main method is checkDisconnectingNode() method where in the beginning I just saved all the nodes that have been visited in an ArrayList;
- - First I had to check if the node is unvisited. If so, I added it as visited;
- - I specially created checkTotalConnected() method to use recursion as a way to compare if the actual node I'm at is connected to the same number of nodes as the size of the actual network. Calling the method multiple times till I reached the last node its neighbors are connected to (mostly Depth First Search).

![image](https://user-images.githubusercontent.com/100404656/226113335-c5855e45-6aa7-4cf0-9b92-0e9d8aeebfd9.png)

For the second half of the bonus I implemented the main function called identifyBlocks() to identify the blocks of the network (aka the subgraphs that are maximally 2-connected) that will be returned as a List of lists. 
- In order to do that I saved all the visited nodes in a HashSet and for each node I first checked if it was actually visited already. If so, I just return the block and if not, I added it to the new block I created, and then visited it via visit() method which is basically a recursive way that goes throughout all the nodes that are its neighbors and checks if they are part of the same 2-connected subgraph.
- To check if 2 nodes are part of a 2-connected subgraph we first get the neighbors for both and check if they are related to at least one common neighbor. If there are equal to or more than 1 it means that the value returned will be "true" and we can continue the recursion by visiting each neighbor of the node I started with.

![image](https://user-images.githubusercontent.com/100404656/227602903-0d221a4d-2da3-48ec-b6d4-04a7d20b6b1e.png)

