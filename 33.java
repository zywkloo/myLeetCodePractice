class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
          int mid = start + (end - start) / 2;
          if (nums[mid] == target) return mid;
          else if (nums[mid] >= nums[start]) {
            if (target >= nums[start] && target < nums[mid]) end = mid - 1;
            else start = mid + 1;
          }
          else {
            if (target <= nums[end] && target > nums[mid]) start = mid + 1;
            else end = mid - 1;
          }
        }
        return -1;
  }
//     public int search(int[] nums, int target) {
//         int len=nums.length, min=0, max=len-1,i;
//         if(len ==0 )return -1;
//         if (nums[0]==target) return 0;
//         if (nums[len-1]==target) return len-1;
//         if(target<nums[0]&&target>nums[len-1] )return -1;
        
//         while (min<=max){
//             i=(min +max+1)/2;
//             if (target ==nums[i]) return i;
//             if (nums[0]<=nums[len-1]) {
//                 if (nums[i] <target) min = i+1;
//                 else max =i-1;
//             } else if( target >= nums[0] ){
//                 if (target<nums[i] ||nums[i]<=nums[len-1] ) 
//                     max=i-1;
//                 else if (target > nums[i] ) min=i+1;
//             }else if (target <=nums[len-1]){
//                 if (target>nums[i] ||nums[i]>=nums[0] )
//                     min=i+1;
//                 else if (target < nums[i]) max=i-1;
//             }
//         }
//         return -1;
//     }
}
