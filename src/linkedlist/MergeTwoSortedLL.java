package linkedlist;

/**
 * Created by code on 10/2/17.
 */
public class MergeTwoSortedLL {
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

    Node mergeSortedLL(Node head1,Node head2){
        Node newHead = new Node(Integer.MAX_VALUE);
        Node tail = newHead;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            }
            else {
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }
        if(head1!=null)
            tail.next = head1;
        if(head2!=null)
            tail.next = head2;

        return newHead.next;
    }

    void merge(){
        Node  obj = new Node(0);
        Node head1 = new Node(1);
        head1.next = new Node(4);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(9);
        head2.next.next.next = new Node(1);
        System.out.print("List 1 :");obj.printLL(head1);
        System.out.print("List 2 :");obj.printLL(head2);
        Node newHead = mergeSortedLL(head1,head2);
        System.out.print("List merged:");obj.printLL(newHead);

    }
    public static void main(String[] args) {
        new MergeTwoSortedLL().merge();
    }

}
