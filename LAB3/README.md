Homework

- First I created Person and Company classes and then extended from Person the following two classes: Designer and Programmer;
- The most important class is actually Network class which contains all the nodes within a network, memorizing them all via a List;
- - checkImportance() method simply returns a node's importance within a network by counting all the relationships it has either with another node that is an instance of Person class or Company class (thus why I used maps);
- - To print the network I used showNetwork() method that creates an ArrayList of all the nodes and sorts them all in order to display them on the screen in ascending order based on their importance;
