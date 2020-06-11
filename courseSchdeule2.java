class courseSchdeule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] topologicalOrder = new int[numCourses];
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int i=0;i < prerequisites.length; i++){
            
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            List<Integer> lst = adjList.getOrDefault(src,new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);
            indegree[dest]+=1;
            
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        
        
        int index = 0;
        while(!queue.isEmpty()){
            
            int node = queue.remove();
            topologicalOrder[index++]= node;
            
            if(adjList.containsKey(node)){
                
                for(Integer neighbor: adjList.get(node)){
                    
                    indegree[neighbor]-=1;
                    
                    if(indegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        
        if(index == numCourses){
            return topologicalOrder;
        }
        
        return new int[0];
        
    }
}
