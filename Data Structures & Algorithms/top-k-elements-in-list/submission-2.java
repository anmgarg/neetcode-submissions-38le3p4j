class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] arr = new int[2];
            arr[0] = entry.getValue();
            arr[1] = entry.getKey();
            pq.offer(arr);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            int[] arr = pq.poll();
            result[i] = arr[1];
        }
         
        return result;
    }
}
