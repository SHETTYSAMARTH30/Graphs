class Ugly{
    
    //We create an array to store the ugly numbers
    public int[] nums = new int[1690];
    Ugly(){
    
        int ugly, i2 = 0, i3 = 0, i5 = 0;
        nums[0] = 1;
        
        for(int i=1; i < 1690; i++){
            
            //We will multiply each number by 2, 3, 5 and store the minimum of them into array. 
            ugly = Math.min(Math.min(nums[i2]*2,nums[i3]*3),nums[i5]*5);
            
            nums[i] = ugly;
            
            //If ugly that we added was a factor of 2 then we increment i2 from the current position since we have used the factor of 2, similarly for i3 and i5
            if(ugly == nums[i2]*2)
                i2++;
            
            if(ugly == nums[i3]*3)
                i3++;
            
            if(ugly == nums[i5]*5)
                i5++;
            
        }
    }
}

class Solution {
    
    Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        
        //We retrieve the nth ugly number from the pre-computed array
        return u.nums[n-1];
    }    
}
