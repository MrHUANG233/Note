import java.util.*;

public class PreOrderUnRecur {
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
        preOerderRecur(n1);
        int max=bpf(n1);
        System.out.println("最大宽度是："+max);
    }
    public static void preOerderRecur(TreeNode head){
        if(head==null) return;
        //System.out.println("前序"+head.val);
        preOerderRecur(head.left);
        //System.out.println("中序"+head.val);
        preOerderRecur(head.right);
        System.out.println("后序"+head.val);
    }

    public static int bpf(TreeNode head){
        if(head==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(head);
        int curLevel=1;
        int curLevelNodes=0;
        int max=Integer.MIN_VALUE;
        HashMap<TreeNode,Integer> map=new HashMap<>();
        map.put(head,1);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null&&(int)(map.get(cur))==curLevel){
                curLevelNodes++;
            }else{
                max=Math.max(curLevelNodes,max);
                curLevel++;
                curLevelNodes=1;
            }
            System.out.println("宽度优先遍历："+cur.val);
            if(cur.left!=null){                
                queue.add(cur.left);
                map.put(cur.left,curLevel+1);
            }
            if(cur.right!=null){
                queue.add(cur.right);
                map.put(cur.right,curLevel+1);
            }
        }
        max=Math.max(curLevelNodes,max);
        return max;
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
