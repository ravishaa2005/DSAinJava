class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st=new Stack<>();
        //next greater element of nums2
        int n2=nums2.length;
        int[] nextGreater=new int[n2];
        nextGreater[n2-1]=-1;
        st.push(nums2[n2-1]);
        for(int i=n2-2;i>=0;i--){
            while(st.size()>0 && st.peek()<nums2[i]) st.pop();
            if(st.size()==0) nextGreater[i]=-1;
            else nextGreater[i]=st.peek();
            st.push(nums2[i]);
        }

        //now compare nums1 and nums2
        int n1=nums1.length;
        int[] result=new int[nums1.length];

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(nums1[i]==nums2[j]){
                    result[i]=nextGreater[j];
                    break;
                }
            }
        }
        return result;
    }
}