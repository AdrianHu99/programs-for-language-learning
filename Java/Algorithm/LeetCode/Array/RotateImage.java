/*
* @Author: adrrrrrrrian
* @Date:   2016-03-30 20:21:06
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-30 20:40:48
* @Source: https://leetcode.com/problems/rotate-image/
*/
public class RotateImage{
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0)return;
        int m = matrix[0].length;//actually m == n
        for(int i = 0; i < n/2;i++){
        	for(int j = 0; j < m; j++){
        		int a = matrix[i][j];
        		matrix[i][j] = matrix[n-1-i][j];
        		matrix[n-1-i][j] = a;
        	}
        }
        for(int i = 0; i < n; i++){
        	for(int j = i+1; j < n; j++){
        		int b = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = b;
        	}
        }

    }
}