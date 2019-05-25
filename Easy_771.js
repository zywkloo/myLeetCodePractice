/**
771. Jewels and Stones
Easy
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.


 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
    let set = new Set()
    let count = 0
    for (let jew of J){
        set.add(jew)
    }
    for (let stone of S ){
        if (set.has(stone)){
            count++
        }
    }
    return count
};

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones2 = function(J, S) {
    let count = 0;
    
    for (let s of S) {
        J.indexOf(s) > -1 && count++;
    }
    
    return count;
};

/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones3 = function(J, S) {
    return [...S].reduce((count, stone) => J.includes(stone) ? ++count : count, 0);
};