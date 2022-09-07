package on25day;
public class MyMapTest {
    public static void main(String[] args){
        Map<Integer,String> map=new MyMap<>();
        map.put(1,"aaa");
        map.put(2,"ccc");
        map.put(1,"zzz");
        map.put(3,"aaa");
        map.put(4,"ddddd");
        map.put(5,"0000");
        map.put(3,"jjj");
        System.out.println(map.get(1));//"zzz"
        System.out.println(map.get(2));//"ccc"
        System.out.println(map.get(3));//"jjj"
        System.out.println(map.get(4));//"ddddd"
        System.out.println(map.get(5));//"0000"
        System.out.println(map.get(6));//"null"
        
    }
}

interface Map<K,V>{
    V get(K Key);
    void put(K Key,V value);

    interface Entry<K,V>{

    }
}

class MyMap<K,V> implements Map<K,V>{
    
    @SuppressWarnings("unchecked")
    MyEntry<K,V>[] map=new MyEntry[16];
    public V get(K Key){
        int index=Key.hashCode()%16;
        MyEntry<K,V> cur=map[index];
        while(cur!=null&&cur.hashCode!=Key.hashCode()){
            cur=cur.next;
        }
        if(cur==null) return null;
        return cur.value;        
    }
    public void put(K Key,V value){
        int index=Key.hashCode();
        MyEntry<K,V> cur=map[index];
        while(cur!=null&&cur.hashCode!=Key.hashCode()){
            cur=cur.next;
        }
        if(cur!=null){
            cur.value=value;
        }else{
            cur=new MyEntry<>();
            cur.Key=Key;
            cur.value=value;
            cur.hashCode=Key.hashCode();

            cur.next=map[index];
            map[index]=cur;
        }

    }

    class MyEntry<K,V> implements Map.Entry<K,V>{
        public K Key;
        public V value;
        public MyEntry<K,V> next;
        public int hashCode;
    }
}
