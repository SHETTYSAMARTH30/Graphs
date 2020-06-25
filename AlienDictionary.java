class AlienDictionary {
    public String alienOrder(String[] words) {
        
        // Step 0: Create data structures and find all unique letters.
        Map<Character,List<Character>> adjList = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();
        
        for(String word : words){
            
            for(char c : word.toCharArray()){
                indegree.putIfAbsent(c,0);
                adjList.putIfAbsent(c,new ArrayList<>());
            }
        }
        
        //We create an adjacency list from smaller letter to bigger one and count indegree of nodes
        for(int i=1; i<words.length; i++){
            
            String first = words[i-1];
            String second = words[i];
            int size = Math.min(first.length(),second.length());
            
            // Check that second is not a prefix of first.
            if(first.length() > second.length() && first.startsWith(second))
                return "";
            
            // Find the first non match and insert the corresponding relation.
            for(int j=0; j < size; j++){
                
                if(first.charAt(j) != second.charAt(j)){
                    
                    adjList.get(first.charAt(j)).add(second.charAt(j));
                    indegree.put(second.charAt(j),indegree.get(second.charAt(j))+1);
                    break;
                }
            }
        }
        
        //We then perform topological sort on the graph, if there is a cycle then it means there is no perfect ordering of alien letters hence return " " eg- z-> x-> z

        //The letters which have the indegree as 0 are the lowest order letters so we put them in queue eg a -> b -> c hence a has lowest order
        //We remove the outgoing edges from these nodes ie decrement indegree of their neighbors by 1.
        //If their indegree becomes 0 too then we add them to queue coz they are next lowest letters.
        
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(Character c : indegree.keySet()){
            
            if(indegree.get(c) == 0)
                queue.add(c);
        }
        
        while(!queue.isEmpty()){
            
            char node = queue.poll();
            sb.append(node);
            
            for(Character neigh : adjList.get(node)){
                
                indegree.put(neigh,indegree.get(neigh)-1);
                if(indegree.get(neigh) == 0)
                    queue.add(neigh);
                
            }
        }
        
        if(sb.length() < indegree.size())
            return "";
        
        return sb.toString();
        
    }
}
