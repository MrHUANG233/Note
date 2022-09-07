import java.util.*;
public class MapStruct{
    public static void main(String[] args){

    }


}
/**
 * 图结构，包含点集和边集
 */
class Graph{
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }

}
/**
 * 点结构：1.值 2.入度 3.出度 4.当前点发散的直接邻居节点 5.点发散的边
 */
class Node{
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
/**
 *边结构
 */
class Edge{
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight,Node from,Node to){
        this.weight=weight;
        this.from=from;
        this.to=to;
    }
}