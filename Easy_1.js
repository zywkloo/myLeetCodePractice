// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
// O(n)
let twoSum = function(nums, target) {
    let map = {}
    let length = nums.length
    for(let i=0;i<length;i++){
        let diff = target-nums[i]
        if(diff in map) {
           return [map[diff],i] 
        }else{
           map[nums[i]] = i
        }
    }
}
