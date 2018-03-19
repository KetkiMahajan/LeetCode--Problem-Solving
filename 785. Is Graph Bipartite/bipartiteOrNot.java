import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * Given a Undirected Graph- Find if it is Bipartite or Not?
 * Created by Ketki Mahajan on 3/17/2018.
 **/
public class BipartiteGraph
{
    HashMap<Integer, Node> hm = new HashMap<>();
    boolean flagStop=true;

    public static void main(String[] args)
    {
        BipartiteGraph g = new BipartiteGraph();

        Node n0 = new Node(0); Node n1 = new Node(1);Node n2 = new Node(2);
        Node n3 = new Node(3);Node n4 = new Node(4); Node n5 = new Node(5);Node n6 = new Node(6);
        Node n7 = new Node(7);Node n8 = new Node(8);

        g.hm.put(0, n0);g.hm.put(1, n1);g.hm.put(2, n2);g.hm.put(3, n3);g.hm.put(4, n4);
        g.hm.put(5, n5);g.hm.put(6, n6);g.hm.put(7, n7);g.hm.put(8, n8);

        //g.addEdge(n0, n1);g.addEdge(n0, n2);g.addEdge(n1, n2);g.addEdge(n3, n4);
        g.addEdge(n1, n2);g.addEdge(n1, n8);g.addEdge(n2, n3);g.addEdge(n3, n4);
        g.addEdge(n3, n5);g.addEdge(n6, n5);g.addEdge(n7, n6);g.addEdge(n6, n8);g.addEdge(n2, n8);
        g.DFS();
    }

    private void addEdge(Node n1, Node n2)
    {
        n1.adjList.add(n2);
        n2.adjList.add(n1);
    }

    private void DFS() {
        for (int i = 0; i < hm.size(); i++) {
            hm.get(i).color = "white";
        }
        for (int i = 0; i < hm.size(); i++) {
            if (hm.get(i).color.equals("white")) {
                hm.get(i).color="Red";
                DFS_Visited(hm.get(i));
            }
        }
        if(flagStop==false) {
            System.out.println("Not a bipartite");
        } else {
            System.out.println("It is a bipartite");
            printGraph();
        }
    }



    private void DFS_Visited(Node node ) {
        if(!flagStop){
            return;
        }
        for (Node z : node.adjList) {
            if (z.color.equals("white"))
            {
                if(node.color.equals("Red")){
                    z.color="Blue";
                    DFS_Visited(z);
                }else{
                    z.color="Red";
                    DFS_Visited(z);
                }
            }
            if((node.color.equals(z.color))) {
                    flagStop=false;
            }
        }
    }

    private static class Node {
        int id;
        String color = " ";
        LinkedList<Node> adjList = new LinkedList<Node>();
        private Node(int id) {
            this.id = id;
        }
    }
    private void printGraph() {
        System.out.println("Group 1 ");
        for(int i=0;i<hm.size();i++){
            if(hm.get(i).color.equals("Red")){
                System.out.print(hm.get(i).id + " ");
            }
        }

        System.out.println(" ");
        System.out.println("Group 2: ");
        for(int i=0;i<hm.size();i++){
            if(hm.get(i).color.equals("Blue")){
                System.out.print(hm.get(i).id +" ");
            }
        }
    }

}
