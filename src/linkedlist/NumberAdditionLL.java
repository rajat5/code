package linkedlist;

/**
 * Created by code on 13/2/17.
 */
public class NumberAdditionLL {
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
            System.out.print("NULL\n");
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
    Node add(Node head1,Node head2){
        Node obj = new Node(0);
        Node ans = null;
        Node head1R = obj.reverseLL(head1);
        Node head2R = obj.reverseLL(head2);
        head1 = head1R;
        head2 = head2R;
        int carry = 0;
        while(head1R!= null && head2R != null){
            int data = head1R.data + head2R.data + carry;
            Node next =  new Node(data%10);
            next.next = ans;
            ans = next;
            carry = data>9?1:0;
            head1R = head1R.next;head2R = head2R.next;
        }
        while (head1R!=null){
            int data = head1R.data + carry;
            Node next =  new Node(data%10);
            next.next = ans;
            ans = next;
            carry = data>9?1:0;
            head1R = head1R.next;
        }
        while (head2R!=null){
            int data = head2R.data + carry;
            Node next =  new Node(data%10);
            next.next = ans;
            ans = next;
            carry = data>9?1:0;
            head2R = head2R.next;
        }
        if(carry>0){
            Node next =  new Node(carry%10);
            next.next = ans;
            ans = next;
        }
        obj.reverseLL(head1);
        obj.reverseLL(head2);
        return ans;
    }
    void add(){
        Node obj = new Node(0);
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);
        Node head2 = new Node(1);
        head2.next = new Node(3);
        obj.printLL(head1);
        obj.printLL(head2);
        obj.printLL(add(head1,head2));
        obj.printLL(head1);
        obj.printLL(head2);
    }
    public static void main(String[] args) {
        new NumberAdditionLL().add();
    }
}
