public class Xiangjiao {
    public static void main(String[] args){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);

        Node n8=new Node(5);
        Node n9=new Node(6);
        Node n10=new Node(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;

        n8.next=n9;
        n9.next=n10;
        n10.next=n6;
        Node res=xiangjiao(n1, n8);
        System.out.println(res.val);
        
    }
    public static Node xiangjiao(Node head1,Node head2){
        if(head1==null||head2==null)return null;
        Node cur1=head1;
        int count1=0;
        Node cur2=head2;
        int count2=0;
        while(cur1.next!=null){
            count1++;
            cur1=cur1.next;
        }
        while(cur2.next!=null){
            count2++;
            cur2=cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }else{
            if(count1>count2){
                int fast=count1-count2;
                cur1=run(head1, fast);
                return compare(cur1, head2);
            }else if(count2>count1){
                int fast=count2-count1;
                cur2=run(head2, fast);
                return compare(head1, cur2);
            }else{
                return compare(head1, head2);
            }
        }
    }
    public static Node run(Node head,int step){
        Node cur=head;
        for(int i=0;i<step;i++){
            cur=cur.next;
        }
        return cur;
    }
    public static Node compare(Node head1,Node head2){
        Node cur1=head1;
        Node cur2=head2;
        while(cur1!=null&&cur2!=null){
            if(cur1==cur2){
                return cur1;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return null;
    }





}
