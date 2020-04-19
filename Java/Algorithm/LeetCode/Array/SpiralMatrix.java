import java.util.ArrayList;
import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-22 19:18:34
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-30 19:31:20
* @Source: https://leetcode.com/problems/spiral-matrix/
*/
public class SpiralMatrix{
	public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = matrix.length;
        if(n == 0) return ans;
        int m = matrix[0].length;
        int left = 0; int up = 0;
        int right = m-1;int down = n-1;
        int round = 0;
        while(left <= right && up <= down){
        	//go right
        	for(int k = left; k <= right; k++){
        		ans.add(matrix[up][k]);
        	}
        	up++;
        	//go down
            for(int k = up;k <= down;k++){
                ans.add(matrix[k][right]);
            }
            right--;
            //go left
            if(up <= down){
            	for(int k = right;k >=left;k--){
                	ans.add(matrix[down][k]);
            	}
            	
            }
            down--;
            //go up
            if(left <= right){
            	for(int k = down;k >= up;k--){
	                ans.add(matrix[k][left]);
	            }
	            
            }
            left++;
            
        }
        return ans;
    }
}