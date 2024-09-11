package personal.project.cardmatchinggame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView player1ImageView;

    @FXML
    private Label player1Label;

    @FXML
    private ImageView player2ImageView;

    @FXML
    private Label player2Label;

    @FXML
    private Label deckLabel;

    private ArrayList<Card> player1;
    private ArrayList<Card> player2;
    private ArrayList<Card> deck;

    @FXML
    void playNextHand() {
        player1ImageView.setVisible(true);
        player2ImageView.setVisible(true);

        //while both players have at least 1 card
        if (player1.size()>0 && player2.size()>0)
        {
            Card card1 = player1.remove(0);
            Card card2 = player2.remove(0);
            deck.add(card1);
            deck.add(card2);
            System.out.printf("Card 1: %s  Card 2: %s  warDeck: %s%n", card1, card2, deck);

            player1ImageView.setImage(card1.getImage());
            player2ImageView.setImage(card2.getImage());

            // Player 1 wins
            if (card1.getValue() > card2.getValue())
                player1.addAll(deck);
            else if (card2.getValue() > card1.getValue())
                player2.addAll(deck);
            else
                playWar();

            updateLabels();
        }
        else
        {
            // Find winner
        }
        deck.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();
        deck = new ArrayList<>();

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        for(int i = 1;i <= 26; i++)
        {
            player1.add(deck.dealTopCard());
            player2.add(deck.dealTopCard());
        }

        // Testing a war - remove
//        Card aceOfSpades = new Card("spades","ace");
//        player1.add(0, aceOfSpades);
//        player2.add(0, aceOfSpades);

        player1ImageView.setVisible(false);
        player2ImageView.setVisible(false);
    }

    private void updateLabels()
    {
        player1Label.setText(String.format("%2d Cards",player1.size()));
        player2Label.setText(String.format("%2d Cards",player2.size()));
        deckLabel.setText(String.format("%2d Cards", deck.size()));
    }

    private void playWar()
    {
        if (player1.size() < 4)
        {
            // Player 2 wins
        }
        else if (player2.size()<4)
        {
            // Player 1 wins
        }
        else
        {
            // Both players add 3 cards to the war deck and flip their top card
            for (int i = 1; i <= 3; i++)
            {
                deck.add(player1.remove(0));
                deck.add(player2.remove(0));
            }
            playNextHand();
        }
    }
}