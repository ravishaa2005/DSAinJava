class Solution {
    public int celebrity(int[][] M) {
      int n=M.length;

      Stack<Integer> st=new Stack<>();
      for(int i=0;i<n;i++){
        st.push(i);
      }

      while(st.size()>1){
        int v1=st.pop();
        int v2=st.pop();
        if(M[v1][v2]==0){
            //v1 may be celebrity but v2 for sure is not
            st.push(v1);
        }else if(M[v2][v1]==0){
            //v2 may be celebrity but v1 is not
            st.push(v2);
        }
      }
        if(st.size()==0) return -1;
        int potential=st.pop();
        //row must be 0
        for(int j=0;j<n;j++){
            if(M[potential][j]==1) return -1;
        }
        //col must be 1 except for itself
        for(int i=0;i<n;i++){
            if(i==potential) continue;
            if(M[i][potential]==0) return -1;
        }
      
      return potential;
    }
}