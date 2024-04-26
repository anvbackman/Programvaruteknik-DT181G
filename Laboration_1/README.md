# Laboration 1

## Environment & Tools
Lenovo Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Windows Powershell, Bitbucket

## Purpose
The purpose for this assignment is to implement a manager for a thread pool. This should be done using the Object Pool pattern.
For this assignment to be considered to be achieved, the following goals should be passed:
* The manager should be implemented in a way that it initializes 5 threads and that it ensures access for clients.
* The thread ownership should be transfered to the client upon request and transferred back after being used.
* Once no threads are available in the thread pool the client will need to wait for one to be available.
* The application itself need to be implemented to make use of the threads.


## Procedures

### Resource
The Resource class represents the resource that the client will use. The resource
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
PoolManager by taking an id. The class utilizes its run method to get a resource and will then print out the time it 
took to use the resource and sleep for a set amount of time. Here we use Thread.sleep() to simulate the amount of time
that the resource is used. Since sleep() is a static method, it is called directly on the Thread. 
The sleep() method will cause the current thread to sleep for a specified amount of time. The thread will then be woken
up and the resource is returned to the pool. The Runner class also contains a method that starts the specified amount of threads.
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
by other classes making it reusable. The Runnable interface also allows for multiple threads to share the same object.
It also allows for the class to further be extended by other classes if needed and less memory is required than
using the alternative Thread class which might be more suitable depending of the needs of the application but the 
Runnable interface seems to be more preffered.

A thread pool can be a good way to manage the threads when using multiple threads. It allows for the
threads to be reused and for the resources to be managed correctly. Which can increase the performance of the application
since creating and destroying threads takes time. It also allows for control in regard to how many threads are running
at the same time. However, there are some hazards to using a thread pool. If the thread pool is not managed correctly,
it can for example lead to a deadlock. Which is when a thread is waiting for another thread to finish while that thread
is also waiting for a thread to finish. An alternative approach here would be to create a new thread for each task
instead of using a pool. When executing a task a new thread is created and is then destroyed as soon as the task is completed.

Here we are transferring thread ownership which is a good way to manage threads and resources. It allows for the client
to use the thread and resource and then return it when it is done. 
However, this could come with some downsides. Transferring thread ownership can make the
code more complex and harder to understand and therefore maintain. Also, if not handled correctly, it can
lead to synchronization issues which again can lead to deadlocks. An alternative approach here would be to for example
use Executors such as ExecutorService which can manage the threads lifecycle in the pool.

## Personal Reflections
The assignment gave me more knowledge regarding managing threads and resources with the help of a thread pool and 
the Object Pool Pattern. The course material and teachers notes were sufficient to complete the assignment.


