class FloydWarshallSmallestNeigh {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int dist[][] = new int[n][n];
        int minCities = n;
        int res = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    dist[i][j]=0;
                else
                    dist[i][j]=10001; 
                //10001 is the maximum distance 
            }
        }
        
        for(int[] edge: edges){
            dist[edge[0]][edge[1]]=edge[2];
            dist[edge[1]][edge[0]]=edge[2];
        }
        
        //Floyd Warshall (All pair shortest path)
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            
            int count = 0;
            for(int j=0; j<n; j++){
                
                if(dist[i][j] <= distanceThreshold){
                    count+=1;
                }
            }
            
            if(count <= minCities){
                res = i;
                minCities = count;
            }
            
        }
        
        return res;
        
    }
}
