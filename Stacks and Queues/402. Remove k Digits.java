class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<n;i++){
            while(st.size()>0 && k>0 && (st.peek()-'0')>(num.charAt(i)-'0')){
                st.pop();
                k--;
            }st.push(num.charAt(i));
        }

        while(k>0 && st.size()>0){
            st.pop();
            k--;
        }

        if(st.size()==0) return "0";
        String result="";
        while(st.size()>0){
            result+=st.pop();
        }

        result=reverse(result);
        //leading 0s to be removed
        int i=0;
        while(i<result.length() && result.charAt(i)=='0'){
            i++;
        }
        result = result.substring(i);
        if(result=="") return "0";
        return result;
    }
    private String reverse(String str){
    if (str == null || str.length() == 0) return str;
    String reversed = "";
    for (int i = str.length() - 1; i >= 0; i--) {
        reversed += str.charAt(i);
    }
    return reversed;
}
}