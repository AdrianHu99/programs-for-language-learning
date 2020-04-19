/*
* @Author: adrrrrrrrian
* @Date:   2016-03-30 19:31:50
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-30 20:06:50
*/

public class SpiralMatrix2{
	public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        if(n == 0)return ans;
        if(n == 1){
            ans[0][0] = 1;
            return ans;
        }
        int index = 1;
        int rowb = 0;
        int colb = 0;
        int cole = n-1;
        int rowe = n-1;
        while(index <= n*n){

            // go right
            for(int i = colb; i <= cole; i++){
                ans[rowb][i] = index++;
            }
            rowb++;

            //go down
            for(int i = rowb; i <= rowe; i++){
                ans[i][cole] = index++;
            }
            cole--;

            //go left 
            if(ans[rowe][cole] ==0){
                for(int i = cole; i >= colb;i--){
                    ans[rowe][i] = index++;
                }
                rowe--;
            }

            //go up
            if(ans[rowe][colb] == 0){
                for(int i = rowe; i >= rowb; i--){
                    ans[i][colb] = index++;
                }
                colb++;
            }
            
        }
        return ans;
    }
}