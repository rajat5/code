package linkedlist;

/**
 * Created by code on 13/2/17.
 */
public class ReverseAndSplit {
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

        Node reverseLL(Node head) {
            Node newhead = null;
            while (head != null) {
                Node next = head.next;
                head.next = newhead;
                newhead = head;
                head = next;
            }
            return newhead;
        }

        Node reverseLL(Node head,Node stop) {
            Node newhead = null;
            while (head!=stop) {
                Node next = head.next;
                head.next = newhead;
                newhead = head;
                head = next;
            }
            if(stop!=null){
                stop.next = newhead;
                newhead = stop;
            }
            return newhead;
        }

        Node reverseinGroup(Node head, int k){
            if(k<=0)
                return head;
            Node obj = new Node(0);

            Node headList = new Node(0);
            Node tailList = headList;
            int count = 1;
            Node newHead = head;
            while (head!=null){
                if(count == k){
                    Node next = head.next;
                    tailList.next = obj.reverseLL(newHead,head);
                    tailList = newHead;
                    newHead = next;
                    head = next;
                    count = 1;
                    continue;
                }
                head = head.next;
                count++;
            }
            tailList.next = obj.reverseLL(newHead,head);

            return headList.next;
        }
        Node split(Node head) {
            Node newSplit = new Node(0);
            Node newTail = newSplit;
            while (head != null && head.next != null) {
                newTail.next = head.next;
                head.next = head.next.next;
                head = head.next;
                newTail = newTail.next;
            }
            newTail.next = null;
            return newSplit.next;
        }

        Node merge(Node head1, Node head2) {
            Node newHead = new Node(0);
            Node newTail = newHead;
            while (head1 != null && head2 != null){
                Node head1Next = head1.next;
                Node head2Next = head2.next;
                head2.next = null;
                head1.next = head2;
                newTail.next = head1;
                newTail = newTail.next.next;
                head1 = head1Next;
                head2 = head2Next;
            }
            if(head1!=null){
                newTail.next = head1;
            }
            if(head2!=null){
                newTail.next = head2;
            }
            return newHead.next;
        }
    }

    public Node createLL(int data[]) {
        Node head  = new Node(data[0]);
        Node tail = head;
        for(int i=1;i<data.length;i++){
            tail.next = new Node(data[i]);
            tail = tail.next;
        }
        return head;
    }

    void reverseOddNumberedNodes(){
        Node object = new Node(0);
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        object.printLL(head);
        Node head2 = object.split(head);
        object.printLL(head);
        object.printLL(head2);
        head2 = object.reverseLL(head2);
        object.merge(head,head2);
        object.printLL(head);
    }

    void reverseinGroup(){
        Node object = new Node(0);
        int arr[] = {1,2,3,4,5,-1,-2,-3,-4,-5};
        Node head = createLL(arr);
        System.out.println();
        object.printLL(head);
        head = object.reverseinGroup(head,4);
        object.printLL(head);
    }
    public static void main(String[] args) {
        new ReverseAndSplit().reverseOddNumberedNodes();
        new ReverseAndSplit().reverseinGroup();
    }
}
