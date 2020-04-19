/*
* @Author: adrrrrrrrian
* @Date:   2016-05-12 08:57:32
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-05-12 09:46:47
* @Source: https://leetcode.com/discuss/68352/easiest-java-solution-with-explanation
*/
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if(board.length == 0) return;
        int m = board.length; int n = board[0].length;

        for(int i = 0; i < m; i++){
        	for (int j = 0; j < n; j++) {
        		//actually we don't need to care about 00/01 ->00/01 because by default the second state is 0;
        		int lives = countlives(board, i, j);
        		if(lives >=2&& lives<=3&&board[i][j] == 1){
        			board[i][j] = 3;
        		}
        		if(lives == 3 && board[i][j] == 0){
        			board[i][j] = 2;
        		}
        		
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		board[i][j] >>= 1;
        	}
        }
    }


    public int countlives(int[][] board, int i , int j){
    	int ans = 0;
    	int m = board.length;
    	int n = board[0].length;
    	for (int a = i-1; a < i+2; a++) {
    		for (int b = j-1; b < j+2; b++ ) {
    			if(a>=0&& a<m&&b>=0&&b<n){
    				// we need to use board[][]&1 because in last method we have already set the value to 2 or 3, we only need to see the first bit here
    				ans += board[a][b]&1;
    			}
    		}
    	}
    	ans -= board[i][j]&1;
    	return ans;
    }
}