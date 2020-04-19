import java.util.Arrays;

/*
* @Author: adrrrrrrrian
* @Date:   2016-03-31 16:45:16
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-03-31 17:10:03
*/
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        if(n == 0)return n;
        if(n == 1){
        	if(citations[0] == 0)return 0;
        	else return 1;
        }
        int i = n;
        while(!test(citations, i, n)){
        	i--;
        }
        return i;
    }
    public boolean test(int[] citations, int index, int n){
    	int i = 0;
        while(i < n&&citations[i] < index){
        	i++;
        }
        if(n-i >= index){
        	return true;
        }else{
        	return false;
        }
    }
}