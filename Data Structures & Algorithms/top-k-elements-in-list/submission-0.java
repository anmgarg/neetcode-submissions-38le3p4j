class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        //Count
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.putIfAbsent(num, 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        // Convert & Sort
        List<int[]> frequencyToNumList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            frequencyToNumList.add(new int[]{entry.getValue(), entry.getKey()});
        }
        frequencyToNumList.sort((a, b) -> b[0] - a[0]);

        // get top k
        for (int i=0; i<k; i++) {
            result[i] = frequencyToNumList.get(i)[1];
        }
        return result;
    }
}
