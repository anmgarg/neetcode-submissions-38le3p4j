class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer freq = entry.getValue();
            List<Integer> group = bucket[freq];
            if (group == null) {
                group = new ArrayList<>();
                bucket[freq] = group;
            }
            group.add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            List<Integer> group = bucket[i];
            if (group != null) {
                for (int num : group) {
                    result[index] = num;
                    index++;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
