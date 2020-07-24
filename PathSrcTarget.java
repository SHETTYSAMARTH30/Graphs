class PathSrcTarget {
    
    List<List<Integer>> result;
    int[][] graph;
    int target;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        //For storing all the paths
        result = new ArrayList<List<Integer>>();
        this.graph = graph;
        
        //the last node in graph
        this.target = graph.length - 1;
        
        //For storing each node in the path, and then add this to result on reaching target
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        
        // kick of the backtracking, starting from the source (node 0)
        backtrack(path, 0);
        
        return result;
    }
    
    public void backtrack(LinkedList<Integer> path, int currNode){
        
        //If we reached destination then add list of all nodes along the path into final result list
        if(currNode == target){
            
            //We create new copy of path and store in result cuz if we append same copy of path into result, then when we backtrack and modify the path list, the contents inside the result list will also modify
            
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        //Traverse all the neighboring nodes of current node
        for(int nextNode : graph[currNode]){
            
            //We will perform dfs until we reach target and add all the nodes along path
            // mark the choice, before backtracking.
            path.add(nextNode);
            
            backtrack(path, nextNode);
            
            //Remove the last added node which is n and explore new path
            path.removeLast();
             
        } 
        
    }
}
