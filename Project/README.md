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
* The implementation need to include at least 2 design patterns
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

### Alternative Approaches
[replace this with relevant information]

## Personal Reflections
[replace this with relevant information]