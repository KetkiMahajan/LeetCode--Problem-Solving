/**
 * Implementation of Data Structure and Algorithms
 * Objective- to find minimum moves(dice throws) to go from source to target in Snake and Ladder game
 * If snake apperas after the die roll at some node then go back to snakes's tail
 * If Ladder apperas after the die roll at some node then go forward at the top of ladder
 * Created by Ketki Mahajan on 3/9/2018.
 **/

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    private static class Node{
        int id;
        int dist;  //Distance from the starting node
    }
    private static void findMinMoves(int[] Steps, int node) {
        boolean[] visited=new boolean[node];
        Queue<Node> queue= new LinkedList<>();
        Node n=new Node();

        n.id=0;
        n.dist=0;
        visited[0]=true;

        queue.add(n);

        while (!queue.isEmpty())
        {
            n=queue.remove();
            int size= n.id;

            if(size == (node-1))
                break;

            for (int i = size + 1; i <= (size + 6) && i < node; ++i)
            {
                if( !visited[i]){
                    Node n2= new Node();

                    n2.dist= (n.dist+1);
                    visited[i]= true;

                    if(Steps[i] != -1)
                        n2.id=Steps[i];
                    else
                        n2.id=i;

                    queue.add(n2);
                }
            }

        }
        System.out.println("Minimum Steps required to reach to destination is: "+ n.dist);
    }
    public static void main(String[] args) {
        int Node = 100;
        int Steps[]=new int[Node];
        for (int i = 0; i < Node; i++) {
          Steps[i]= -1;
        }

        //Snakes at Node will leave you at following positions
        Steps[14]=1;
        Steps[8]=3;
        Steps[11]=2;


        //Ladder at Node will leave you at following positions
        Steps[4]=7;
        Steps[10]=15;
        Steps[16]=98;

        findMinMoves(Steps, Node);

    }

}
