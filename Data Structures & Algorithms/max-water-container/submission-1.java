class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int i = 0, j = heights.length-1;
        while (i<j) {
            int lowerEdge = Math.min(heights[i], heights[j]);
            int capacity = (j-i) * lowerEdge;
            result = Math.max(result, capacity);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return result;
    }
}
