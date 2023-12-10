# Final Project

## Environment & Tools
Lenovi Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Windows Powershell, Bitbucket

## Purpose
The main purpose of this project is to create a project by incorporating the knowledge gained from the course modules and literature.
In order to do so, the project will aim to accomplish the following purposes:

* The application should offer the user the ability to alter some state and quit the program.
* There need to be a separation between EDT and background processing
* The implementation need to include synchronization of parallel processes
* The implementation need to include the use of atomic updates
* The implementation need to include at least 3 unique Swing components
* The implementation need to include at least 1 unique Swing layout
* The implementation need to include at least 2 design patterns not including the MVC pattern
* The implementation need to conform to the MVC pattern

## Procedures
[replace this with relevant information]

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
The game make use of the Models, Views and Controllers in its implementation, while making sure that
the communication between the roles complies with the rules. The Model and View is implemented to not
communicate with each other and rely on the Controller to update the game logic and trigger rendering.

Based on the above we may establish that the assigned goal: "The implementation need to conform to the MVC pattern"
has been accomplished. This since the implementation has been made so that changes to the logic and rendering
only is made through the controller. Not only does the Model and View not know about each other, they
don't know about the Controller either.

### Alternative Approaches
[replace this with relevant information]

## Personal Reflections
[replace this with relevant information]