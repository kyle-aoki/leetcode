class Solution {
    int[][] isConnected;
    int n;
    boolean[] visitedCities;
    int visited;

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        this.n = isConnected.length;
        this.visitedCities = new boolean[isConnected.length];
        this.visited = 0;

        for (int i = 0; i < this.n; i++) {
            if (this.visitedCities[i]) continue;
            this.search(i);
            this.visited++;
        }

        return this.visited;
    }

    private void search(int i) {
        this.visitedCities[i] = true;
        for (int j = 0; j < this.n; j++) {
            if (this.visitedCities[j]) continue;
            if (this.isConnected[i][j] == 1) this.search(j);
        }
    }
}
