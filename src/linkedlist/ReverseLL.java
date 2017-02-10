package linkedlist;

/**
 * Created by code on 8/2/17.
 * reverse a linked list
 */
public class ReverseLL {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        void printLL(Node head){
            while(head != null){
                System.out.print(head.data+"->");
                head = head.next;
            }
            System.out.print("NULL");
        }
        Node reverseLL(Node head){
            Node newhead = null;
            while(head != null){
                Node next = head.next;
                head.next = newhead;
                newhead = head;
                head = next;
            }
            return newhead;
        }
    }
    public void reverseLL(){
        Node object = new Node(0);
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        object.printLL(head);
        head = object.reverseLL(head);
        object.printLL(head);
    }
    public static void main(String [] args){
        new ReverseLL().reverseLL();
    }

}
