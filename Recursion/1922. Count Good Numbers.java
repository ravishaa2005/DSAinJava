class Solution {
    private final int MOD=1000000007;
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;

        long firstAns=power(5,even)%MOD;
        long secondAns=power(4,odd)%MOD;

        return (int)((firstAns*secondAns)%MOD);
    }
    private long power(long p,long q){
        if(q==0) return 1;
        long smallAns=power(p,q/2);
        if(q%2==0){
            return (smallAns*smallAns)%MOD;
        }else{
            return (p*smallAns*smallAns)%MOD;
        }
    }
}