class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        //We are building a graph. Eg (a->[b,2.0], b->[a,1/2.0])
        //If the value from a to b is 2.0 then b to a will be 1/2.0
        Map<String,Map<String,Double>> graph = buildGraph(equations,values);
        
        double[] result = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++){
            
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            //We will perform dfs from start to end ie (a to c) and product all the values on way, if we dont find the node then return -1
            result[i] = dfs(start,end,new HashSet(), graph);
            
        }
        
        return result;
        
    }
    
    public Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        
        Map<String,Map<String,Double>> graph = new HashMap<>();
        
        for(int i=0; i < equations.size(); i++){
            
            //If we put a-> b as 2.0 then b -> a will be 1/2.0 as a/b == 1/(a/b)
            graph.putIfAbsent(equations.get(i).get(0),new HashMap());
            graph.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
            graph.putIfAbsent(equations.get(i).get(1),new HashMap());
            graph.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);
            
        }
        
        return graph;
    }
    
    public double dfs(String start, String end, Set<String> visited, Map<String,Map<String,Double>> graph){
        
        //Returns -1 if there is no String in graph
        if(!graph.containsKey(start))
            return -1;
        
        //If we find the end node in graph then we return its value
        if(graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        //Mark the node we are going to explore so that we avoid the cycles
        visited.add(start);
        
        //We will explore all the neighbors of the start node (Performing DFS)
        for(Map.Entry<String,Double> neighbors : graph.get(start).entrySet()){
            
            //If the node is visited then leave
            if(!visited.contains(neighbors.getKey())){
                
                double weight = dfs(neighbors.getKey(),end,visited,graph);
                
                //We multiply all the values along the way from start node to end node and return
                if(weight != -1){
                    return weight * neighbors.getValue();
                }
            } 
        }
        
        //If we dont find the end node in the graph then return -1
        
        return -1;

    }
}
