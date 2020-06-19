class CourseSchedule4 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        
        boolean connected[][]= new boolean[n][n];
        
        for(int[] p:prerequisites){
            connected[p[0]][p[1]]=true;
        }
        
        for(int k=0; k < n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++)
                    connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
                
            }
        }
        
        List<Boolean> result = new ArrayList();
        
        for(int query[]: queries){
            if(connected[query[0]][query[1]])
                result.add(true);
            else
                result.add(false);
            
        }
        
        return result;
    }
}
