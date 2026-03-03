package Linked_List;
// problem is to remove k th element from the single linked list
public class LL1 {
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
    public void Deltekthele(int k){
        if(head==null){
            head=null;
        }
        if(k==1){
            Node temp=head;
            head=head.next;
            return;
        }
        int cnt=0;
        Node prev=null;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        LL1 l=new LL1();
        l.insertFirst(2);
        l.insertFirst(4);
        l.insertFirst(5);
        l.insertFirst(6);
        l.insertFirst(7);
        l.Deltekthele(4);
        l.display();
    }

}
