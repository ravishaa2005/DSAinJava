class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        generate(1,k,n,0,new ArrayList<>(),ans);
        return ans;
    }
    private void generate(int index,int k,int n,int sum,List<Integer>current,List<List<Integer>>ans){
        if(sum>n) return;
        if(k==0){
            if(sum==n){
                ans.add(new ArrayList<>(current));
            }
            return;
        }
        if(index>=10) return;

        current.add(index);
        sum+=index;
        generate(index+1,k-1,n,sum,current,ans);

        sum-=index;
        current.remove(current.size()-1);

        generate(index+1,k,n,sum,current,ans);

    }
}