class ValidateTreeGraph {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        if(n < 2)
            return true;
        
        /* We check here for 3 conditions Eg case= left: [-1,2,3,1] and right: [-1,-1,-1,-1]
        
        1. Indegree of all the node in the tree must be 1 or 0 (root node)
        2. There must be only 1 root node (Indegree 0)
        3. Node in a tree must not be isolated (disjointed graph) ie it must have a 
        left or right child
*/
        int[] indegree = new int[n];
        
        for(int i : leftChild){
            
            if(i != -1){
                indegree[i] += 1;
                
                if(indegree[i] > 1)
                    return false;
            }
        }
        
        for(int j: rightChild){
            
            if(j != -1){
                indegree[j] += 1;
                if(indegree[j] > 1)
                    return false;
            }
        }
        
        int rootNodeCount = 0;
        int rootNodeIndex = -1;
        
        for(int i = 0; i < indegree.length; i++){
            
            if(indegree[i] == 0){
                rootNodeCount += 1;
                rootNodeIndex = i;
            }
            
            if(rootNodeCount > 1)
                return false;
        }
        
        return rootNodeCount == 1 && (leftChild[rootNodeIndex] != -1 || rightChild[rootNodeIndex] != -1);
        
    }
}
