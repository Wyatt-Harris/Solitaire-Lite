//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
import java.util.Scanner;
public class SolitaireLite {
    //generate deck
    Deck deck = new Deck();
    //discard
    LinkedStack discard = new LinkedStack();
    //create foundation decks and array of those decks
    LinkedStack diamondFoundation = new LinkedStack();
    LinkedStack heartsFoundation = new LinkedStack();
    LinkedStack clubsFoundation = new LinkedStack();
    LinkedStack spadesFoundation = new LinkedStack();
    LinkedStack[] foundations = {diamondFoundation, heartsFoundation, clubsFoundation, spadesFoundation}; 
    
    @Override
    public String toString(){
        String result = "Foundations:";
        for(int i = 0; i < 4; i++){
            if(foundations[i].isEmpty()){
                if(i == 0)
                    result += " [D] ";
                if(i==1)
                    result += " [H] ";
                if(i == 2)
                    result += " [C] ";
                if(i==3)
                    result += " [S] ";
            }else{
                result += " [" + foundations[i].peek() + "] ";
            }
        }
        result += "\n Deck: " + deck.size();
        if(discard.isEmpty()){
            result += "   Discard: empty";
        }else{
            result += "   Discard: [" + discard.peek() + "]";
        }
        return result;
    }

    //returns true when the deck and discard pile is empty
    public boolean isWin(){
        return deck.isEmpty() && discard.isEmpty();
    }
    /* 
    public void startNewGame(){
        SolitaireLite game = new SolitaireLite();
        System.out.println("Welcome to Solitaire Lite!");
        System.out.println(game);
        System.out.println("Choose an option:");
        System.out.println("1) Draw from Deck");
        System.out.println("2) Move Discard to Foundation Pile");
        System.out.println("3) Start a new game");
        System.out.println("4) Quit");
    }
*/  
    public String foundationNext(){
        return "hello";
    }

    //this method will eventually use the above method to actually have the logic it needs
    //for the game to function
    public Object drawFromDeck(){
        Card drawn = (Card)deck.pop();
        char suit = ' ';
        String rank = " ";
        if (drawn != null){
            suit = drawn.getSuit();
            rank = drawn.getRank();
        }
        if (suit == 'D'){
            diamondFoundation.push(drawn);
        }else if (suit == 'H'){
            heartsFoundation.push(drawn);
        }else if (suit == 'C'){
            clubsFoundation.push(drawn);
        }else if (suit == 'S') {
            spadesFoundation.push(drawn);
        }else{
            discard.push(drawn);
        }
        return drawn;
    }
    
    //this method has a filler body, this is nowhere close the correct implementation
    public boolean moveDiscardToFoundation(int pileIndex){
        boolean empty = discard.isEmpty();
        Card card = (Card)discard.pop();
        return !empty;
    }
    public static void main(String[] args) {
        //Create user input
        Scanner scn = new Scanner(System.in);
        //make the game 
        SolitaireLite game = new SolitaireLite();
        int userInput = 0; 
        //main game loop that will be expanded on
        while(userInput != 4){
            System.out.println(game);
            System.out.println("Choose an option:");
            System.out.println("1) Draw from Deck");
            System.out.println("2) Move Discard to Foundation Pile");
            System.out.println("3) Start a new game");
            System.out.println("4) Quit");
            userInput = scn.nextInt();
            switch(userInput){
                case 1:
                    System.out.println(game.drawFromDeck());
                case 2:
                    //implement later
                case 3:
                    //implement later
                case 4:
                    break;
                default:
                    System.out.println("Invalid Output");
            }
        }
        System.out.println("Thanks for playing!");
    }
}
