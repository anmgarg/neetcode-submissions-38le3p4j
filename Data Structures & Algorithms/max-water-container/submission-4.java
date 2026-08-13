class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int capacity = (right - left) * (heights[left] < heights[right] ? heights[left] : heights[right]);
            if (capacity > result) {
                result = capacity;
            }

            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
