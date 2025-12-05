//CSC 345 Term Project - Solitaire Lite 
//Wyatt Harris, Anna Graham, Kenneth Jamieson
public class Node {
    private Object element;
    private Node next;

    public Node(Object element){
        this.element = element;
    }

    public Node(Object element, Node next){
        this.element = element;
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node n){
        next = n;
    }
    public Object getValue(){
        return element;
    }

}
