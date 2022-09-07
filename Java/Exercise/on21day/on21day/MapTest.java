package on21day;
public class MapTest {
    public static void main(String[] args){
        Map<Integer,String> map=new MyMap<>();
        map.put(1,"sfghd");
        map.put(3,"asghhd");
        map.put(13,"dfgasfhd");
        map.put(2,"dfashd");
        map.put(2,"dfashdddsd");
        map.put(8,"fdassdhd");
        map.put(3,"d");
        map.put(6,"ashd");
        map.put(4,"d");
        System.out.println("1: "+map.get(1));
        System.out.println("3: "+map.get(3));
        System.out.println("13: "+map.get(13));
        System.out.println("8: "+map.get(8));
        System.out.println("4: "+map.get(4));
        System.out.println("6: "+map.get(6));
        System.out.println("13: "+map.get(13));
        System.out.println("2: "+map.get(2));

    }
}
interface Map<k,v>{
    v get(k key);
    void put(k key,v value);
    interface Entry<k,v>{
        Entry<k,v> getEntry();
    }
}
//哈希表实现
class MyMap<k,v> implements Map<k,v>{
    @SuppressWarnings("unchecked")
    MyEntry<k,v>[] map=new MyEntry[16];
    @Override
    public v get(k key){
        if(key==null)return null;
        int index=getIndex(key);
        MyEntry<k,v> cur=map[index];
        while(cur!=null){
            if(cur.hashcode==key.hashCode()){
                return cur.value;
            }
            cur=cur.next;
        }
        return null;
    }
    @Override
    public void put(k key,v value){
        int index=getIndex(key);
        MyEntry<k,v> cur=map[index];
        while(cur!=null){
            if(cur.hashcode==key.hashCode()){
                cur.value=value;
                return ;
            }
        }
        MyEntry<k,v> temp=new MyEntry<k,v>();
        temp.key=key;
        temp.value=value;
        temp.hashcode=key.hashCode();
        temp.next=map[index];
        map[index]=temp;
    }

    public int getIndex(k key){
        return key.hashCode()%16;
    }
    class MyEntry<k,v> implements Map.Entry<k,v>{
        public MyEntry<k,v> next;
        public int hashcode;
        k key;
        v value;
        @Override
        public MyEntry<k,v> getEntry(){
            return null;
        }
    }

}