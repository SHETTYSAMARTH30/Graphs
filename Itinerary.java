class Itinerary {
    
    LinkedList<String> result = null;
    Map<String,LinkedList<String>> flightMap = new HashMap();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        //This question is similar to eulerian path where we need to visit all the edges exactly once but its not necessary to end where is started.
        
        //It should end when it reaches a vertex where all its outgoing edges are visited
        //Create a graph from source to destination
        for(List<String> ticket : tickets){
            
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            
            if(flightMap.containsKey(origin)){
                
                LinkedList<String> list = flightMap.get(origin);
                list.add(dest);
            }
            else{
                
                LinkedList<String> list = new LinkedList<>();
                list.add(dest);
                flightMap.put(origin,list);
            
            }
            
        }
        
        //Sort all the destinations lexicographically
        for(Map.Entry<String,LinkedList<String>> map : flightMap.entrySet()){
            
            Collections.sort(map.getValue());
        }
        
        result = new LinkedList<String>();
        
        // post-order DFS
        DFS("JFK");
        return result;
        
    }
    
    public void DFS(String origin){
        
        // Visit all the outgoing edges first.
        if(flightMap.containsKey(origin)){
            
            LinkedList<String> destList = flightMap.get(origin);
            while(!destList.isEmpty()){
                
//while we visit a edge, we trim it off from the graph so that again when we reach //same origin it wont vist that edge
                String dest = destList.poll();
                DFS(dest);
            }
        }
        
        //we add the airport/origin to head of itinerary like a stack
        result.addFirst(origin);
        
    }
}
