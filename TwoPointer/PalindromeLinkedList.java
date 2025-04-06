public class PalindromeLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node midNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head){
        if(head==null || head.next==null) return true;
        Node p1 = head;
        Node p2 = midNode(head);
        p2 = reverse(p2);
        while(p2!=null){
            if(p1.data!=p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}


