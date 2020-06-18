class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1){
            return false;
        }
        
        List<List<Integer>> adjList = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int i=0; i < n; i++){
            adjList.add(new ArrayList());
        }
        
        for(int edge[] : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        stack.push(0);
        seen.add(0);
        
        while(!stack.isEmpty()){
            
            int node = stack.pop();
            
            for(Integer neighbour : adjList.get(node)){
                if(seen.contains(neighbour))
                    continue;
                
                stack.push(neighbour);
                seen.add(neighbour);
            }
        }
        
        return seen.size() == n;
        
    }
}
