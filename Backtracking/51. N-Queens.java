class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        nqueenPrinting(board,0,ans);
        return ans;
    }
    private void nqueenPrinting(char[][]board,int row,List<List<String>>ans){
        int n=board.length;
        if(row==n){
            //base case
            List<String> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                String s="";
                for(int j=0;j<n;j++){
                    s+=board[i][j];
                }
                l.add(s);
            }
            ans.add(l);
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j]='Q';
                nqueenPrinting(board,row+1,ans);
                board[row][j]='.';
            }
        }
    }
    private boolean isSafe(char[][]board,int row,int col){
        int n=board.length;
        //row check
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q') return false;
        }
        //col check
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q') return false;
        }
        //north east
        int i=row;
        int j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        //south east
        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }
        //south west
        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }
        //north west
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        return true;
    }
}