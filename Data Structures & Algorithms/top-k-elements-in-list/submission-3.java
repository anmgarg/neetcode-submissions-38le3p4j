class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<Integer>[] arr = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            List<Integer> numbers = arr[entry.getValue()];
            if (numbers == null) {
                numbers = new ArrayList<>();
                arr[entry.getValue()] = numbers;
            }
            numbers.add(entry.getKey());
        }

        int[] result = new int[k];
        int count = 0;

        for (int i=arr.length - 1; i >= 0; i--) {
            List<Integer> numbers = arr[i];
            if(null != numbers)
            {
                for(Integer num : numbers) {
                    result[count] = num;
                    count++;
                 }
                if(count == k) {
                    break;
                }
            }
        }
        return result;
    }
}
