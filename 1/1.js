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