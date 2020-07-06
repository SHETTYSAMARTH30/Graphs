class CheapestFlight {
    
    int [][]adjMatrix;
    HashMap<Pair<Integer,Integer>,Long> memo;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        adjMatrix = new int[n][n];
        
        //We create an adjacency matrix since we have fewer nodes
        for(int[] flight : flights){
            
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }
        
        memo = new HashMap<Pair<Integer,Integer>,Long>();
        
        //finding the shortest path from source to destination
        long ans = findShortest(src,dst,K,n);
        
        return ans == Integer.MAX_VALUE? -1 : (int)ans;
    }
    
    public long findShortest(int src, int dest, int stops, int n){
        
        Pair<Integer,Integer> key = new Pair<Integer,Integer>(src,stops);
        
        //If we already have stores the shortest path from src to dest return
        if(memo.containsKey(key))
            return memo.get(key);
        
        //If we are already on destination then path length is 0
        if(dest == src)
            return 0;
        
        //This path cannot be used as it has more than K stops and still we are not reached dest
        if(stops < 0)
            return Integer.MAX_VALUE;
        
        long ans = Integer.MAX_VALUE;
        //We will traverse all neighbors and find shortest path among them from source to destination and cache them in a map so that we dont need to compute the shortest path from same node to dest if we come across them again 
        for(int nei = 0; nei < n; nei++){
            
            int weight = adjMatrix[src][nei];
            if(weight > 0){
                
                //We add the distance from source to next neighbor to shortest path from neighbor to destination
                ans = Math.min(ans,findShortest(nei,dest,stops-1,n) + weight);
                
            }
            
        }
        
        //We cache the shortest distance from source to destination along with stops
        memo.put(key,ans);
        return ans;
    }
}
