class Solution {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        return generate(nums,k,0,new ArrayList<Integer>(),nums.length,0);
    }
    private boolean generate(int[]nums,int sum,int index,ArrayList<Integer> current,int n,int s){
        if(index==n){
            if(s==sum){
                return true;
            }
            return false;
        }
        current.add(nums[index]);
        s+=nums[index];
        if(generate(nums,sum,index+1,current,n,s)==true){
            return true;
        }
        current.remove(current.size()-1);
        s-=nums[index];
        if(generate(nums,sum,index+1,current,n,s)==true){
            return true;
        }
        return false;
    }
}