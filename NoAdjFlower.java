class NoAdjFlower {
    public int[] gardenNoAdj(int N, int[][] paths) {
        
        Map<Integer,Set<Integer>> map = new HashMap<>();
        
        for(int i=0; i < N; i++){
            map.put(i,new HashSet<Integer>());
        }
        
        for(int[] path: paths){
            map.get(path[0]-1).add(path[1]-1);
            map.get(path[1]-1).add(path[0]-1);
        }
        
        int res[] = new int[N];
        
        for(int i = 0; i < N; i++){
            
            int flowers[] = new int[5];
            
            for(Integer j : map.get(i)){
                flowers[res[j]] = 1;
            }
            
            for(int f=4; f > 0; f--){
                if(flowers[f] == 0)
                    res[i] = f;
            }
        }
        
        return res;
        
    }
}
