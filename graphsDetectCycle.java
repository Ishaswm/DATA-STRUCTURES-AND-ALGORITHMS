import java.util.ArrayList;

public class graphsDetectCycle {
    // directed graph
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        //graph[1].add(new Edge(1, 0, 1));
        //graph[3].add(new Edge(3, 1, 1));
        //graph[3].add(new Edge(3, 2, 1));
        graph[2].add(new Edge(2, 3, 1));
        //graph[2].add(new Edge(2, 0, 1));
    }
    public static boolean isCycle(ArrayList<Edge>[] graph) { // O(V+E)
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i=0; i<graph.length; i++) {
            if (!visited[i]){
                if (isCycleUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]){
        visited[curr] = true;
        stack[curr] = true;

        for (int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }
            if (!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
