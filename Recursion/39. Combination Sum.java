class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        generate(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }
    private void generate(int index,int target,int[]arr,List<List<Integer>> ans,List<Integer>current){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(arr[index]<=target){
            current.add(arr[index]);
            generate(index,target-arr[index],arr,ans,current);
            current.remove(current.size()-1);
        }
        generate(index+1,target,arr,ans,current);
    }
}