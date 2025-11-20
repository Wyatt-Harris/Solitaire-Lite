//CSC 345 Term Project - Milestone #1
//Wyatt Harris
public class LinkedStack implements StackADT{
    protected int size;
    protected Node top;
    public LinkedStack(){
        size = 0;
        top = null;
    }
    public Object pop(){
        if (size == 0)
            throw new RuntimeException("Can't pop from an empty stack!");
        Object result = top.getValue();
        top = top.getNext();
        size--;
        return result;
    }
    public void push(Object o){
        Node n = new Node(o, top);
        top = n;
        size++;
    }
    public Object peek(){
        if(top == null){
            throw new RuntimeException("Can't peek at an empty stack!");
        }else{ 
            return top.getValue();
        }
    }
    public Boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    @Override
    public String toString(){
        int i = 0;
        Node current = top;
        String result = "top [ ";
        while(current != null){
            if(current.getNext() != null){
                result += current.getValue() + " | ";
            }else{
                result += current.getValue() + " ";
            }
            current = current.getNext();
        }
        return result + "]";

    }
}
