// CSC 345 Term Project - Milestone #1
// Wyatt Harris, Anna Graham, Kenneth Jamieson


public class LinkedStack implements StackADT
{

    // Instance variables
    private int size;
    private Node top;
    

    // Constructor
    public LinkedStack()
    {
        size = 0;
        top = null;
    }

    // Pop method
    public Object pop()
    {
        if (size == 0)
            throw new RuntimeException("Can't pop from an empty stack!");
        Object result = top.getValue();
        top = top.getNext();
        size--;
        return result;
    }

    // Push method
    public void push(Object o)
    {
        Node n = new Node(o, top);
        top = n;
        size++;
    }

    // Peek method
    public Object peek()
    {
        if(top == null)
        {
            throw new RuntimeException("Can't peek at an empty stack!");
        }else
        { 
            return top.getValue();
        }
    }

    // isEmpty method
    public Boolean isEmpty()
    {
        return size == 0;
    }

    // size method
    public int size()
    {
        return size;
    }

    // toString method
    @Override
    public String toString()
    {
        int i = 0;
        Node current = top;
        String result = "";
        while(current != null){
            if(current.getNext() != null)
            {
                result += current.getValue() + " ";
            }else
            {
                result += current.getValue() + " ";
            }
            current = current.getNext();
        }
        return result + "";

    }

    
}
