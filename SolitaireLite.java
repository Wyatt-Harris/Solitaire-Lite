//CSC 345 Term Project - Solitaire Lite
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
    
    public static SolitaireLite startNewGame(){
        SolitaireLite game = new SolitaireLite();
        return game;
    }
 
    //the draw method that first checks if the deck is empty to be able to flip it
    public void drawFromDeck(){
        //flipping the discard pile over
        if(deck.isEmpty()){
            int currentDiscardSize = discard.size();
            for(int i = 0; i < currentDiscardSize; i++){
                deck.push(discard.pop());
            }
        }
        
        Card drawn = (Card)deck.pop();
        discard.push(drawn);

    }
    
    public void moveDiscardToFoundation() {
        //checking for empty discard pile, return statement prevents error 
        if(discard.isEmpty()){
            System.out.println("The discard pile is empty!");
            return;
        }
        Card top = (Card) discard.peek();          

        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        char suit = top.getSuit();
        String rank = top.getRank();

        // Find the index of the card's rank
        int rankIndex = -1;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(rank)) {
                rankIndex = i;
                break;
            }
        }

        // Choose the correct foundation stack
        LinkedStack foundation = null;
        if (suit == 'd') foundation = diamondFoundation;
        else if (suit == 'h') foundation = heartsFoundation;
        else if (suit == 'c') foundation = clubsFoundation;
        else if (suit == 's') foundation = spadesFoundation;

        // Only allow placing if the foundation size matches the rank index
        if (foundation.size() == rankIndex) {
            foundation.push(discard.pop());
        }else{
            System.out.println("No valid move!");
        }

    }
    public static void main(String[] args) {
        //Create user input
        Scanner scn = new Scanner(System.in);
        //make the game 
        SolitaireLite game = startNewGame();
        int userInput = 0; 
        //main game loop 
        while(userInput != 4){
            System.out.println(game);
            System.out.println("Choose an option:");
            System.out.println("1) Draw from Deck");
            System.out.println("2) Move Discard to Foundation Pile");
            System.out.println("3) Start a new game");
            System.out.println("4) Quit");
            //checks for win
            if(game.isWin()){
                System.out.println("Congratulations, you win!");
                break;
            }
            userInput = scn.nextInt();
            switch(userInput){
                case 1:
                    game.drawFromDeck();
                    break;
                case 2:
                    game.moveDiscardToFoundation();
                    break;
                case 3:
                    game = startNewGame();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input, please enter a valid number.");
            }
        }
        System.out.println("Thanks for playing!");
    }
}
