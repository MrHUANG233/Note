package on26day;
import java.util.*;
public class MapTest {
    
}
class Graph{
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        this.nodes=new HashMap<>();
        this.edges=new HashSet<>();
    }
}
class Node{
    public int in;
    public int out;
    public int value;
    public List<Node> nexts;
    public List<Edge> edges;
    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        this.edges=new ArrayList<>();
        this.nexts=new ArrayList<>();
    }
}
class Edge{
    public Node from;
    public Node to;
    public int weight;
    
    public Edge(Node from,Node to,int weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
}
