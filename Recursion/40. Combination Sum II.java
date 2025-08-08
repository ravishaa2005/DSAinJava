class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        generate(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    private void generate(int index,int[]nums,int target,List<List<Integer>>ans,List<Integer>current){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            if(nums[i]>target) break;

            current.add(nums[i]);
            generate(i+1,nums,target-nums[i],ans,current);
            current.remove(current.size()-1);
        }
    }
}