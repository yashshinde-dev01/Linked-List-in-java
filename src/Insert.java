// insert at first node in linked likedlist
// insert at last of the LL
// insert an value at given index of LL
// delete an value from the first of LL
// delete an value from the last of LL
// delete an value from given idx of LL
// find the node that has given value in LL;
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
    public void insertLast(int value){
        Node node=new Node(value);
        if(tail==null){
            insertFirst(value);
            return;
        }
        tail.next=node;
        tail=node;
        size++;

    }
    public void insertAtidx(int value,int idx){
        if(idx==0){
            insertFirst(value);
            return;
        }
        if(idx==size){
            insertLast(value);
            return;
        }
        Node temp=head;
        for(int i=1;i<idx;i++){
            temp=temp.next;
        }
        Node node=new Node(value);
        node.next=temp.next;
        temp.next=node;
        size++;

    }
    public int deleteFirst(){
        int value=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;

    }
    public Node get(int idx){
        Node node=head;
        for(int i=0;i<idx;i++){
          node=node.next;
        }
        return node;
    }
    public int  deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast= get(size-2);
        int value=tail.value;
        tail=secondLast;
        tail.next=null;
        return value;

    }
    public int deleteIdx(int idx){
        if(idx==0){
            return deleteFirst();
        }
        if(idx==size-1){
            return deleteLast();
        }
        Node prev=get(idx-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        size--;
        return val;
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
        Insert lst=new Insert();
        lst.insertFirst(3);
        lst.insertFirst(2);
        lst.insertFirst(8);
        lst.insertFirst(17);
        lst.display();
        lst.insertLast(14);
        lst.display();
        lst.insertAtidx(144,3);
        lst.display();
        System.out.println(lst.deleteFirst());
        lst.display();
        System.out.println(lst.deleteLast());
        lst.display();
        System.out.println(lst.deleteIdx(2));
        lst.display();
        Node result=lst.FindNode(3);
        System.out.println(result.value);
        lst.display();
    }

}
