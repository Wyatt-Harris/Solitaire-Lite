// CSC 345 Term Project - Milestone #1
// Wyatt Harris, Anna Graham, Kenneth Jamieson

// Node class for LinkedStack implementation
public class Node 
{
    // Instance variables
    private Object element;
    private Node next;

    // Constructors
    public Node(Object element)
    {
        this.element = element;
    }

    // Overloaded constructor
    public Node(Object element, Node next)
    {
        this.element = element;
        this.next = next;
    }

    // Getters and setters
    public Node getNext()
    {
        return next;
    }

    public void setNext(Node n)
    {
        next = n;
    }

    public Object getValue()
    {
        return element;
    }

}
