class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        for (int i = 0; i< heights.length - 1; i++) {
            int capacity = 1;
            for (int j=i+1; j<heights.length; j++) {
                int lowerEdge = Math.min(heights[i], heights[j]);
                capacity = (j-i) * lowerEdge;
                if (capacity > result) {
                    result = capacity;
                }
            }
        }
        return result;
    }
}
