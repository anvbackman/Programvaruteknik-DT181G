# Laboration 1

## Environment & Tools
Lenovo Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Windows Powershell, Bitbucket

## Purpose
The main purpose of this assignment is to create a simple manager for a thread pool using the Object Pool Manager
pattern. In order to fulfill this purpose, the following goals must be reached:
* The manager need to initialize five threads and that ensures access for the calling clients.
* Threads ownership should be transferred to the client when requested and returned to the pool when it is no longer needed.
* If there are no available threads in the pool, the client should wait until a thread is available.
* Implement a solution utilizing the threads by the client.


## Procedures

### Resource
The Resource class is implemented as a simple class that represents the resource that the client will use. The resource
is constructed using an integer value that is used as an id. The Resource class also contains methods that acts as a
timer which will be used to show how long a resource has been held by a thread.
```
public long getTimer() {
        return endTimer - startTimer;
    }
```

### PoolManager
The PoolManager is implemented using an enum Singleton and manages a pool of resources. The PoolManager initializes
a Queue of resources of the given size. A method is then implemented to get a resource from the pool. While the pool is
empty, the method will wait until a resource is available. This is done using .wait() which is causes the current thread to
wait until another thread calls notify() or notifyAll() on the same object which makes for better synchronization
between threads. Where as Thread.sleep() will cause the current thread to sleep for a specified amount of time which
which is not as efficient as .wait() in this case as it will not be notified when a resource is available.
The method will then return the resource to the client
and remove it from the pool while also starting the timer.
The PoolManager will then implement a solution to return the resource to the pool when the client is done with it using
the offer method and then notifies the waiting threads that a resource is available, while also stopping the timer.
The Pool makes use of synchronized methods to ensure that the pool is thread-safe and that the resources are handled
correctly.
```
synchronized (INSTANCE.pool) {
            INSTANCE.pool.offer(resource);
            INSTANCE.pool.notifyAll();
        }
```

### Runner
The Runner class is implemented using the Runnable interface. The Runner class is used to acquire a resource from the
PoolManager and then use the resource. The Runner class will then return the resource to
the pool when it is done with it. The Runner class will also print out the time it took to use the resource.
The Runner class takes an id which is used to identify the resource.
Using its run method the Runner class will acquire a resource if it is available and then use it with a simple print.
After using the resource the Runner class will return the resource to the pool.
The Runner class also contains a method that starts the specified amount of threads.
The threads is then started in the Main class where the method is called from the main method.
```
public static void main(String[] args) throws InterruptedException {
        Runner.startThreads();
    }
```

## Discussion
### Purpose Fulfillment

### The Manager
The PoolManager is implemented as a Singleton enum and manages a pool of resources. The PoolManager initializes a Queue
of five resources and provides methods to get and return resources to the pool. The PoolManager also ensures that the pool
is thread-safe and that the resources are handled correctly.

Based on the above, we may establish that the assigned goal "The manager need to initialize five threads and that ensures
access for the calling clients." has been fulfilled. This due to that the PoolManager initializes a pool of five resources
and provides a way for the calling clients to access them.

### Thread Ownership
The Runner class is implemented using the Runnable interface and is used to acquire a resource from the PoolManager and
then use the resource. The Runner class will then return the resource to the pool when it is done with it. The Runner class
will also print out the time it took to use the resource.

Based on the above, we may establish that the assigned goal "Threads ownership should be transferred to the client when
requested and returned to the pool when it is no longer needed." has been fulfilled. This due to that the Runner class
acquires a resource from the PoolManager and then returns it when it is done with it.

### Waiting for Resources
The get resources method in the PoolManager utilizes a while loop in order to make the client wait until a resource is
available. The method will then return the resource to the client and remove it from the pool.

Based on the above, we may establish that the assigned goal "If there are no available threads in the pool, the client
should wait until a thread is available." has been fulfilled. This due to that the PoolManager makes the client wait until
a resource is available.

### Implementing the solution
The Runner class is implemented using the Runnable interface and is used to acquire a resource from the PoolManager and
then use the resource by simply printing out the id of the resource and the current Thread.
The Runner class will then return the resource to the pool when it is done with it.

Based on the above, we may establish that the assigned goal "Implement a solution utilizing the threads by the client."
has been fulfilled. This due to that the Runner class acquires a resource from the PoolManager and then uses it by
printing out the id of the resource and the current Thread.

By fulfilling the above goals, we may establish that the purpose of the assignment has been fulfilled.

### Alternative Approaches
Although the current implementation fulfills the purpose of the assignment, the usage of the application
is very limited. In a more complex application, this could be a database connection, a socket connection, 
in a multi-threaded application, or for other expensive resources.

The Runnable interface was chosen over the Thread class as it is more flexible and allows for the class to be used
by other classes. The Runnable interface also allows for the class to be used in a multi-threaded environment.
It also allows for the class to further be extended by other classes if needed.







## Personal Reflections
[replace this with relevant information]