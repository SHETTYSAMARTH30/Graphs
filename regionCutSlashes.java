class regionCutSlashes {
    
    int n,count;
    int f[];
    
    public int regionsBySlashes(String[] grid) {
        
        n = grid.length;
        count = n*n*4;
        
        //Creating 4 cells in each block of n rows and n columns.
        f = new int[n*n*4];
        
        for(int i=0; i < n*n*4; i++){
            f[i]=i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n ;j++){
                
                //To remove the line that seperates cell[0,0] and [1,0]
                if(i > 0){
                    union(g(i-1,j,2),g(i,j,0));
                }
                
                //To remove the line that seperates cell[0,0] and [0,1]
                if(j > 0){
                    union(g(i,j-1,1),g(i,j,3));
                }
                
    //Merges the following cells for \ and blank (For blank input both if condition will run)
                if(grid[i].charAt(j) != '/'){
                    union(g(i,j,0),g(i,j,1));
                    union(g(i,j,2),g(i,j,3));
                }
                
                //Merges the following cells for / and blank
                if(grid[i].charAt(j) != '\\'){
                    union(g(i,j,0),g(i,j,3));
                    union(g(i,j,1),g(i,j,2));
                }
                    
            }
        }
        
        return count;
        
    }
    
    public int find(int x){
        
        if(x != f[x]){
            f[x] = find(f[x]);
        }
        
        return f[x];
    }
    
    public void union(int x, int y){
     
        x = find(x);
        y = find(y);
        
        if(x != y){
            f[x] = y;
            count--;
        }
        
        
    }
    
    public int g(int i, int j, int k){
        return (i*n + j)*4 + k;
    }
    
 
}
