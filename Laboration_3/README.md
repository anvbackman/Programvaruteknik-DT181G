# Laboration 3

## Environment & Tools
Lenovo Ideapad 5, Windows 10, IntelliJ IDEA, Java, Git 2.37.3, Google Chrome, Bitbucket

## Purpose
The purpose of this assignment is to implement a graphical application implemented using Swing components.
The program should meet the requirements outlined in the assignment description. 
To accomplish the assignment the following goals should be passed:

* The application should be implemented using the MVC pattern.
* Neither Model, View or Controller should be implemented as globally accessed singletons.
* All interactions between the user and client should be done through the Controller.
* The application should be implemented using at least three unique Swing components.
* The application should be implemented using at least one Swing layout.
* The application need to show clear instructions to the user.
* The applications should make use of Streams API.

## Procedures
### Deciding on the application
The first step in the process was to decide on the application to be implemented. The assignment description
specifies that the application should be a graphical application implemented using Swing components. So the
choice of application was to create a Memory game. The Memory game is a simple game where the player has to
find matching pairs of cards.

### Implementing the application
With the use of the MVC pattern he application is divided into three main parts: Model, View and Controller. 
The Model part of the application contains the logic of the game. The View part of the application contains the 
graphical components of the game. The Controller part of the application contains the logic for the interaction 
between the user and the game.

### Model
The Model class contains the logic of the game such as the cards and the score.
The Model is initialized with the score, amount of cards and then crates a new Card object with the amount of cards.
The cards are then initialized in pairs and shuffled.
```
List<Card> cardList = Arrays.asList(cards);
        Collections.shuffle(cardList);
        cards = cardList.toArray(new Card[0]);
```
The Model also contains some basic setters and getters for the score and the cards. The Model should also contain
a method that checks if all pairs have been matched. This can be done by streaming the cards array and checking if
all cards are face up. If all cards are face up, the game is over and the user has won.
```
public boolean isGameWon() {
        return Arrays.stream(cards).allMatch(Card::isFaceUp);
    }
```
Part of the models are also the Card class which takes the cards value and utilize a boolean to keep track of if the
card is face up or not. The Card class also contains a flip method that flips the card.

### Card
The Card class is used by the Model to create cards. The Card constructor takes the value of the card as parameter.
The Card class also contains the logic for when the card flips which can be retrieved together with the value.

### Custom Listener
The program make use of a custom listener to make sure that the controller knows which card is clicked.
The listener simply contains a method that takes the card index as parameter and is then overridden in the Controller.

### View
The View class contains the graphical components of the game. The View class is initialized with the amount of cards
and a custom listener that is used to notify the controller of which card / button is clicked. It then creates a 
new JFrame. Buttons are then created for each card and added to the JFrame using the GridLayout. It also adds the
custom listener to every card.
```
IntStream.range(0, amountOfCards).forEach(i -> {
            cardButtons[i] = new JButton("");
            cardButtons[i].addActionListener(e -> listener.cardButtonClicked(i));
            gridPanel.add(cardButtons[i]);
        });
```
The constructor will also call the instructions of the game to show. The View class also contains a method that updates
the score of the game, shows the value of the cards and to show game information such as instructions and a 
victory message.


### Controller
The Controller class is the main class that manages the interactions between the Model and the View.
The Controller implements the custom listener and when the Controller is created, it creates a new Model and retrieves 
the amount of cards from the Model to then pass it to the View together with the custom listener when initializing it.

The Controller then overrides the cardButtonClicked method. This method is called when a card button is clicked. 
The method then process the card clicks against the buttons in the View
and then gets the index of the card button and gets the corresponding card from the Model. 
```
Card card = model.getCard(index);
```
                
The card is then flipped
and the second card is then flipped. If the cards match the cards should stay flipped and the score should be updated, 
otherwise the cards should be flipped back. The method then checks if all cards has been flipped and if so, the game
is over and the user is shown a victory message. 

Something to look out for here is to make sure that only two cards can be flipped at the same time. Otherwise, the cards
flipped might not be flipped back even if they do not match. To solve this issue, a boolean can be used to keep track of
if cards are being processed. One should also make sure that the user cannot click on the same card twice.
Meaning that if only one card is chosen and is face up, when clicked again it should not be flipped back. For a more
pleasant user experience, the cards should be flipped back after a short delay if they do not match.
```
Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        firstCard.flip();
        card.flip();
```

