class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> prices;
    public StockSpanner() {
        st=new Stack<>();
        prices=new ArrayList<>();
    }
    
    public int next(int price) {
        prices.add(price);
        int prevGreater;
        //previous greater element index-current index
        while(st.size()>0 && prices.get(st.peek())<=price) st.pop();
        if(st.size()==0) prevGreater=-1;
        else prevGreater=st.peek();
        int currentIndex=prices.size()-1;
        int result=currentIndex-prevGreater;
        st.push(currentIndex);
        return result;
    }
}
