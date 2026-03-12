// reverse the linked list using recurrsion
public class RevLL {
    private ListNode head;
    private ListNode tail;

    private int size;
    public RevLL(){
        this.size=0;
    }
    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value){
            this.value=value;
        }
        public ListNode(int value, ListNode next){
            this.value=value;
            this.next=next;

        }
    }
    // reveresing linked list using recurrsion
    public void reverse(ListNode node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    public void reverese(){
        if(size<2){
            return;
        }
        ListNode prev=null;
        ListNode present=head;
        ListNode nxt=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=nxt;
            if(nxt!=null){
                nxt=nxt.next;
            }
        }
        head=prev;
    }
    public void insertFirst(int val){
        ListNode node=new ListNode(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;

    }
    public void display(){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        RevLL L=new RevLL();
        L.insertFirst(12);
        L.insertFirst(11);
        L.insertFirst(10);
        L.insertFirst(9);
        L.reverse(L.head);
        L.display();

    }
}
