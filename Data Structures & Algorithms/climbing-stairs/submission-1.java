class Solution {

    int[] cache;

    public int climbStairs(int n) {
        cache = new int[n+1];

        for(int i = 0; i<n+1; i++) {
            cache[i] = -1;
        }
        return dfs(n, 1) + dfs(n,2);
    }

    public int dfs(int n, int count) {

        if (count == n) {
            return 1;
        }

        if(count >= n) {
            return 0;
        }

        if (cache[count] != -1) {
            return cache[count];
        }

        cache[count] = dfs(n, count + 1) + dfs(n, count + 2);
        return cache[count];

    }
}
