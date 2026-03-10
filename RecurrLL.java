// add node at given index using recurrsion
public class RecurrLL {
    private Node head;
    private Node tail;

    private int size;
    public RecurrLL(){
        this.size=0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }
        public Node(int value, Node next){
            this.value=value;
            this.next=next;
        }
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;

    }
    public void insertRecc(int val,int index){
        head=InsertRec(val,index,head);
    }
    private Node InsertRec(int val,int index,Node node){
        if(index==0){
           Node temp=new Node(val,node);
           size++;
           return temp;
        }
        node.next=InsertRec(val,index-1,node.next);
        return node;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        RecurrLL l=new RecurrLL();
        l.insertFirst(12);
        l.insertFirst(13);
        l.insertFirst(14);
        l.insertFirst(15);
        l.insertFirst(16);
        l.insertRecc(22,3);
        l.display();
    }
}
