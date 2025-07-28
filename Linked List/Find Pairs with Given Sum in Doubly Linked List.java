class Solution {
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        if(head==null || head.next==null) return ans;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        ListNode tail=temp;
        temp=head;
        while(temp!=tail && temp!=null && tail!=null && temp.val<tail.val){
            if(temp.val+tail.val==target){
                ans.add(Arrays.asList(temp.val,tail.val));
                temp=temp.next;
                tail=tail.prev;
            }
            else if(temp.val+tail.val>target){
                tail=tail.prev;
            }
            else{
                temp=temp.next;
            }
        }
        return ans;
    }
}