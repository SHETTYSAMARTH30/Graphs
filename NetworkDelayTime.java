class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        Map<Integer,List<int[]>> graph = new HashMap<Integer,List<int[]>>();
        
        for(int edge[]:times){
            
            if(!graph.containsKey(edge[0]))
                graph.put(edge[0],new ArrayList<int[]>());
            
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (info1, info2) -> (info1[0] - info2[0]));
        
        heap.add(new int[]{0,K});
        
        Map<Integer,Integer> dist = new HashMap<>();
        
        while(!heap.isEmpty()){
            
            int info[] = heap.poll();
            
            int d=info[0];
            int node = info[1];
            
            if(dist.containsKey(node))
                continue;
            dist.put(node,d);
            
            if(graph.containsKey(node)){
                
                for(int[] edge: graph.get(node)){
                    
                    int nei = edge[0];
                    int d2 = edge[1];
                    
                    if(!dist.containsKey(nei)){
                        heap.add(new int[]{d+d2,nei});
                    }
                }
            }
        }
        
        if(dist.size() != N)
            return -1;
        
        int ans = 0;
        for(int cand : dist.values()){
            ans = Math.max(ans,cand);
        }
        
        return ans;
            
    }
}
