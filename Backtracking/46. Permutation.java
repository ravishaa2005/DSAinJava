class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[] isVisited=new boolean[nums.length];
        helper(nums,ds,ans,isVisited);
        return ans;
    }
    private void helper(int[] nums,List<Integer> ds,List<List<Integer>> ans,boolean[] isVisited){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isVisited[i]==false){
                ds.add(nums[i]);
                isVisited[i]=true;
                helper(nums,ds,ans,isVisited);
                //backtrack
                isVisited[i]=false;
                ds.remove(ds.size()-1);
            }
        }
    }
}