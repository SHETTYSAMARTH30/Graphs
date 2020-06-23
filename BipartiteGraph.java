class BipartiteGraph {
    
    public boolean isBipartite(int[][] graph) {
        
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int start=0; start < graph.length; start++){
            
            if(color[start] == -1){
                
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                color[start]=0;
        
                while(!queue.isEmpty()){
            
                    int curr = queue.poll();
                    int currColor = color[curr];
            
                    for(Integer i : graph[curr]){
                
                        if(color[i] == currColor)
                            return false;
                
                        else if(color[i] == -1){
                                color[i]= 1-currColor;
                                queue.add(i);
                        }
                    }
                }
        
                
            }
        }
        
        return true;
    
    }
    
}
