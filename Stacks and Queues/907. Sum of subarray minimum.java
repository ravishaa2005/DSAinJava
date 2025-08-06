class Solution {
    public int sumSubarrayMins(int[] arr) {
        //i-pse[i]*nse[i]-i
        int n=arr.length;

        int[]pse=perviousSmaller(arr);
        int[]nse=nextSmaller(arr);

        int totalSum=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            //till what given i elemnet is min
            int left_min=i-pse[i];
            int right_min=nse[i]-i;
            totalSum = (int) ((totalSum + (1L * left_min * right_min % mod * arr[i] % mod)) % mod);
        }
        return totalSum;
    }
    private int[] perviousSmaller(int[]arr){
        int n=arr.length;
        int[]pse=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        return pse;
    }
    private int[] nextSmaller(int[]arr){
        int n=arr.length;
        int[]nse=new int[arr.length];
        Stack<Integer> st =new Stack<>();
        nse[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]) st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        return nse;
    }
}