# Laboration 2

## Environment & Tools
Lenovo Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Bitbucket

## Purpose
The main purpose of this assignment is to implement a solution of the producer / consumer pattern
using threads and also get a grasp of using graphical user interfaces (GUI) with a focus on 
Swing components.
In order to fulfill the purpose of this assignment, the following goals are to be completed:

* The solution need to consist of at least the entities ResourcePool, a GUI, a Producer and a Consumer and a Manager
which acts as an intermediate between the two.

* The Manager need to observe the resource pool and be responsible for creating and removing producers and consumers.
These changes should be done at certain intervals on the Event Dispatch Thread (EDT) and use a Timer for delays.

* Producers and consumers should run in separate threads which is started when created and stopped when removed.

* The producers and consumers should communicate with the resource pool for adding and removing resources.

* Producers adds to the resource pool a randomized value between 1 and 10 while living with a delay within 1-5 seconds.

* Consumers removes from the resource pool a randomized value between 1 and 20 while living with a delay within 1-5 seconds.

* The current active producers and consumers should be displayed in the GUI.

* The resource pool needs to provide an interface to clients.

* The manager needs to know the amount of available resources in the resource pool.

* The producer and consumer needs to be able to alter the resource pool and make use of atomic operations inside the resource pool
to account for concurrency issues.

* The resource pool need to show how the pool is filled and emptied using a graphical representation in the form of a circle
that changes size and color depending on the amount of resources in the pool.

* The resource pool should be initialized with a value of 50 and there should be 6 producers and 5 consumers at the start.

## Procedures
### Producers and Consumers
The producers and consumers are implemented as separate classes that in this case implements the Runnable interface.
The constructors bot takes a reference to the resource pool, which is used to add and remove resources from the pool.
The run method is then overridden and contains a while loop that runs as long as the thread is alive. Inside the loop, the
producer/consumer ands a random amount based on the specified range and then sleeps for a random amount of time between 1-5 seconds.
The classes also should contain a method to stop the thread, which is done by setting a boolean flag to false.

### Resource Pool
The resource pool is implemented as a separate class that is constructed with the specified starting amount of resources.
The class contains a synchronized method for adding and removing resources and utilizes an atomic integer for 
the resource amount to account for concurrency issues. 
```
public synchronized void consumeResources(int amount) {
        resourceAmount.addAndGet(-amount);
        visualizeResourcePool();
    }
```
The atomic integer is used to ensure that the resource amount is
consistent between threads. The class also contains a method to get the current amount of resources in the pool.
The resource pool also contains a method to visualize the pool, which is done by changing the size and color of a circle
based on the amount of resources in the pool. The method is called after each add or remove operation.
The resource pool then updates the GUI with the new color of the circle.

### Manager
The Manager is constructed with references to the resource pool and also takes the labels for the producers and consumers
as arguments which are used to update the GUI. The Manager implements the ActionListener interface and contains a method
that is called when the Timer is triggered That will trigger the add and remove methods for producers and consumers and update the GUI.
The manager utilizes Deques to store the producers and consumers and use them to add and remove producers and consumers 
at specified intervals using a Timer. The producer and consumer threads are started
when at the same time as they are added to the Deques and stopped when they are removed. 
```
private void decreaseProducers() {
        // If list is not empty when called, producers are stopped and removed.
        if (!activeProducers.isEmpty()) {
            activeProducers.getLast().stop();
            activeProducers.removeLast();
        }
    }
```

### GUI
The GUI extends JPanel and is constructed with references to the resource pool. The GUI creates a frame and adds the 
labels for the producers and consumers. Using the paintComponent method, the GUI draws a circle that changes size and color
based on the amount of resources in the pool. The GUI also contains a method to set the color of the circle based on the amount
which then calls the repaint method to update the GUI.

### Main
The main class is used to start the program and contains the main method that creates the resource pool with the specified
starting amount of resources and then creates the GUI using the resource pool as an argument. The main method make use of
the SwingUtilities invokeLater method to create the GUI on the Event Dispatch Thread (EDT).


## Discussion
### Purpose Fulfillment
The purpose of the assignment was to implement a solution of the producer / consumer pattern using threads and also get 
a grasp of using graphical user interfaces (GUI) with a focus on Swing components. 

### Amount of entities
The solution is implemented with the classes ResourcePool which is initialized with a specified amount of resources
and contains methods for adding and removing resources and visualizing the pool. The Producer and Consumer classes are
implemented as separate classes that implements the Runnable interface and contains a run method that adds or removes a random
amount of resources from the resource pool and then sleeps for a random amount of time between 1-5 seconds. 
The Manager class is implemented as a class that implements the ActionListener interface and contains a method that is called
when the Timer is triggered that adds and removes producers and consumers at specified intervals and updates the GUI.
Thus acting as an intermediate between the producers and consumers.
The GUI class is implemented as a class that extends JPanel and contains a method to draw a circle that changes size and color
based on the amount of resources in the pool. The Main class (Lab2) is used to start the program and contains the main method that
creates the resource pool and the GUI.

