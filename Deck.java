
import java.util.ArrayList;
import java.util.Collections;

//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
public class Deck extends LinkedStack {

//constructor
public Deck(){
   
    //define a list of ranks and suits
    String[] suits = {"D","H","C","S"};
    String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
//create 52 playing cards
    for (String rank : ranks){
        for (String suit : suits){
            Card c = new Card(suit, rank);
            this.push(c);
        }
    }
    //shuffle the deck
    shuffle();

}


//shuffle method that uses arrays so Collections.shuffle can be used
public void shuffle(){

    //create an ArrayList to hold the cards temporarily
    ArrayList<Card> cards = new ArrayList<Card>();
    for(int i = 0; i < 52; i++){
        cards.add((Card)this.pop()); //Card cast since pop returns object
    }

    //use Collections.shuffle
   Collections.shuffle(cards);

   //push the cards back onto the stack
    for(Card c : cards){
         this.push(c);
    }
    
}
public String toString(){
    return "" + size;
}

}