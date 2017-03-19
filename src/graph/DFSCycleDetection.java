package graph;

import java.util.*;

/**
 * Created by code on 24/2/17.
 */

public class DFSCycleDetection {
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

    static void dfsVisit(Graph g, int s, Set<Integer> visited, Set<Integer> currStack){
        visited.add(s);
        currStack.add(s);
        System.out.print(s+" ");
        for (int i = 0; i < g.adj[s].size(); i++) {
            int v = g.adj[s].get(i);
            if (!visited.contains(v)) {
                dfsVisit(g,v,visited,currStack);
            }
            else if(currStack.contains(v)){
                System.out.println("cycle detected"+s+"->"+v);
            }
        }
        currStack.remove(s);

    }
    static void  dfs(Graph g){
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currStack = new HashSet<>();
        dfsVisit(g,0,visited,currStack);
        for(int i=0;i<g.V;i++){
            currStack.clear();
            if(!visited.contains(i))
                dfsVisit(g,i,visited,currStack);
        }
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
        graph.addEdge(5,0);
        graph.addEdge(5,5);
        DFSCycleDetection.dfs(graph);
    }
}

