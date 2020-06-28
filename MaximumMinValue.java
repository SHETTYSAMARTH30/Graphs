class MaximumMinValue {
    public int maximumMinimumPath(int[][] A) {
        
        int n = A.length;
        int m = A[0].length;
        
        //To keep track of whether the element is visited or not
        boolean visited[][] = new boolean[n][m];
        
        //We add these values to a particular cell to go north,east,south,west
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        
        // in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far, thus we reverse the ordering in the pq
        //We will pop the maximum element from the queue (But we will keep track of min element while BFS), hence we create MAX HEAP
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        
        //Add first cell to queue and perform BFS until we reach A[n-1][m-1]
        pq.add(new int[]{0,0,A[0][0]});
        
        //BFS
        while(!pq.isEmpty()){
            
            int[] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];
            
            //If we reach the dest then return the maximum minimum of the path
            if(row == n-1 && col == m-1)
                return cell[2];
            
            //Mark the cell as visited and explore its neighbors
            visited[row][col] = true;
            
            //We add directions to a cell to explore its neighbors
            for(int[] dir : directions){
                
                int nRow = row + dir[0];
                int nCol = col + dir[1];
                
                //We visit only unvisited cells
                if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= m || visited[nRow][nCol])
                    continue;
                
                //we are keeping track of the minimum element that we have seen until now
                pq.add(new int[]{nRow,nCol,Math.min(cell[2],A[nRow][nCol])});
            }
            
        }
        
        return -1;
        
    }
}
