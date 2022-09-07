package on21day;

public class ReverseList {
    public static void main(String[] args){
        Node head=new Node(0);
        Node cur=head;
        for(int i=1;i<10;i++){
            cur.next=new Node(i);
            cur=cur.next;
        }
        Node k=reverseList(head);
        for(int i=0;i<10;i++){
            System.out.print(k.val+" ");
            k=k.next;
        }
        
    }

    public static Node reverseList(Node head){
        if(head==null||head.next==null) return head;
        Node left=head;
        Node mid=left.next;
        Node right=mid.next;
        left.next=null;
        while(right!=null){
            mid.next=left;
            left=mid;
            mid=right;
            right=right.next;
        }
        mid.next=left;
        return mid;
    }
}
class Node{
    public int val;
    public Node next; 
    public Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    public Node(int val){
        this.val=val;
    }
}
