//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
public class Card {
    private char suit;
    private String rank;

    public Card(char suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    public char getSuit(){
        return suit;
    }
    public String getRank(){
        return rank;
    }
    @Override
    public String toString(){
        return "" + rank + suit;
    }
    
}

