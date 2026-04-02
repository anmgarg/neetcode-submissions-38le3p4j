class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        List<int[]> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            int[] arr = new int[2];
            arr[0] = entry.getKey();
            arr[1] = entry.getValue();
            list.add(arr);
        }

        list.sort((a, b) -> b[1] - a[1]);

        int[] resultList = new int[k];

        for (int i=0; i<k; i++) {
            resultList[i] =  list.get(i)[0];
        }
        
        return resultList;
    }
}
