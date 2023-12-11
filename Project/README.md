# Final Project

## Environment & Tools
Lenovi Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Windows Powershell, Bitbucket

## Purpose
The main purpose of this project is implement an interactive and event-driven program with the use of an UI.
The program should then meet the specified requirements outlined in the project description. Outlining
the objectives to fulfill, used as a measure for each grading criteria.
The project should be accomplished by incorporating the knowledge gained from the course modules 
and literature.
In order to do so, the project will aim to accomplish the following goals:

* The application should offer the user the ability to alter some state and quit the program.
* There need to be a separation between EDT and background processing
* The implementation need to include synchronization of parallel processes
* The implementation need to include the use of atomic updates
* The implementation need to include at least 3 unique Swing components
* The implementation need to include at least 1 unique Swing layout
* The implementation need to include at least 2 design patterns not including the MVC pattern
* The implementation need to conform to the MVC pattern

## Procedures
### Deciding the Project
The first step in the procedures was the selection of the project itself. The idea started to come to mind
even before the course itself had started meaning the implementations could start right away.
The project chosen were to implement a solution for the game Flappy Bird which would comply with the
given project information. No real pitfalls were faced in this stage due to this.

### Time constraints
Recognizing the time constraints for this type of project can be difficult at first. Making sure to begin
the procedures in the right order and figuring out a balance between the desire of implementing a game
that the creator has a clear picture of, like a more advanced version of the game rather than facing 
the reality of a more basic version that meets the requirements and the deadline. 
Which was a big problem developing this application, where time just flew by while additional functionality
and mechanics were added to a project that did not, as off yet, meet the base requirements. 
The solution, although very late were to remove all unnecessary parts that did not contribute to meeting the 
requirements. The biggest obstacle faced were to not, from the beginning implemented using the MVC pattern
but instead just making the game work. This cost loads of time later on trying to move the code around to fit the
MVC criteria. The only solution seemingly in the end, were to simply start over.

### Adhering to the criteria
Although seemingly not adhering to the assignment criteria, focus were shifted on following the criteria outlined
in the project information. With the first step were to implement a working solution utilizing the Model-View-
Controller pattern. Having started from scratch made it seemingly easier to implement a solution where the Model
only handles the games logic such as the game states and setting the score. Where the View only handles the rendering
of the graphics such as drawing said score, and where the Controller can act as a communication channel between the 
two, by for example updating and retrieving the score from the Model to then send it to the View to render the score to
the UI.

### Other Design patterns
Integrating the needed amount of design patterns alongside the MVC pattern, were a challenge since these
design patterns both needed to work with the mechanics of the game but also enhance usage of the MVC pattern
rather than undermine it. This meant choosing design patterns that actually did something with the mechanics.
After consideration, the design patterns chosen were the Observer pattern which were implemented to let the 
Controller automatically get notified of any changes made to the score, inside the Model class which the Controller
then sent to get rendered.

The other mechanic found that could benefit from a design pattern were the creation of the playable character 
and the obstacles. By implementing the Abstract Factory Pattern which can be used to create game 
objects via the Model without the specification of their concrete classes. Although this might not be very useful considering the game only
contains the Bird and Object, this could be a flexible way to make it easier in the future
if one were to implement more objects. 


## Discussion
### Purpose Fulfillment
#### User interaction
To handle the user interaction the class Controller has been implemented to let the user alter a state which lets the bird jump,
and also quit the program using a button. When the user presses the space key it triggers the
keyPressed method located in the Controller class. Depending on if the game is over, action either
calls a new game or makes the bird jump.
The ButtonPanel class contains the Quit button which uses an action listener, so that when it is clicked it triggers
the actionPerformed method. The Controller then handles the action that actually exits the game.
Other then this the user can also open the Game Information OptionPane vie a button contained in the 
ButtonPanel class. The OptionPane will then show the information needed in order to play the game.

Based on the above we may establish that the assigned goal: "The application should offer the user the ability to alter some state and quit the program"
has been accomplished. This since the implementation allows for the user to change a state in the application, quit the game and also
the addition of opening and closing the game information.

#### Separation between EDT and background processing
The EDT is responsible for handling the Swing components and the updates to the UI via the Controller class 
that uses a Swing Timer for the games loop. The actionPerformed method is then called at the interval set in said timer.
The method then updates both the game logic and repaints the UI.

The background processing is running using the backgroundProcessing method to run in a separate background thread.
This thread is also started in the Controller class, but in the constructor. The background thread updates
the graphics with the backgrounds position and adds obstacles to the Model on a different timer than the EDT.

Based on the above we may establish that the assigned goal: "The implementation need to include synchronization of parallel processes"
has been accomplished. By using a Swing Timer for the UI updates and the background thread for the background processing,
the implementation achieves a separation between the two. The invokeLater method is then used to update 
Swing components safely from the background thread.

