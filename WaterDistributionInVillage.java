class WaterDistributionInVillage {
    
    int root[];
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        root = new int[n+1];
        
        List<int[]> edges = new ArrayList<>();

        for(int i=0; i < n; i++){
            
            root[i+1] = i+1;
            edges.add(new int[]{0,i+1,wells[i]});
        }
        
        for(int p[] : pipes){
            
            edges.add(p);
        }
        
        Collections.sort(edges,(a,b) -> a[2] - b[2]);
        int totalCost = 0;
        
        for(int[] e : edges){
            
            int rootX = find(e[0]);
            int rootY = find(e[1]);
            
            if(rootX != rootY){
                
                root[rootX] = rootY;
                totalCost += e[2];
            }
        }
        
        return totalCost;
        
    }
    
    public int find(int x){
        
        if(x != root[x]){
            root[x] = find(root[x]);
        }
        
        return root[x];
    }
}
