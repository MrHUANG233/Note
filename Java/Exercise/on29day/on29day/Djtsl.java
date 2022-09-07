package on29day;
import java.util.*;

public class Djtsl {
    public static void main(String[] args){

    }



}
class Graph{
    HashMap<Integer,Node> nodes;
    HashSet<Edge> edges;
    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
}
class Node{
    public int value;
    public int in;
    public int out;
    public List<Edge> edges;
    public List<Node> nodes;
    public Node(int value){
        this.value=value;
        this.edges=new ArrayList<>();
        this.nodes=new ArrayList<>();
    }
}
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