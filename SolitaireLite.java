// CSC 345 Term Project - Milestone #1
// Wyatt Harris, Anna Graham, Kenneth Jamieson
//♠ ♥ ♦ ♣
// You may need to set your console to use UTF-8 encoding to display card suit symbols.
// If on a Windows machine, run chcp 65001 in Windows Command Prompt before executing the program.
import java.util.Scanner;
import java.util.Arrays;

public class SolitaireLite 
{
    private Card[] foundations = new Card[4];
    private Card discard;
    private Deck deck;
    
    public static void main(String[] args) 
    {
        SolitaireLite game = new SolitaireLite();
        game.deck = new Deck();
        LinkedStack stack = new LinkedStack();
        Scanner sc = new Scanner(System.in);


        System.out.println("Choose an option: \n" +
            "1. Draw from Deck\n" +
            "2. Move Discard to Foundation Pile\n" +
            "3. Start a new game \n" +
            "4. Quit"
        );

        int choice = sc.nextInt();
        
        switch (choice)
        {
            case 1:
                // Drawing from dexk
            break;
            case 2:
                // Moving discard to foundation pile
            break;  
            case 3:
                // Starting a new game
            break;
            case 4:
                System.out.println("Thanks for playing!");
            break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
        

        // Pushing card objects into the stack
        stack.push(game.deck.dealCard());
        stack.push(game.deck.dealCard());
        
        // Move a card to discard
        game.discard = (Card) stack.pop();
        
        System.out.println(game);



    }
    
    @Override
    public String toString()
    {
        return "Foundations: " + Arrays.toString(foundations) + "\n" +
               "Deck: " + deck + "  " + "Discard: " + discard;
    }
}
