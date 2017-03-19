package graph;

import java.util.*;

/**
 * Created by code on 24/2/17.
 */

public class DFSTopSort {
    private static class Graph{
        final int V;
        LinkedList<Integer> adj[];
        Graph(int V){
            this.V = V;
            adj = new LinkedList[V];
            for(int i=0;i<V;i++){
                adj[i] = new LinkedList<>();
            }
        }
        void addEdge(int u,int v){
            adj[u].add(v);
        }
    }

    static void dfsVisit(Graph g, int s, Set<Integer> visited, List<Integer> finishOrder){
        visited.add(s);
        System.out.print(s+" ");
        for (int i = 0; i < g.adj[s].size(); i++) {
            int v = g.adj[s].get(i);
            if (!visited.contains(v)) {
                dfsVisit(g,v,visited,finishOrder);
            }
        }
        finishOrder.add(s);
    }
    static List<Integer> dfs(Graph g){
        Set<Integer> visited = new HashSet<>();
        List<Integer> finishOrder = new ArrayList<>();
        dfsVisit(g,0,visited,finishOrder);
        for(int i=0;i<g.V;i++){
            if(!visited.contains(i))
                dfsVisit(g,i,visited,finishOrder);
        }
        Collections.reverse(finishOrder);
        return finishOrder;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,5);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(6,7);
        graph.addEdge(0,7);
        System.out.println(DFSTopSort.dfs(graph));
    }
}

