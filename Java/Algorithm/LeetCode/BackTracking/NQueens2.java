/*
* @Author: adrrrrrrrian
* @Date:   2016-04-14 09:46:23
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-14 11:33:50
* @Source: https://leetcode.com/problems/n-queens-ii/
*/
public class NQueens2 {
    int ans;
    public int totalNQueens(int n) {
    	int[][] large = new int[n][n];
        solve(large, 0, n);
        return ans;
    }
    
    public void solve(int[][] large, int row, int n){
        if(row==n){
        	ans++;
        	return;
        }

        for (int col = 0; col < n ;col++ ) {
        	if(isValid(large, row, col, n)){
        		large[row][col] = 1;
        		solve(large, row+1, n);
        		large[row][col] = 0;
        	}
        }

    }

    public boolean isValid(int[][] large, int row, int col, int n){
    	
    	// check same column
    	for (int i=0; i<row; i++) {
    		if(large[i][col] == 1){
    			return false;
    		}	
    	}
    	// check 45 degree 
    	for(int i = row-1, j = col-1; i >= 0&&j >= 0; i--,j--){
    		if(large[i][j] == 1){
    			return false;
    		}
    	}
    	//check 135 degree
    	for(int i = row-1, j = col+1; i >= 0&&j <= n-1; i--,j++){
    		if(large[i][j] == 1){
    			return false;
    		}
    	}
    	return true;

    }

}