class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        String keypad[]={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        generate(digits,keypad,"",ans);
        return ans;
    }
    private void generate(String digits,String[] keypad,String current,List<String>ans){
        if(digits.length()==0){
            ans.add(current);
            return;
        }
        int currentnum=digits.charAt(0)-'0';
        String choices=keypad[currentnum];
        for(int i=0;i<choices.length();i++){
            generate(digits.substring(1),keypad,current+choices.charAt(i),ans);
        }
    }
}
