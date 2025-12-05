//CSC 345 Term Project - Solitaire Lite
//Wyatt Harris, Anna Graham, Kenneth Jamieson
import java.util.InputMismatchException;
import java.util.Scanner;
public class SolitaireLite {
    //generate deck
    Deck deck;
    //discard
    LinkedStack discard;
    //create foundation decks and array of those decks
    LinkedStack diamondsFoundation;
    LinkedStack heartsFoundation;
    LinkedStack clubsFoundation;
    LinkedStack spadesFoundation; 
    LinkedStack[] foundations;

    public SolitaireLite(){
        startNewGame();
    }
    
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
    
    public void startNewGame(){
        deck = new Deck();
        discard = new LinkedStack();
        diamondsFoundation = new LinkedStack();
        heartsFoundation = new LinkedStack();
        clubsFoundation = new LinkedStack();
        spadesFoundation = new LinkedStack();
        foundations = new LinkedStack[]{diamondsFoundation, heartsFoundation, clubsFoundation, spadesFoundation}; 

    }

   
    public void drawFromDeck(){
        if(deck.isEmpty()){
            int size = discard.size();
            for(int i = 0; i < size;i++){
            Card card = (Card)discard.pop();
            deck.push(card);
            }
        }

        Card drawn = (Card)deck.pop();
        discard.push(drawn);
        
    }

    public String foundationNext(LinkedStack f){
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        if(f.size()>=ranks.length){
            return "";
        }
        return ranks[f.size()]; 
    }

    public void moveDiscardToFoundation(){

        if(discard.isEmpty()){
            System.out.println("No cards available, please draw a card.");
            return;
        }
        Card drawn = (Card)discard.peek();
        char suit = ' ';
        String rank = " ";
        if (drawn != null){
            suit = drawn.getSuit();
            rank = drawn.getRank();
        }
        if ((suit == 'D') && foundationNext(diamondsFoundation).equals(rank)){
            diamondsFoundation.push(drawn);
            discard.pop();
        }else if ((suit == 'H') && foundationNext(heartsFoundation).equals(rank)){
            heartsFoundation.push(drawn);
            discard.pop();
        }else if ((suit == 'C') && foundationNext(clubsFoundation).equals(rank)){
            clubsFoundation.push(drawn);
            discard.pop();
        }else if ((suit == 'S') && foundationNext(spadesFoundation).equals(rank)) {
            spadesFoundation.push(drawn);
            discard.pop();
        }else {
            System.out.println("No Valid Move.");
        }
}
    public static void main(String[] args) {
        //Create user input
        try (Scanner scn = new Scanner(System.in)) {
            //make the game 
            SolitaireLite game = new SolitaireLite();
            int userInput = 0; 
            //main game loop that will be expanded on
            while((userInput != 4)){
                if(game.isWin()){
                break;
                }
                System.out.println(game);
                System.out.println("Choose an option:");
                System.out.println("1) Draw from Deck");
                System.out.println("2) Move Discard to Foundation Pile");
                System.out.println("3) Start a new game");
                System.out.println("4) Quit");
                
                try {
                    userInput = scn.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scn.next(); 
                    continue; 
                }
                
                switch(userInput){
                    case 1:
                       game.drawFromDeck();
                       break;
                    case 2:
                        game.moveDiscardToFoundation();
                        break;
                    case 3:
                       game.startNewGame();
                       System.out.println("Welcome to Solitaire Lite!");
                       break;
                    case 4:
                        System.out.println("Game Quited.");
                        break;
                    default:
                        System.out.println("Invalid Output");
                        break;
                }
            }
            System.out.println("Thanks for playing!");
        }
    }
}
