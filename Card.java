//CSC 345 Term Project - Milestone #1
//Wyatt Harris and Anna Graham
public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }
    @Override
    public String toString(){
        return "" + rank + suit;
    }
    
}

