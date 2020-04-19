import java.util.ArrayList;
import java.util.Arrays;

/*
* @Author: Qi Hu
* @Date:   2016-09-07 09:22:28
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-07 09:29:08
* @Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/
public class IntersectionII {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Create an arraylist to store intersection
        ArrayList<Integer> ar = new ArrayList<Integer>();
        //Sort these two arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;
        //See if any array is null
        if (m == 0) {
            return nums1;
        }
        if (n == 0) {
            return nums2;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            

            //Add the element into the arraylist if they are equal in two arrays
            if (nums1[i] == nums2[j]) {
                ar.add(nums1[i]);
                i++;
                j++;
            }else{
                //If they are not equal, then increase the lower array's index
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
        }
        //Convert arraylist to array
        int[] arr = new int[ar.size()];
        for(int k = 0; k < ar.size(); k++) {
            arr[k] = ar.get(k);
        }
        return arr;
    }

    //We can also use hashmap, when there is equality, the value of (key,value) will decrease by 1
}