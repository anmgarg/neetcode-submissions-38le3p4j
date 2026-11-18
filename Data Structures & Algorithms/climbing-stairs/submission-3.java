class Solution {

    public int climbStairs(int n) {
        int lStep = 1;
        int lSStep = 1;

        for (int i = n-2; i>=0; i--) {
            int temp = lSStep;
            lSStep = lStep + lSStep;
            lStep = temp;
        }
        return lSStep;
    }
}
