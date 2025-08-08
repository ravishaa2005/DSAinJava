class Solution {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        generate(nums,0,0,ans);
        return ans;
    }
    private void generate(int[]nums,int index,int currentsum,List<Integer>ans){
        if(index>=nums.length){
            ans.add(currentsum);
            return;
        }
        //including current element
        generate(nums,index+1,currentsum+nums[index],ans);

        //not including current character
        generate(nums,index+1,currentsum,ans);
    }
}