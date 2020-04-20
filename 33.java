// 33. Search in Rotated Sorted Array

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

// Your algorithm's runtime complexity must be in the order of O(log n).

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

class Solution {
  //   public int searchOfficial(int[] nums, int target) {
  //       int start = 0, end = nums.length - 1;
  //       while (start <= end) {
  //         int mid = start + (end - start) / 2;
  //         if (nums[mid] == target) return mid;
  //         else if (nums[mid] >= nums[start]) {
  //           if (target >= nums[start] && target < nums[mid]) end = mid - 1;
  //           else start = mid + 1;
  //         }
  //         else {
  //           if (target <= nums[end] && target > nums[mid]) start = mid + 1;
  //           else end = mid - 1;
  //         }
  //       }
  //       return -1;
  // }
    public int search(int[] nums, int target) {
        int len=nums.length, min=0, max=len-1,i;
        
        while (min<=max){
            i=(min +max+1)/2;
            if (target ==nums[i]) return i;
            if (nums[0]<=nums[len-1]) {
                if (nums[i] <target) min = i+1;
                else max =i-1;
            } else if( target >= nums[0] ){
                if (target<nums[i] ||nums[i]<=nums[len-1] ) 
                    max=i-1;
                else if (target > nums[i] ) min=i+1;
            }else {
                if (target>nums[i] ||nums[i]>=nums[0] )
                    min=i+1;
                else if (target < nums[i]) max=i-1;
            }
        }
        return -1;
    }
}
