package Linked_List;

// problem is to insert element el before the  given value ;
public class LL3 {
    private Node head;
    private Node tail;
    private int size;
    public class Node{
        Node next;
        int  value;
        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;

    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }
    public void insertbefore(int el,int val){
        if(head==null){
           head=null;
           return;
        }
        if(head.value==val){
            Node temp=head;
            Node node=new Node(el);
            node.next=temp;
            head=node;
            size++;
        }
        int cnt=0;
        Node temp=head;
        while(temp.next!=null){
            if(temp.next.value==val){
                Node node=new Node(el);
                node.next=temp.next;
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        LL3 l=new LL3();
        l.insertFirst(2);
        l.insertFirst(4);
        l.insertFirst(5);
        l.insertFirst(6);
        l.insertFirst(7);
        l.insertbefore(100,2);
        l.display();
    }

}

