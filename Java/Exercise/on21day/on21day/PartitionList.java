package on21day;
public class PartitionList {
    public static void main(String[] args){
        
        Node head=new Node(0);
        Node temp=head;
        temp.next=new Node(10);
        temp=temp.next;
        temp.next=new Node(11);
        temp=temp.next;
        temp.next=new Node(1);
        temp=temp.next;
        temp.next=new Node(2);
        temp=temp.next;
        temp.next=new Node(3);
        temp=temp.next;
        temp.next=new Node(109);
        temp=temp.next;
        temp.next=new Node(3);
        temp=temp.next;
        temp.next=new Node(0);
        Node k=partitionList(head,3);
        Node cur=k;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
            
        
    }
    public static Node partitionList(Node head,int compare){
        if(head==null||head.next==null)return head;
        Node cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        Node[] help=new Node[count];
        cur=head;
        for(int i=0;i<help.length;i++){
            help[i]=cur;
            cur=cur.next;
        }
        partition(help,compare);
        head=help[0];
        cur=head;
        for(int i=1;i<help.length;i++){
            cur.next=help[i];
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }
    public static void partition(Node[] help,int compare){
        int p0=-1;
        int p1=help.length;
        int index=0;
        while(index<p1){
            if(help[index].val < compare){
                swap(help,++p0,index++);
            }else if((help[index].val > compare)){
                swap(help,--p1,index++);
            }else{
                index++;
            }
        }

    }
    public static void swap(Node[] help,int left,int right){
        Node temp=help[left];
        help[left]=help[right];
        help[right]=temp;
    }
}


