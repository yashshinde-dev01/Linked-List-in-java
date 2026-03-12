public class SortLL {
    private ListNode head;
    private ListNode tail;

    private int size;
    public SortLL(){
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
//    public void Bubblesort(){
//        bubbleSort()
//    }
    public ListNode sortList(ListNode head){
        if(head==null || head.next==null){
           return head;
        }
        ListNode mid=findMiddle(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);

        return mergeTwoLists(left,right);
    }
    public  ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev=null;

        while (fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;       // move 1 step
            fast = fast.next.next;  // move 2 steps
        }
        prev.next=null;
        return slow;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(list1 != null && list2 != null) {

            if(list1.value <= list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // attach remaining nodes
        if(list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
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
        SortLL l=new SortLL();
        l.insertFirst(12);
        l.insertFirst(1);
        l.insertFirst(110);
        l.insertFirst(44);
//        System.out.println(l.sortList(head));
        l.display();
    }
}
