class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] result=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums[i%n]) st.pop();
            if(i<n){
                if(st.size()==0) result[i]=-1;
                else result[i]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return result;
    }
}