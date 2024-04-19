# Laboration 3

## Environment & Tools
[replace this with relevant information]

## Purpose
[replace this with relevant information]

## Procedures
[replace this with relevant information]

## Discussion
### Purpose Fulfillment
[replace this with relevant information]

### Alternative Approaches
[replace this with relevant information]

IntStream.range(0, amountOfCards / 2).forEach(i -> {
cards[i * 2] = new Card(i + 1);
cards[i * 2 + 1] = new Card(i + 1);
});


private void enableButtons(boolean enable) {
for (int i = 0; i < amountOfCards; i++) {
view.getCardButton(i).setEnabled(enable);
}
}

## Personal Reflections
[replace this with relevant information]