class CoupleHoldingHands {
    
    int count;
    int root[];
    
    public int minSwapsCouples(int[] row) {
        
        int N = row.length/2;
        count = N;
        
        root = new int[N];
        
        for(int i=0; i<N; i++){
            root[i] = i;
        }
        
        for(int i=0; i<N; i++){
            
            int a = row[2*i];
            int b = row[2*i+1];
            union(a/2,b/2);
        }
        
        return N - count;
        
    }
    
    public void union(int x, int y){
        
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY)
            return;
        
        else{
            root[rootX] = rootY;
            count--;
        }
    }
    
    public int find(int x){
        
        if(x != root[x]){
            root[x] = find(root[x]);
        }
        
        return root[x];
    }
}
