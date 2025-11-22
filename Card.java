// CSC 345 Term Project - Milestone #1
// Wyatt Harris, Anna Graham, Kenneth Jamieson

public class Card
{
    // Instance variables
    private String suit;
    private String rank;

    // Constructor
    public Card(String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit()
    {
        return suit;
    }

    public String getRank()
    {
        return rank;
    }


    // toString method
    @Override
    public String toString()
    {
        return "[" + rank + " of " + suit + "]";
    }
}
