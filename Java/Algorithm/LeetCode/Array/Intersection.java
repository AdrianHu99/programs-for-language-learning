import java.util.ArrayList;
import java.util.Arrays;

/*
* @Author: Qi Hu
* @Date:   2016-09-06 11:00:50
* @Last Modified by:   Qi Hu
* @Last Modified time: 2016-09-07 09:18:11
* @Source: https://leetcode.com/problems/intersection-of-two-arrays/
*/
public class Intersection {
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
            //Try to avoid duplicates
            while (i+1 < m && nums1[i] == nums1[i+1]) {
                i++;
            }
            while (j+1 < n && nums2[j] == nums2[j+1]) {
                j++;
            }
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

    //We can also use hashset(https://discuss.leetcode.com/topic/45685/three-java-solutions)
}