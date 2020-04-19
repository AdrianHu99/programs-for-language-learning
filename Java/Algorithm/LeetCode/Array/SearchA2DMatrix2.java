/*
* @Author: adrrrrrrrian
* @Date:   2016-04-18 17:31:41
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-18 17:45:43
* @Source: https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

public class SearchA2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n==0)return false;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if(matrix[i][m-1]>=target){
                if(find(matrix[i],target)){
                    return true;
                }
            }
        }
        return false;
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