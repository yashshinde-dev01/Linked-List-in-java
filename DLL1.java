package Doubly_LL;

public class DLL1 {
    private Node head;
    private int size;

    public class Node {
        private Node next;
        private int val;
        private Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node ConvertDLL(int[] arr) {
        head= new Node(arr[0]);
        Node tail=head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
        }
        return head;
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }

        public static void main(String[] args) {
            int[]arr={12,5,6,8};
//            Node head=ConvertDLL(arr);
//            print(head);
            DLL2 l=new DLL2();
            l.ConvertDLL(arr);
            l.print();
        }
    }
