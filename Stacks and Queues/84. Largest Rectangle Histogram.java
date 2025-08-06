class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int nse[]=new int[heights.length];
        int pse[]=new int[heights.length];
        int n=heights.length;

        //next smaller element
        nse[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]) st.pop();
            if(st.size()==0) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }

        while(st.size()>0) st.pop();

        //previous smaller element
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]) st.pop();
            if(st.size()==0) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }

        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area=heights[i]*(nse[i]-pse[i]-1);
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}