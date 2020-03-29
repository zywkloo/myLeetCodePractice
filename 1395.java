// There are n soldiers standing in a line. Each soldier is assigned a unique rating value.

// You have to form a team of 3 soldiers amongst them under the following rules:

// Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
// A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
// Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).

 

// Example 1:

// Input: rating = [2,5,3,4,1]
// Output: 3
// Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1). 
// Example 2:

// Input: rating = [2,1,3]
// Output: 0
// Explanation: We can't form any team given the conditions.
// Example 3:

// Input: rating = [1,2,3,4]
// Output: 4

class Solution {
    public int numTeams(int[] rating) {
        if (rating.length < 3) return 0;
        
        int N = rating.length;

        TreeSet<Integer> leftSet = new TreeSet<>();
        TreeSet<Integer> rightSet = new TreeSet<>();

        for (int i = N - 1; i >= 0; --i) rightSet.add(rating[i]);

        int res = 0;
        for (int i = 0; i < N; ++i) {
            int r = rating[i];

            rightSet.remove(r);
            res += (leftSet.headSet(r).size() * rightSet.tailSet(r).size());  	// count increase
            res += (leftSet.tailSet(r).size() * rightSet.headSet(r).size());  	// count decrease
            leftSet.add(r);
        }

        return res;
    }
}

// This is O(n^2) solution
// quoting from other source " using .size() on one of the views of the set is O(n), because internally, the implementation doesn't know the size of the subsets (only the size of the complete set), so, in order to compute it, it iterates the whole headset/tailset/subset and counts elements one by one. This is one big limitation of TreeSet/TreeMap, because they can't be used to calculate the lengths of prefix/suffix sets efficiently " see the author comment on the first answer to this question on stackoverflow
// https://stackoverflow.com/questions/52624761/do-java-methods-headset-and-tailset-in-java-class-treeset-work-in-logn-time
// see the second answer here
// https://stackoverflow.com/questions/34427758/treeset-number-of-elements-less-than-a-value-efficiently
