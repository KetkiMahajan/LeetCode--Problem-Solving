import java.util.HashMap;
import java.util.LinkedList;

/**
 * Implementation of Data Structure and Algorithms
 * Connected Components in graph
 * Created by Ketki Mahajan on 3/16/2018.
 **/
public class ConnectedComponents {

    HashMap<Integer, Node> hm = new HashMap<>();
    int count = 0;

    public static void main(String[] args) {
        ConnectedComponents g = new ConnectedComponents();
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        g.hm.put(0, n0);
        g.hm.put(1, n1);
        g.hm.put(2, n2);
        g.hm.put(3, n3);
        g.hm.put(4, n4);

        g.addEdge(n0, n1);
        g.addEdge(n0, n2);
        g.addEdge(n1, n2);
        g.addEdge(n3, n4);

        //g.printGraph();
        g.DFS();
    }

    private void addEdge(Node n1, Node n2) {
        n1.adjList.add(n2);
    }

    private void DFS() {
        for (int i = 0; i < hm.size(); i++) {
            hm.get(i).color = "white"; //Node not visited
        }
        for (int i = 0; i < hm.size(); i++) {

            if (hm.get(i).color.equals("white")) {
                count++;
                DFS_Visited(hm.get(i), count);
            }


        }
    }

    private void DFS_Visited(Node node, int count) {
        node.color = "gray"; //Node is active
        node.c_com = count;
        System.out.println("Node:  " + node.id + " count :" + node.c_com);
        for (Node z : node.adjList) {
            if (z.color.equals("white")) {
                DFS_Visited(z, count);
            }
        }
        node.color = "black"; //Node processed

    }

    private static class Node {
        int id;
        String color = " ";
        int c_com;
        LinkedList<Node> adjList = new LinkedList<Node>();

        private Node(int id) {
            this.id = id;
        }
    }

}