#### Synchronization 
In the Model class the getObstacle and addObstacle methods are implemented using synchronized. This ensures
that when multiple threads try to access the methods, only one thread can execute them at a time.
Thus preventing potential issues related to modification of the obstacles list.

Based on the above we may establish that the assigned goal: "The implementation need to include synchronization of parallel processes"
has been accomplished. By marking said methods with synchronized, the code ensures that the resources are accessed
safely, thus minimizing riskt that can arise in a multithread environment.

#### Atomic updates
To ensure that shared data is accessed and modified safely in a thread, the use of atomic updates is crusial.
In the Model class atomic updates are used for managing the game score. This by the use of AtomicInteger.
The score can then safely be incremented, reset and retrieved from the Controller.

Based on the above we may establish that the assigned goal: "The implementation need to include the use of atomic updates"
has been accomplished. This due to the implementation ensuring atomic updates regarding the score of the game
with the use of AtomicInteger methods. Providing thread safety.

#### Swing Components
The implementation includes the Swing components JFrame in the View class which is used in the View class to represent the main 
window of the game by creating the GUI window with its defined configuration.
The implementation also includes the JPanel in the GamePanel class which is used to manage the rendering
of the game, such as the background, bird, obstacles and ground.
Lastly the implementation includes the JButton component in the ButtonPanel class, which are used for the
Game Info button and the Quit button. These button each have their own action listeners to handle user interaction.

Based on the above we may establish that the assigned goal: "The implementation need to include at least 3 unique Swing components"
has been accomplished. The implementation contains three different Swing components used in the game.
These includes the main window frame and panels for rendering the game and create buttons.

#### Swing Layout
The implementation includes the use of the FlowLayout in the ButtonLabel due to its simplicity in
arranging the buttons from the left to right, making the position easy to control.

Based on the above we may establish that the assigned goal: "The implementation need to include at least 1 unique Swing layout"
has been accomplished. This by implementing at least one Swing Layout, which in this case were the FlowLayout
due to its ease of use.

#### Additional design patterns
The implementation incorporates the Observer pattern which is used between the Model class and Controller class
by notifying the Controller when the score is updated in the Model class.
The implementation also incorporates the Factory Method pattern which is used to create 
the Bird and Obstacle objects. Where the ConcreteGameObject class acts as a factory for creating said objects.

Based on the above we may establish that the assigned goal: "The implementation need to include at least 2 design patterns not including the MVC pattern"
has been accomplished. This due to the use of the Observer pattern to notify the Controller of updates to the score
and the Factory Method for a flexible way of creating objects.

#### The MVC pattern
The game make use of the Models, Views and Controllers in its implementation ensuring a decoupled and organized architecture. 
Making sure that the communication between the roles complies with the requirements. The Model and View is implemented 
to not communicate with each other and rely on the Controller to update the game logic and trigger rendering.

Based on the above we may establish that the assigned goal: "The implementation need to conform to the MVC pattern"
has been accomplished. This since the implementation has been made so that changes to the logic and rendering
only is made through the controller. Not only does the Model and View not know about each other, they
don't know about the Controller either.

In conclusion, by reaching the goals set, we may establish that the purpose for this project assignment has been fulfilled.


### Alternative Approaches
With the knowledge gained from working on this project, one might benefit from opting for a different approach to the
procedures.
Regarding the challenges of time constraints and managing the order in which to implement the solution,
one might have benefited from setting up a better plan of, in what order the implementations should be made.
As highlighted, the biggest issue were not implementing the MVC pattern straight away, which resulted in
a lot of unnecessary time being spent trying to transform already written code into the MVC pattern.
Moving forward, a plan should be made containing in which order the requirements should be implemented. 
This have been a valuable lesson though, that starting simple to then rework it into something more advanced,
might be harder to do than just starting with the more advanced part. 

The integration of design patterns such as the Observer and Abstract Factory patterns posed a challenge
in terms of matching the games mechanics and not hinder them or the MVC pattern in any way. An alternative
approach to this would be to make a more detailed analysis of what the game mechanics would be used early on.
This, to incorporate this while implementing the MVC pattern instead of splitting them into two.
Meaning for example implementing the Observer pattern for the score mechanic along side the MVC pattern.
Not first figuring out how to update the score in both Model and View, to then change it further down
the road.

In conclusion this project has shown the importance of structural planning and 
integrated design pattern implementation. 
The experiences gained hopefully provide a foundation for future projects, ensuring a more 
straight forward development process.


## Personal Reflections
This project has been both challenging and rewarding. While being one of the most frustrating 
projects yet, I feel like I have ended up at what my first image of the project was. 
The project allowed for a deeper understanding into the design patterns studied in the modules, giving
a greater picture of their usability. 
Getting a feel of the Swing library, although challenging was informative.
I feel like I have gained a deeper understanding of OOP.