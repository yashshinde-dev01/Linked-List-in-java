// doubly linked list
// insert at begining in DLL;
// insert at last in DLL;
//Insert after value in DLL;
public class DLL {

    private Node head;
    private Node tail;

    private int size;

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value=value;
        }
        public Node(int value,Node next,Node prev){
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }
    public void InsertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null){
            head.prev=node;
        }
        head=node;
//        size++;
    }
    public void display(){
        Node temp=head;
        Node last=null;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            last=temp;
            temp=temp.next;
        }
        System.out.println("End");
        System.out.println("Printing reverse");
        while(last!=null){
            System.out.print(last.value+"-->");
            last=last.prev;
        }
        System.out.println("Start");
    }
    public void InsertLast(int value){
        Node node=new Node(value);
        Node last=head;
        node.next=null;
        if(head==null){
            head.prev=null;
            head=node;
//            return;
        }
        while(last.next!=null){
            last=last.next;
        }
        last.next=node;
        node.prev=last;
    }
    public void insertAfterVal(int after,int value){
        Node p=FindNode(after);

        if(p==null){
            System.out.println("does not exists");
        }
        Node node=new Node(value);
        node.next=p.next;
        p.next=node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev=node;
        }
    }
    public Node FindNode(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        DLL lst=new DLL();
        lst.InsertFirst(2);
        lst.InsertFirst(3);
        lst.InsertFirst(4);
        lst.InsertFirst(5);
        lst.display();
        lst.InsertLast(99);
        lst.display();
        lst.insertAfterVal(4,55);
        lst.display();
    }
}
