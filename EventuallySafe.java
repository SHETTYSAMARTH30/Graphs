class EventuallySafe {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> ans = new ArrayList<>();
        
        int color[] = new int[graph.length];
        
        for(int i=0; i<graph.length; i++){
            if(dfs(i,graph,color))
                ans.add(i);
        }
        
        return ans;
    }
    
    public boolean dfs(int node,int[][] graph,int[] color){
        
        if(color[node] > 0)
            return color[node]==2;
        
        color[node]=1;
        
        for(int nei : graph[node]){
            
            if(color[nei] == 1 || !dfs(nei,graph,color))
                return false;
        }
        
        color[node]=2;
        return true;
    }
}
