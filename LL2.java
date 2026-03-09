package Linked_List;
// problem is to insert at kth position with el value
public class LL2 {
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
   public void insertatkthel(int el,int k){
        if(head==null){
            if(k==1){
                Node node=new Node(el);
                size++;
                return;
            }
        }
        if(k==1){
           Node temp=head;
           Node node=new Node(el);
           node.next=temp;
           head=node;
           size++;
        }
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                Node node=new Node(el);
                node.next=temp.next;
                temp.next=node;
                break;
            }
            temp=temp.next;
        }
   }

    public static void main(String[] args) {
        LL2 l=new LL2();
        l.insertFirst(2);
        l.insertFirst(4);
        l.insertFirst(5);
        l.insertFirst(6);
        l.insertFirst(7);
        l.insertatkthel(99,4);
        l.display();
    }

}
