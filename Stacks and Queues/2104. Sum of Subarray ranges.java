class Solution {
    public long subArrayRanges(int[] nums) {
        long totalSum=0;
        long min=sumSubarrayMinimum(nums);
        long max=sumSubarrayMaximum(nums);
        totalSum+=(max-min);
        return totalSum;
    }
    private long sumSubarrayMinimum(int[]nums){
        //left=i-pse
        //right=nse-i
        //total+=left*right*nums[i]

        //previous smaller element
        int n=nums.length;
        int[]pse=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && nums[st.peek()]>=nums[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }

        while(st.size()>0) st.pop();
        //next smaller element
        int[]nse=new int[n];
        nse[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]>nums[i]) st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }

        long totalMin=0;
        for(int i=0;i<n;i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            totalMin += left * right * (long) nums[i];
        }
    return totalMin;
    }

        private long sumSubarrayMaximum(int[]nums){
        //left=i-pge
        //right=nge-i
        //total+=left*right*nums[i]

        //previous greater element
        int n=nums.length;
        int[]pge=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        pge[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && nums[st.peek()]<=nums[i]) st.pop();
            if(st.size()==0) pge[i]=-1;
            else pge[i]=st.peek();
            st.push(i);
        }

        while(st.size()>0) st.pop();
        //next greater element
        int[]nge=new int[n];
        nge[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<nums[i]) st.pop();
            if(st.size()==0) nge[i]=n;
            else nge[i]=st.peek();
            st.push(i);
        }

        long totalMax=0;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            totalMax += left * right * (long) nums[i];
        }
    return totalMax;
    }
    
}