//CSC 345 Term Project - Milestone #2
//Wyatt Harris, Anna Graham, Kenneth Jamieson
//♠ ♥ ♦ ♣
// You may need to set your console to use UTF-8 encoding to display card suit symbols.
//If on a Windows machine, run chcp 65001 in Windows Command Prompt before executing the program.
public class TestProgram {
    public static void main(String[] args) {
        //creating card objects 
        /* 
        Card c1 = new Card('D', "A");
        Card c2 = new Card('D', "2");
        Card c3 = new Card('D', "3");
        Card c4 = new Card('D', "4");
        Card c5 = new Card('D', "5");

        LinkedStack stack = new LinkedStack();

        System.out.println("Empty? " + stack.isEmpty());

        pushing card objects into the stack
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        stack.push(c5);

        System.out.println("\u2660 \u2665 \u2666 \u2663");

        //testing stack methods
        System.out.println("Top of Stack: " + stack.peek());
        System.out.println("Size: " + stack.size());

        //toString that will be semi-important when implementing the 4 visible stacks
        System.out.println(stack);
        System.out.println("Card Removed: " + stack.pop());
        //stack after pop
        System.out.println(stack);
        */
        Deck deck = new Deck();
        System.out.println(deck);
    }
}