Based on the above, we may establish that the assigned goal "The solution need to consist of at least the entities 
ResourcePool, a GUI, a Producer and a Consumer and a Manager" has been fulfilled. This is supported by the fact that
the solution contains all the specified entities and that the Manager acts as an intermediate between the producers and consumers.

### Manager responsibilities and separation of threads
The Manager class is implemented in a way that it observes the resource pool by getting the resource amount from
the resource pool and updating the GUI with the amount of producers and consumers. The Manager utilizes Deques to store 
the producers and consumers and use them to add and remove producers and consumers at specified intervals using a Timer. 
The producer and consumer threads are started at the same time as they are added to the Deques and stopped when they are removed. 

Based on the above, we may establish that the assigned goal "The Manager need to observe the resource pool and be responsible for
creating and removing producers and consumers. These changes should be done at certain intervals on the Event Dispatch Thread (EDT)
and use a Timer for delays.", "The producers and consumers should run in separate threads which is started when created and
stopped when removed." and "The current active producers and consumers should be displayed in the GUI." and 
"The manager needs to know the amount of available resources in the resource pool." has been fulfilled. 
This is supported by the fact that the Manager observes the resource pool and updates the GUI with the amount of 
producers and consumers and that the Manager uses a Timer to add and remove producers 
and consumers at specified intervals and using separate threads for the producers and consumers.

### Producer and Consumer
The producer and consumer classes are implemented as separate classes that implements the Runnable interface. The classes
contain a run method that contains a while loop that runs as long as the thread is alive. Inside the loop, the producer/consumer
adds or removes a random amount of resources from the resource pool and then sleeps for a random amount of time between 1-5 seconds.
The classes also contain a method to stop the thread.

Based on the above, we may establish that the assigned goal "The producers and consumers should communicate with the resource pool
for adding and removing resources.", "Producers adds to the resource pool a randomized value between 1 and 10 while living with a delay"
and "Consumers removes from the resource pool a randomized value between 1 and 20 while living with a delay" has been fulfilled.
This due to the fact that the producer and consumer classes adds or removes a random amount of resources from the resource pool
and sleeps for a random amount of time between 1-5 seconds.

### Resource Pool
The resource pool is constructed with the specified starting amount of resources. The class contains a synchronized method for
adding and removing resources and utilizes an atomic integer for the resource amount to account for concurrency issues.
The class also contains a method to get the current amount of resources in the pool and a method to visualize the pool
by changing the size and color of a circle based on the amount of resources in the pool. 

Based on the above, we may establish that the assigned goal "The resource pool needs to provide an interface to clients.",
"The producer and consumer needs to be able to alter the resource pool and make use of atomic operations inside the resource pool"
and "The resource pool need to show how the pool is filled and emptied using a graphical representation in the form of a circle
that changes size and color depending on the amount of resources in the pool." and "The resource pool should be initialized with
a value of 50 and there should be 6 producers and 5 consumers at the start." has been fulfilled. This due to the fact
that the resource pool provides an interface to clients, that the producer and consumer classes alters the resource pool and
makes use of atomic operations and that the resource pool shows how the pool is filled and emptied using a graphical representation.
The resource pool is also initialized with a value of 50 and there are 6 producers and 5 consumers at the start.

With the above in mind, we may establish that the purpose of the assignment has been accomplished.

### Alternative Approaches
With the knowledge gained from this asignment, one might consider alternative approaches to the implementation of the solution.
While the implementation of the solution is working as intended, there are some alternative approaches that could be considered.
One alternative approach could be to use a BlockingQueue to store the producers and consumers instead of using Deques.
This would simplify the implementation of the Manager class and make it easier to add and remove producers and consumers
by using the put and take methods of the BlockingQueue.
Another approach to consider would be to use ExecutorService to manage the threads instead of starting and stopping the threads
manually. This could simplify the implementation since the ExecutorService can manage producer / consumers threads.
Using ExecutorService we may switch out the Deques in the current implementation for.
```
private ExecutorService producerExecutor;
private ExecutorService consumerExecutor;
```
To then initialize them with the starting value for the producers and consumers. Using the newFixedThreadPool method.

## Personal Reflections
The assignment has shown a basic understanding of the producer / consumer pattern and also a deeper understanding
of threads. Also some understanding the use of Swing components. The course material has been sufficient to complete 
this assignment.