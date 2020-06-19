class ConnectedComponentsGraph {
    public int countComponents(int n, int[][] edges) {
        
        int roots[] =  new int[n];
        
        for(int i=0; i<n; i++){
            roots[i]=i;
        }
        
        for(int[] edge:edges){
            
            int a = edge[0];
            int b = edge[1];
            if(union(roots,a,b)){
                n--;
            }
        }
        
        return n;
        
    }
    
    public boolean union(int[] roots,int a,int b){
        
        int rootA = find(roots,a);
        int rootB = find(roots,b);
        
        if(rootA == rootB){
            return false;
        }
        
        roots[rootA]=rootB;
        return true;
    }
    
    public int find(int[] roots,int id){
        
        while(roots[id] != id){
            
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        
        return id;
    }
}
