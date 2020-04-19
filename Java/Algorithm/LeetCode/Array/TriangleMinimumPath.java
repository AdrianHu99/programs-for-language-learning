import java.util.List;

/*
* @Author: adrrrrrrrian
* @Date:   2016-04-15 11:12:33
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-04-19 09:22:52
* @Source: https://leetcode.com/problems/triangle/
*/
public class TriangleMinimumPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0) return 0;
        int[] ans = new int[n];
        for (int i = n-2; i >= 0; i--) {
        	for (int j = 0; j <= i; j++) {
        		int sum = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j);
        		triangle.get(i).set(j,sum);
        	}
        }
        return triangle.get(0).get(0);
    }
}