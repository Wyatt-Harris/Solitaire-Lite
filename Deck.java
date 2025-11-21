//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
import java.util.ArrayList;
import java.util.Collections;
public class Deck extends LinkedStack {
    char[] suits = {'S', 'H', 'D', 'C'};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public Deck(){
    ArrayList<Card> cards = new ArrayList<>();
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 13; j++){
             cards.add(new Card(suits[i], ranks[j]));
        }
    }
    Collections.shuffle(cards);
    for(Card c: cards){
        push(c);
    
    }
  }    
}
