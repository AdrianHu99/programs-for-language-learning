public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        if(nums[s] < target){

        }else if(nums[s] > target){
        	while(nums[s] > target){
	        	s = (s+e)/2;
	        }
	        while(nums[s] < target){
	        	s++;
	        }
        }else{

        }
        
	return 0;
        
    }

    public int find(int[] nums, int s, int e){
    	while(s < e){
            while(s < e && nums[s] == nums[e]){
                e--;
            }
        	if(nums[s] < nums[e]){
        		return nums[s];
        	}
        	int mid = (s+e)/2;
            
        	if(nums[mid] >= nums[s]){// why these two can be equal? try [2,1], the mid is actually s so that they are equal and we need to move...
        		s = mid + 1;
        	}else{
        		e = mid;
        	}
        }
        return s;
    }
}