package personal.project.cardmatchinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Card.getValidSuits();
        List<String> faceNames = Card.getValidFaceNames();

        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                deck.add(new Card(suit, faceName));
            }
        }
    }

    /**
     * Shuffles the cards in the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * Returns the top card from the deck (returns null if the deck is empty)
     */
    public Card dealTopCard()
    {
        if (deck.size() > 0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * Returns the number of cards left in the deck
     */
    public int getNumOfCards()
    {
        return deck.size();
    }
}
