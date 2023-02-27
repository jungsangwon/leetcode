class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        int minCost = Integer.MAX_VALUE;

        for (int stop = 0; stop <= k; stop++) {
            int[] tempDistances = Arrays.copyOf(distances, n);
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], cost = flight[2];
                if (distances[from] != Integer.MAX_VALUE && distances[from] + cost < tempDistances[to]) {
                    tempDistances[to] = distances[from] + cost;
                    if (to == dst) {
                        minCost = Math.min(minCost, tempDistances[to]);
                    }
                }
            }
            distances = tempDistances;
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
