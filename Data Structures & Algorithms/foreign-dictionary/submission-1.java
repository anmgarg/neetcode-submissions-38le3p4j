class Solution {

    /**
        Kahn's algo

        1. calculate adjacency list.
        2. calculate indegree of each node.
        3. put the nodes with indegree as 0 to the queue.
        4. Take out the element from the queue and add it to the result list.
        5. Check it's neigbours and reduce their indegree.
        6. Place the nodes with indegree as 0 to the queue.
    */

    public String foreignDictionary(String[] words) {

        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 1; i< words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            if (word2.startsWith(word1)) {
                continue;
            }

            int j=0,k=0;

            while(j<word1.length() && k<word2.length()) {
                if (word1.charAt(j) == word2.charAt(k)) {
                    j++;
                    k++;
                } else {
                    adj.get(word1.charAt(j)).add(word2.charAt(k));
                    indegree.put(word2.charAt(k), indegree.get(word2.charAt(k)) + 1);
                    break;
                }
                
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }
        StringBuilder str = new StringBuilder();
        while (!q.isEmpty()) {
            Character c = q.poll();
            str.append(c);

            for (Character neighbor: adj.get(c)) {
                Integer value = indegree.get(neighbor);
                indegree.put(neighbor, value-1);
                if (value - 1 == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (adj.size() > str.length()) {
            return "";
        } else {
            return str.toString();
        }
        

      
    }
}
