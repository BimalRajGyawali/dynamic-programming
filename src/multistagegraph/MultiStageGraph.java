package src.multistagegraph;

public class MultiStageGraph {
    static final class Result{
        final int cost;
        final String path;

        public Result(int cost, String path) {
            this.cost = cost;
            this.path = path;
        }
    }
    static String buildPathString(int[] paths, int n){
        StringBuilder path = new StringBuilder();

        int vertex = 0;
        while (vertex < n){
            path.append(vertex).append(" -> ");
            vertex = paths[vertex];
        }
        path.append(n);

        return path.toString();
    }

    static Result findShortestPathAndCost(int[][] graph){
        if(graph.length <= 0) return new Result(-1, "");

        /*
         * n : last vertex of graph
         * For graph with vertices 0, 1, 2, 3, 4, 5; n = 5
         */
        int n = graph[0].length - 1;
        int[] costs = new int[n+1];
        int[] paths = new int[n+1];

        costs[n] = 0;
        paths[n] = n;

        for(int i= n-1 ; i>=0; i--){
            int min = Integer.MAX_VALUE;

            for(int j = i+1; j<= n; j++){
                if(graph[i][j] != 0 && (graph[i][j]+ costs[j] < min)){
                    min = graph[i][j]+ costs[j];
                    paths[i] = j;
                }
            }
            costs[i] = min;
        }

        return new Result(costs[0], buildPathString(paths, n));
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 2, 5, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 11, 0, 0},
                {0, 0, 0, 0, 9, 5, 16, 0},
                {0, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 18},
                {0, 0, 0, 0, 0, 0, 0, 13},
                {0, 0, 0, 0, 0, 0, 0, 2}};

        Result result = MultiStageGraph.findShortestPathAndCost(graph);
        System.out.println(result.cost); // 9
        System.out.println(result.path); // 0 -> 3 -> 6 -> 7
    }
}
