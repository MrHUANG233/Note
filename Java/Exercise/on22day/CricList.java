public class CricList {
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n4;
    
        Node res=cricList(n1);
        System.out.println(res.val);
    }
    public static Node cricList(Node head){
        if(head==null||head.next==null) return null;
        Node slow=head;
        Node fast=head;
        while(true){
            if(fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
            if(fast==null) return null;
            if(slow==fast){
                fast=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return fast;
            }
        }
    }

}

class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val=val;
    }
}
