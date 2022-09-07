public class SearchTree {
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
        boolean res=searchTree(n1);
        System.out.println(res);
    }
    public static boolean searchTree(TreeNode head){
        if(head==null) return true;
        boolean res=process(head).isBST;
        return res;
    }
    public static ReturnData process(TreeNode head){
        if(head==null) return null;
        ReturnData leftData=process(head.left);
        ReturnData rightData=process(head.right);

        int min=head.val;
        int max=head.val;
        if(leftData!=null){
            min=Math.min(min,leftData.min);
            max=Math.max(max,leftData.max);
        }
        if(rightData!=null){
            min=Math.min(min,rightData.min);
            max=Math.max(max,rightData.max);
        }

        boolean isBST=true;
        if(leftData!=null&&(!leftData.isBST||leftData.max>=head.val)){
            isBST=false;
        }
        if(rightData!=null&&(!rightData.isBST||rightData.min<=head.val)){
            isBST=false;
        }
        return new ReturnData(isBST,min,max);
    } 
    

}
class ReturnData{
    public boolean isBST;
    public int min;
    public int max;
    public ReturnData(boolean isBS,int mi,int ma){
        min=mi;
        isBST=isBS;
        max=ma;
    }
}
