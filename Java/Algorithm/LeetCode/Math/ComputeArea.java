/*
* @Author: Qi Hu
* @Date:   2016-07-03 10:34:37
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-07-03 11:43:40
* @Source: https://leetcode.com/problems/rectangle-area/
*/
class computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D-B)*(C-A);
        int area2 = (G-E)*(H-F);
        int area3 = 0;
        if(C <= E || D <= F || A >= G || B >= H){

        }else{
          	int x = Math.min(G,C)-Math.max(A,E);
        	int y = Math.min(D,H)-Math.max(B,F);      	
        	area3 = x*y;
        }

        return area1+area2-area3;
    }
}