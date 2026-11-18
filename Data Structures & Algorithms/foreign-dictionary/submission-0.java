class Solution {
    public String foreignDictionary(String[] words) {
        
        Map<Character, List<Character>> adjl = new HashMap<>();
        boolean result = buildAdjacencyList(adjl, words);
        if (!result) {
            return "";
        }

        List<Character> visited = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (Map.Entry<Character, List<Character>> entry: adjl.entrySet()) {
            if (visited.contains(entry.getKey())) {
               continue; 
            }
            List<Character> path = new ArrayList<>();
            result = dfs(visited, entry.getKey(), path, stack, adjl);
            if (!result) {
                return "";
            }
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
      
    }

    boolean dfs(List<Character> visited, Character current, List<Character> path, Deque<Character> stack, Map<Character, List<Character>> adjl) {
        if(visited.contains(current)) {
            return true;
        }
        if (path.contains(current)) {
            return false;
        }
        
        path.add(current);

        for (Character neighbor: adjl.get(current)) {
            boolean result = dfs(visited, neighbor, path, stack, adjl);
            if(!result) {
                return false;
            }
        }
        path.remove(current);
        visited.add(current);
        stack.push(current);
        return true;
    }


    boolean buildAdjacencyList(Map<Character, List<Character>> adjl, String[] words) {
        
        for (String str: words) {
            for(char c: str.toCharArray())
            {
                adjl.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i<words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            if (word2.length() < word1.length() && word1.startsWith(word2)) {
                return false;
            }

            if (word2.startsWith(word1)) {
                continue;
            }

            int j=0,k=0;

            while (j<word1.length() && k<word2.length() && word1.charAt(j) == word2.charAt(k)) {
                j++;
                k++;
            }

            if (j<word1.length() && k<word2.length()) {
                adjl.get(word1.charAt(j)).add(word2.charAt(k));
            }

        }
        return true;
    }
}
