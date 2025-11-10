//CSC 345 Term Project - Milestone #1
//Wyatt Harris
//♠ ♥ ♦ ♣
public class TestProgram {
    public static void main(String[] args) {
        //creating card objects 
        Card c1 = new Card("Diamonds", "Ace");
        Card c2 = new Card("Diamonds", "Two");
        Card c3 = new Card("Diamonds", "Three");
        Card c4 = new Card("Diamonds", "Four");
        Card c5 = new Card("Hearts", "Queen");

        LinkedStack stack = new LinkedStack();

        System.out.println("Empty? " + stack.isEmpty());

        //pushing card objects into the stack
        stack.push(c1);
        stack.push(c2);
        stack.push(c3);
        stack.push(c4);
        stack.push(c5);

        //testing stack methods
        System.out.println("Top of Stack: " + stack.peek());
        System.out.println("Size: " + stack.size());

        //toString that will be semi-important when implementing the 4 visible stacks
        System.out.println(stack);
        System.out.println("Card Removed: " + stack.pop());
        //stack after pop
        System.out.println(stack);
    }
}
