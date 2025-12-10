import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
        
    }
}
public class ReverseLL {
    public static Node reverseLinkedList(Node head) {
        Node temp = head; // temp pointer to traverse the LL
        Stack<Integer> s = new Stack<>();
        while (temp != null){
            s.push(temp.data);
            temp = temp.next;
        }
        temp=head;
        // Step 2: Pop values from the stack
        // and update the linked list
        while (temp != null){
            temp.data = s.pop();
            temp=temp.next;
        }
        return head;
    }
    public static void printLL(Node head){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "");
            temp=temp.next;
        }
        System.out.println();
    }
    // recursive 
    public static Node reverseLinkedList2(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
    
}
