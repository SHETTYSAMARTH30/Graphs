class pathSrcToDest {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
     
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        
        for(int i=0;i<edges.length;i++){
            
            List<Integer> lst = adjList.getOrDefault(edges[i][0],new ArrayList<Integer>());
            lst.add(edges[i][1]);
            adjList.put(edges[i][0],lst);
        }
        
        if(adjList.containsKey(destination))
            return false;
        
        return dfs(adjList,source,destination,new boolean[n]);
        
    }
    
    public boolean dfs(Map<Integer,List<Integer>> adjList,int source,
                       int destination,boolean seen[]){
        
        if(source == destination)
            return true;
        
        seen[source]=true;
        
        if(!adjList.containsKey(source))
            return false;
        
        for(Integer node : adjList.get(source)){
            
            if(seen[node] || !dfs(adjList,node,destination,seen))
                return false;
        }
        
        seen[source] = false;
        return true;
        
    }
}   
