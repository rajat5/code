package linkedlist;

/**
 * Created by code on 9/2/17.
 */
public class DetectCycleInLL {
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

    /*
        Loop node
        d = x +y + z + y;2(x+y) = x + 2y +z;x = z
     */
    Node detectLoopFloyd(Node head){
        Node hare = head;
        Node tortoise = head;
        boolean loopFound = false;
        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise){
                loopFound = true;
                break;
            }
        }

        if(!loopFound)
            return null;
        Node pointerToHead = head;
        while(true){
            pointerToHead = pointerToHead.next;
            tortoise = tortoise.next;
            if(pointerToHead == tortoise){
                return pointerToHead;
            }
        }
    }

    void detectLoop(){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next.next;
        Node loopNode = detectLoopFloyd(head);
        System.out.println("Loop found "+((loopNode==null)?"null":loopNode.data) );
    }
    public static void main(String[] args) {
        //TODO : floyd, brent and reversal
        new DetectCycleInLL().detectLoop();
    }
}
