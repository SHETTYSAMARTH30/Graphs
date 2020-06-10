class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer,List<Integer>> courseDict = new HashMap<>();
        
        for(int relation[]:prerequisites){
            
            if(courseDict.containsKey(relation[1])){
                List<Integer> courses = courseDict.get(relation[1]);
                courses.add(relation[0]);
                courseDict.put(relation[1],courses);
            }
            else{
                List<Integer> newCourses = new ArrayList<>();
                newCourses.add(relation[0]);
                courseDict.put(relation[1],newCourses);
            }
        }
        
        boolean checked[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];
        
        for(int currCourse=0; currCourse < numCourses; currCourse++){
            if(isCyclic(currCourse,courseDict,checked,path)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean isCyclic(int currCourse,HashMap<Integer,List<Integer>> courseDict, boolean[] checked,boolean[] path){
        
    //If the foll course has already been checked for not having a cycle then true
        if(checked[currCourse]){
            return false;
        }
        
        //To check whether the cycle exists
        if(path[currCourse]){
            return true;
        }
        
        //If that course doesn't have an edge to other course so loop ends
        if(!courseDict.containsKey(currCourse)){
            return false;
        }
        
        path[currCourse]=true;
        
        boolean ret = false;
        
        for(Integer child:courseDict.get(currCourse)){
            ret = isCyclic(child,courseDict,checked,path);
            if(ret){
                break;
            }
        }
        
        path[currCourse] = false;
        
        checked[currCourse] = true;
        
        return ret;
    }
}
