package Doubly_LL;
// delete the first node of doubly linked list
public class DLL2 {
    private Node head;
    private Node tail;
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
        tail=head;
        size=1;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
            size++;
        }
        return head;
    }
    public void deleteHead(){
        if(head.next==null){
            System.out.println("NULL");
            return;
        }
        Node temp=head;
        head=head.next;
        head.prev=null;
        temp.next=null;
        size--;
    }
//    public void deleteLast(){// o(n) time
//        if(head==null|| head.next==null){
//            System.out.println("NULL");
//            return;
//        }
//        Node temp=head;
//        while(temp.next!=null){
//            temp=temp.next;
//        }
//        temp.prev.next=null;
//        temp.prev=null;
//    }
    public void deleteLast2(){// with o(1) time complexity
        if(tail.prev==null){
            head=null;
            tail=null;
            size--;
            return;
        }
       tail=tail.prev;
        tail.next=null;
        size--;
    }
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void deletekthNode(int k){
        if(head==null){
            System.out.println("NULL");
            return;
        }
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                break;
            }
            temp=temp.next;
        }
        Node back=temp.prev;
        Node front=temp.next;
        if(back==null && front==null){
            System.out.println("null");
            return;
        }
        else if(back==null){
            deleteHead();
            size--;
            return;
        }
        else if(front==null){
            deleteLast2();
            size--;
            return;
        }else{
            front.prev=back;
            back.next=front;
            temp.next=null;
            temp.prev=null;
            size--;
        }
    }
    public void deleteNode(int value){
        if(head==null){
            System.out.println("NULL");
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.val==value){
                break;
            }
            temp=temp.next;
        }
        Node front=temp.next;
        Node back=temp.prev;
        if(front==null && back==null){
            System.out.println("NULL");
            return;
        }
        else if(front==null){
            deleteLast2();
            return;
        }
        else if(back==null){
            deleteHead();
            return;
        }
        else{
            front.prev=back;
            back.next=front;
            temp.prev=null;
            temp.next=null;
            size--;
        }
    }
    public void InsertBeforeHead(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        Node temp=head;
        temp.prev=node;
        node.next=temp;
        head=node;
        size++;
    }
//    public void InsertBeforeTail(int value){
//        if(head==null){
//            InsertBeforeHead(value);
//            return;
//        }
//        Node node=new Node(value);
//        Node temp=head;
//        while(temp.next!=null){
//            temp=temp.next;
//        }
//        Node back=temp.prev;
//        back.next=node;
//        node.next=temp;
//        temp.prev=node;
//        node.prev=back;
//        size++;
//    }
    public void InsertBeforeTail2(int value){
        if(head == null || head == tail){
            InsertBeforeHead(value);
            return;
        }
        Node node=new Node(value);
        Node back=tail.prev;
        back.next=node;
        node.next=tail;
        tail.prev=node;
        node.prev=back;
    }
    public void InsertbeforeKth(int value,int k){
        if(head==null && tail==null){
            InsertBeforeHead(value);
            return;
        }
        Node node=new Node(value);
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==k){
              break;
            }
            temp=temp.next;
        }
        Node before=temp.prev;
        before.next=node;
        node.next=temp;
        temp.prev=node;
        node.prev=before;
    }
    public void InsertbeforeNode(int value,int digit){
        if(head==null && tail==null){
            InsertBeforeHead(digit);
            return;
        }
        Node node=new Node(digit);
        Node temp=head;
        while(temp!=null){
            if(temp.val==value){
                break;
            }
            temp=temp.next;
        }
        Node before=temp.prev;
        before.next=node;
        node.next=temp;
        temp.prev=node;
        node.prev=before;
    }

    public static void main(String[] args) {
        int[]arr={2,3,4,1,5,6,7};
        DLL2 l=new DLL2();
        l.ConvertDLL(arr);
        l.deleteHead();
        l.deleteLast2();
        l.deletekthNode(4);
        l.deleteNode(1);
        l.InsertBeforeHead(99);
        l.InsertBeforeTail2(101);
        l.InsertbeforeKth(44,5);
        l.InsertbeforeNode(101,91);
        l.print();

    }
}

