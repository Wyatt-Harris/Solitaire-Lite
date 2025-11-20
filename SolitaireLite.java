

//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
public class SolitaireLite {
private Deck deck = new Deck();
private LinkedStack discard = new LinkedStack();
//Foundations
private LinkedStack[] foundations = new LinkedStack[4];
public SolitaireLite(){
    //all empty intially
    discard.push(new Card("","")); 
    foundations[0] = new LinkedStack();
    foundations[0].push(new Card("D",""));
    foundations[1] = new LinkedStack();
    foundations[1].push(new Card("H",""));
    foundations[2] = new LinkedStack();
    foundations[2].push(new Card("C",""));
    foundations[3] = new LinkedStack();
    foundations[3].push(new Card("S",""));

}
@Override
public String toString(){
return "Foundations: [" 
+ foundations[0].peek() 
+ "] [" + foundations[1].peek()
+ "] [" + foundations[2].peek()
+ "] [" + foundations[3].peek()
+ "]\nDeck: " + deck.size()
+ "  Discard: [" + discard.peek() + "]";

}
public static void main(String[] args) {

SolitaireLite s = new SolitaireLite();
System.out.println(s);
System.out.println("Choose an option:\n1) Draw from Deck\n2) Move Discard to Foundation Pile\n3) Start a new game\n4) Quit");
//add methods and a loop for options later
}

    }
