package linkedlist;

/**
 * Created by code on 10/2/17.
 */
public class ListIsPalindrome {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        void printLL(Node head) {
            while (head != null) {
                System.out.print(head.data + "->");
                head = head.next;
            }
            System.out.print("NULL");
        }
    }
    private Node reverse(Node head){
        Node newHead = null;
        while(head!=null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return  newHead;
    }
    boolean palindrome(Node head){
        if(head==null)
            return false;
        //find mid
        Node mid = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            mid = mid.next;
            fast = fast.next.next;
        }
        //reverse list
        Node headMid = reverse(mid);
        Node revertPointer = headMid;
        //check palindrome
        boolean palindrome = true;
        while (headMid!=null){
            if(head.data != headMid.data) {
                palindrome = false;
                break;
            }
            head = head.next;
            headMid = headMid.next;
        }
        //reverse back
        reverse(revertPointer);
        return palindrome;
    }
    void palindrome(){
        Node obj = new Node(0);
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        obj.printLL(head);
        System.out.println(palindrome(head));
        obj.printLL(head);
    }
    public static void main(String[] args) {
        new ListIsPalindrome().palindrome();
    }
}
