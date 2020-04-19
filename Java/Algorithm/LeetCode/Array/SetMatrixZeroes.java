import java.util.HashSet;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-10 21:42:58
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-10 22:22:55
* @ Source: https://leetcode.com/problems/set-matrix-zeroes/
*/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        int r = matrix.length;
        if(r == 0)return;
        int c = matrix[0].length;
        for(int i = 0;i < r; i++){
        	for(int j = 0; j < c; j++){
        		if(matrix[i][j] == 0){
        			for(int a = 0; a < i; a++){
        				matrix[a][j] = 0;
        			}
        			for(int a = 0; a < j; a++){
        				matrix[i][a] = 0;
        			}
        			row.add(i);
        			col.add(j);
        		}else{
        			if(row.contains(i)){
        				matrix[i][j] = 0;
        			}
        			if(col.contains(j)){
        				matrix[i][j] = 0;
        			}
        		}
        	}
        }
    }
}