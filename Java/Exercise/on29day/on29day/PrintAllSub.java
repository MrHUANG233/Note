package on29day;

import java.util.ArrayList;

//全排列
public class PrintAllSub {
    public static void main(String[] args){
        System.out.println(printAllSub("abc"));
    }
    public static ArrayList<String> printAllSub(String str){
        ArrayList<String> res=new ArrayList<>();
        char[] chs=str.toCharArray();
        process(chs,0,res);
        return res;
    }
    public static void process(char[] str,int i,ArrayList<String> res){
        if(i==str.length){
            res.add(String.valueOf(str));
        }
        boolean[] visit=new boolean[26];
        for(int j=i;j<str.length;j++){
            if(!visit[str[j]-'a']){
                visit[str[j]-'a']=true;           
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
        }
    }
    public static void swap(char[] chs,int i,int j){
        char temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
}
