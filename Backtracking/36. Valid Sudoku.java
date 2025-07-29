class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                char num=board[i][j];
                board[i][j]='.';
                if(isValid(board,i,j,num)==false) return false;
                board[i][j]=num;
            }
        }
        return true;
    }
    private boolean isValid(char[][]board,int row,int col,char num){
        if(row==9) return true;
        //valid row
        for(int j=0;j<9;j++){
            if(board[row][j]==num) return false;
        }
        //valid col
        for(int i=0;i<9;i++){
            if(board[i][col]==num) return false;
        }
        //3x3 matrix
        int sRow=row/3*3;
        int sCol=col/3*3;
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
}