class Solution {
    public int myAtoi(String s) {
        int index=0;
        if(s.length()==0) return 0;
        while(index<s.length() && s.charAt(index)==' '){
            index++;
        }
        if (index == s.length()) return 0;
        int sign=1;
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(s.charAt(index)=='+'){
            sign=1;
            index++;
        }
        return myAtoiRecursion(s,index,0,sign);
    }
    private int myAtoiRecursion(String s,int index,int result,int sign){
        if(index>=s.length() || !Character.isDigit(s.charAt(index))) return result*sign;
        int digit=s.charAt(index)-'0';
        if(result>(Integer.MAX_VALUE-digit)/10){
            return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        result=result*10+digit;
        return myAtoiRecursion(s,index+1,result,sign);
    }
}