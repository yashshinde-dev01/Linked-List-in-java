// create circular linked list
// insert value in circular linked list
public class CLL {
    private Node head;
    private Node tail;
    private int size;
    public CLL(){
        this.head=null;
        this.tail=null;
    }
    public class Node{
        private int value;
        private Node next;
        public Node(int value){
           this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }
    public void Insert(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;
    }
    public void display(){
        Node node=head;
        if(head!=null){
           do{
               System.out.print(node.value+"-->");
               node=node.next;
           }while(node!=head);
        }
        System.out.println();
    }
    public void delete(int value){
        Node node=head;
        if(node==null){
            return;
        }
        if(node.value==value){
            head=head.next;
            tail.next=head;
        }
        do{
            Node n=node.next;
            if(n.value==value){
              node.next=n.next;
              break;
            }
            node=node.next;
        }while(node!=head);
    }

    public static void main(String[] args) {
        CLL lst=new CLL();
        lst.Insert(34);
        lst.Insert(56);
        lst.Insert(23);
        lst.Insert(99);
        lst.display();
        lst.delete(56);
        lst.display();
    }
}