## Discussion
### Purpose Fulfillment
The purpose of this assignment was to implement an application using Swing components, using the MVC pattern 
and without using globally accessed singletons. The application should also make use of at least three unique 
Swing components, at least one Swing layout use Streams API in an appropriate way.

### MVC Pattern
The application is implemented with the three main parts Model, View and Controller. The Model part of the application contains
the logic of the game. The View part of the application contains the graphical components of the game. The Controller
part of the application contains the logic for the interaction between the user and client. Also, the Model, View and Controller
has not been implemented as globally accessed singletons.

Based on the above, we may establish that the assigned goals: "The application should be implemented using the MVC pattern.",
"Neither Model, View or Controller should be implemented as globally accessed singletons."
and "All interactions between the user and client should be done through the Controller." has been accomplished.
This due to that the application is implemented using the MVC pattern, none of the entities of Model, View or Controller
has been implemented as globally accessed singletons and all interactions between the user and client are done through 
the Controller.

### Swing Components
The application is implemented using at least three unique Swing components. The application uses JButton for the cards, 
JFrame for the main window, JLabel for the score and instructions.
The application then uses JPanel for the layout of the cards and JOptionPane to show messages. Lastly the application
utilizes Timer to make a delay for when the cards flip back over.

Based on the above, we may establish that the assigned goal: "The application should be implemented using at least three unique Swing components."
has been accomplished. This due to that the application is implemented using JButton, JFrame, JLabel, JPanel, JOptionPane and Timer.

### Swing Layout
The application is implemented using at least one Swing layout. The application uses GridLayout to layout the cards in the game
and then make use of BorderLayout to decide that the score is put on the top of the frame, the cards in the center and
the instructions button at the bottom.

Based on the above, we may establish that the assigned goal: "The application should be implemented using at least one Swing layout."
has been accomplished. This due to that the application is implemented using GridLayout and BorderLayout.

### User Instructions
The application shows clear instructions to the user. The instructions are shown in a JOptionPane when the game is started.
The instructions are also accessible through a button in the application.

Based on the above, we may establish that the assigned goal: "The application need to show clear instructions to the user."
has been accomplished. This due to that the application shows clear instructions to the user both at the start of the game
and through a button in the application.

### Streams API
The application makes use of Streams API. The application uses Streams API to create pairs of cards and to check if all cards
have been flipped. It also uses an IntStream to add action listeners to the card buttons.

Based on the above, we may establish that the assigned goal: "The applications should make use of Streams API."
has been accomplished. This due to that the application makes use of Streams API to create pairs of cards and to check if all cards
have been flipped. It is also used to add action listeners to the card buttons.

Based on all goals being reached, we may establish that the purpose of the assignment has been fulfilled.

### Alternative Approaches

In regard to the creation of the card pairs  in the Model class could have been done in a more concise way by using an
IntStream to create the cards. This would have made the code more readable and there would have been no use of generating
indices to then be used when going through the stream. But due to already utilizing an IntStream
in the View class, it was decided to try a different approach instead.
```
IntStream.range(0, amountOfCards / 2).forEach(i -> {
    cards[i * 2] = new Card(i + 1);
    cards[i * 2 + 1] = new Card(i + 1);
});
```

Regarding the cardButtonClicked method in the Controller class, there was some struggles with making sure that only two cards
could be flipped at the same time. The chosen approach was to use a boolean to keep track of if cards are being processed.
But another approach could be to disable the card buttons when two cards are flipped and then enable them again after a short delay
in the Timer.
```
private void enableButtons(boolean enable, int index) {
    for (int i = 0; i < amountOfCards; i++) {
        index.setEnabled(enable);
}
```
This however showed an animation for all buttons being disabled and enabled again which was not the desired effect.
Hence why the chosen approach ended up being the use of booleans to keep track of if cards are being processed.

However, the chosen approach provides a simple and straightforward implementation of the memory game that meets all the 
requirements of the assignment.

## Personal Reflections
The assignment fealt like good practise in regards to using the MVC pattern and also to get a better understanding of
Swing components. The assignment was quite challenging due to the restrictions of MVC but also very rewarding.
The course material and teachers notes were sufficient to complete the assignment.
