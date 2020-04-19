/*
* @Author: adrrrrrrrian
* @Date:   2016-06-14 23:14:06
* @Last Modified by:   adrrrrrrrian
* @Last Modified time: 2016-06-14 23:35:39
* @Source: https://leetcode.com/problems/compare-version-numbers/
*/
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");

        int l = Math.max(a.length, b.length);
        int i = 0;
        int v1 = 0;
        int v2 = 0;
        while (i < l) {
        	v1 = a.length > i ? Integer.parseInt(a[i]):0;
        	v2 = b.length > i ? Integer.parseInt(b[i]):0;
        	if(v1 > v2){
        		return 1;
        	}
        	if(v1 < v2){
        		return -1;
        	}
        	i++;
        }
        return 0;

        
    }
}