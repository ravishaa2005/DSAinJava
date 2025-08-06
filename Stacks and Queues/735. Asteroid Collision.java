class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(st.isEmpty() || asteroids[i]>0) st.push(asteroids[i]);
            else{
                while(!st.isEmpty()){
                    int modval=Math.abs(asteroids[i]);
                    if(st.peek()<0){//stack peek already has neg element
                        st.push(asteroids[i]);
                        break;
                    }
                    else if(modval==st.peek()){
                        st.pop();
                        break;
                    }else if(modval<st.peek()) break;
                    else{
                        st.pop();
                        if(st.isEmpty()){
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        //now to copy stack to result arr
        int[]result=new int[st.size()];
        int n=st.size();
        for(int i=n-1;i>=0;i--){
            result[i]=st.pop();
        }
        return result;
    }
}