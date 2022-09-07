package on27day;
/***
 * 前缀树
 */
public class Test{
    public static void main(String[] args){
        int b=97;
        System.out.println((char)b);
    }
}
class TrieNode{
    public int pass;//经过这条路的次数
    public int end;//以这个点结尾的字符串数量
    public TrieNode[] nexts;//HashMap<Charater,Node> nexts;//TreeMap<Charater,Node> nexts

    public TrieNode(){
        pass=0;
        end=0;
        nexts=new TrieNode[26];
    }
}

class Trie{
    private TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    //插入字符串
    public void insert(String word){
        if(word==null) return;
        char[] chs=word.toCharArray();
        TrieNode node=root;

        node.pass++;
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(node.nexts[index]==null){
                node.nexts[index]=new TrieNode();
            }
            node=node.nexts[index];
            node.pass++;

        }
        node.end++;

    }

    public void delete(String word){
        if(search(word)!=0){//先判断是否加入过这个字符串
            char[] chs=word.toCharArray();
            TrieNode node=root;
            node.pass--;
            int index=0;
            for(int i=0;i<chs.length;i++){
                index=chs[i]-'a';
                node.pass--;
                node=node.nexts[index];
            }
            node.end--;
        }
    }
    //word这个单词之前加入过几次
    public int search(String word){
        if(word==null) return 0;
        char[] chs=word.toCharArray();
        TrieNode node =root;
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(node.nexts[index]==null){
                return 0;
            }
            node=node.nexts[index];
        }
        return node.end;
    }
    //加入的字符串中，有几个以pre为前缀
    public int prefixNumber(String pre){
        if(pre==null)return 0;
        char[] chs=pre.toCharArray();
        TrieNode node=root;
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(node.nexts[index]==null)return 0;
            node=node.nexts[index];
        }
        return node.pass;
    }
}