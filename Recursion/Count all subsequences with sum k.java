class Solution {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return generate(nums,k,0,nums.length,0);
    }
    private int generate(int[]nums,int k,int s,int n,int index){
        //base case 
        if(index==n){
            if(s==k){
                return 1;
            }
            return 0;
        }
        s+=nums[index];
        int l=generate(nums,k,s,n,index+1);
        s-=nums[index];
        int r=generate(nums,k,s,n,index+1);

        return l+r;
    }
}