// insert at first node in linked likedlist
public class Insert {
    private Node head;
    private Node tail;

    private int size;
    public Insert(){
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
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        Insert lst=new Insert();
        lst.insertFirst(3);
        lst.insertFirst(2);
        lst.insertFirst(8);
        lst.insertFirst(17);
        lst.display();
    }

}
