import java.util.Collections;

public class Deck
{
    private Card[] cards;
    private int topCard;

    public Deck()
    {
        
        String[] suit = {"Cubs", "Diamonds", "Hearts", "Spades"};
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        // Initialize the cards array
        cards = new Card[52];

        // Index to keep track of position in the cards array
        int index = 0;

        // Loops to create the deck of cards
        for (String s : suit) 
        {
            for (String r : rank) 
            {
                cards[index] = new Card(s, r);
                index++;
            }
        }
        // Initialise the top card as the first card in the deck
        topCard = 0;

        //Shuffle the deck when created
        shuffle();

    }

    public void shuffle()
    {
        Collections.shuffle(java.util.Arrays.asList(cards));

        // Reseting the topCard after shuffling
        topCard = 0;
    }

    public Card dealCard()
    {
        if (topCard < cards.length) 
        {
            Card dealtCard = cards[topCard];
            topCard++;
            return dealtCard;
        } 
        else 
        {
            throw new RuntimeException("No more cards in the deck!");
        }
    }

    @Override
    public String toString()
    {
        return "Deck: " + (cards.length - topCard);
    }

}
