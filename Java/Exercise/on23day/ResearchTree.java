import java.util.*;
public class ResearchTree {
    public static int preValue=Integer.MIN_VALUE;
    public static void main(String[] args){
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(8);
        n1.left=n3;
        n1.right=n4;
        n3.right=n2;
        n4.left=n5;
        n4.right=n6;
        n2.left=n7;
        n6.right=n8;
        boolean res=isReaserchTree(n1);
        boolean res2=isCBT(n1);
        System.out.println(res);
        System.out.println(res2);
    }
    public static boolean isCBT(TreeNode head){
        if(head==null)return true;
        Queue<TreeNode> queue=new LinkedList<>();
        boolean leaf=false;
        TreeNode l=null;
        TreeNode r=null;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if((leaf&&(l!=null||r!=null))||(l==null&&r!=null))return false;
            if(l!=null){
                queue.add(l);
            }
            if(r!=null){
                queue.add(r);
            }
            if(l==null||r==null){
                leaf=true;
            }

        }
        return true;


    }
    public static boolean isReaserchTree(TreeNode head){
        if(head==null) return true;
        boolean isLeftBst=isReaserchTree(head.left);
        if(!isLeftBst){
            return false;
        }
        if(head.val<=preValue){
            return false;
        }else{
            preValue=head.val;
        }
        return isReaserchTree(head.right);

    }
}
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
}
