package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by code on 24/2/17.
 */
class Graph{
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
public class BFS {
    static void bfsVisit(Graph g,int s,Set<Integer> visited){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s+" ");
            for (int i = 0; i < g.adj[s].size(); i++) {
                int v = g.adj[s].get(i);
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }

    }
    static void bfs(Graph g){
        Set<Integer> visited = new HashSet<>();
        bfsVisit(g,2,visited);
        for(int i=0;i<g.V;i++){
            if(!visited.contains(i))
                bfsVisit(g,i,visited);
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.addEdge(4,4);
        BFS.bfs(graph);
    }
}
