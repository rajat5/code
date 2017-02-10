package linkedlist;

/**
 * Created by code on 9/2/17.
 */
public class DetectCycleInLL {
    class Node {
        int data;
        ReverseLL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        void printLL(ReverseLL.Node head) {
            while (head != null) {
                System.out.print(head.data + "->");
                head = head.next;
            }
            System.out.print("NULL");
        }
    }

    public static void main(String[] args) {
        //detect loop
        // floyd, brent and reversal
        //merge sorted ll
    }
}
