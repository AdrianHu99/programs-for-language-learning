/*
* @Author: adrrrrrrrian
* @Date:   2016-04-12 22:45:30
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-12 23:35:57
* @Source: https://leetcode.com/problems/search-a-2d-matrix/
*/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n == 0)return false;
        int m = matrix[0].length;
        int left = 0;
        int right = n-1;
        if(target < matrix[0][0] || target > matrix[n-1][m-1])return false;
        while(left < right){
        	int middle = (left+right)/2;
        	if(matrix[left][m-1] >= target)return find(matrix[left], target);
        	else{
        		if(matrix[middle][m-1] >= target){
        			right = middle;
        		}else{
        			left = middle + 1;
        		}
        	}
        }
        return find(matrix[left], target);
    }

    public boolean find(int[] array, int target){
    	int n = array.length;
    	int left = 0;
    	int right = n-1;
    	while(left<right){
    		if(array[left] == target)return true;
    		int middle = (left+right)/2;
    		if(array[middle] < target){
    			left = middle +1;
    		}else{
    			right = middle;
    		}
    	}
    	return array[left]==target;
    }
}