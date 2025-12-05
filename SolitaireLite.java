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
    private LinkedStack discardPile;
    private Deck deck;
    private Scanner sc = new Scanner(System.in);
    private String[] rankOrder = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    public SolitaireLite() {
        discardPile = new LinkedStack();
    }
    
    public static void main(String[] args) 
    {
        SolitaireLite game = new SolitaireLite();
        game.deck = new Deck();
        
        while(true)
        {
            System.out.println(game);
            int choice = game.sc.nextInt();

            switch (choice)
            {
                case 1:
                    // Drawing from deck
                    if (game.deck.size() == 0) {
                        // Flip discard pile back to deck
                        while (!game.discardPile.isEmpty()) {
                            game.deck.addCard((Card) game.discardPile.pop());
                        }
                        System.out.println("Deck refilled from discard pile!");
                    }
                    if (game.deck.size() > 0) {
                        Card drawnCard = game.deck.dealCard();
                        game.discardPile.push(drawnCard);
                    } else {
                        System.out.println("No cards left!");
                    }
                break;
                case 2:
                    // Moving discard to foundation pile
                    if (game.discardPile.isEmpty()) {
                        System.out.println("No card in discard pile!");
                        break;
                    }
                    
                    Card topDiscard = (Card) game.discardPile.peek();
                    boolean placed = false;
                    for (int i = 0; i < game.foundations.length; i++)
                    {
                        if (game.foundations[i] == null)
                        {
                            // Empty foundation - only accept Ace
                            if (topDiscard.getRank().equals("A")) {
                                game.foundations[i] = (Card) game.discardPile.pop();
                                placed = true;
                            }
                            break;
                        }
                        else if (game.foundations[i].getSuit().equals(topDiscard.getSuit()))
                        {
                            // Foundation exists with same suit - check if next in sequence
                            if (game.isNextRank(game.foundations[i].getRank(), topDiscard.getRank()))
                            {
                                game.foundations[i] = (Card) game.discardPile.pop();
                                placed = true;
                                break;
                            }
                        }
                    }
                    
                    if (!placed) {
                        System.out.println("Cannot place card - must start with Ace or follow rank order!");
                    }
                    
                    // Check for win condition
                    if (game.checkWin()) {
                        System.out.println(game);
                        System.out.println("Congratulations! You won! ");
                        return;
                    }
                break;  
                case 3:
                    // Starting a new game
                    game.deck = new Deck();
                    game.discardPile = new LinkedStack();
                    game.foundations = new Card[4];
                break;
                case 4:
                    System.out.println("Thanks for playing!");
                return;
                default:
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    
    // Helper method to check if newRank is next in sequence after currentRank
    private boolean isNextRank(String currentRank, String newRank)
    {
        for (int i = 0; i < rankOrder.length - 1; i++)
        {
            if (rankOrder[i].equals(currentRank) && rankOrder[i + 1].equals(newRank))
            {
                return true;
            }
        }
        return false;
    }
    
    // Check if player has won (all 4 foundations completed with King)
    private boolean checkWin()
    {
        for (int i = 0; i < foundations.length; i++)
        {
            if (foundations[i] == null || !foundations[i].getRank().equals("K"))
            {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString()
    {
        String discardTop = discardPile.isEmpty() ? "empty" : discardPile.peek().toString();
        return 
            "Foundations: " + Arrays.toString(foundations) + "\n" +
            "Deck: " + deck.size() + "   " +"Discard: " + discardTop + "\n" +
        
            "Choose an option: \n" +
            "1. Draw from Deck\n" +
            "2. Move Discard to Foundation Pile\n" +
            "3. Start a new game \n" +
            "4. Quit";
        
    }
}
