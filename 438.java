//438.Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

//The order of output does not matter.

class Solution {
//O(s)
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<p.length();i++){
            map[p.charAt(i) - 'a']++;
        }
    
        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd<s.length()){
		// valid anagram
            if(map[s.charAt(windowEnd) - 'a'] > 0){
                map[s.charAt(windowEnd++) - 'a']--;
			// window size equal to size of P
                if(windowEnd-windowStart ==  p.length()){                    
                    result.add(windowStart);
                }
            }
			// window is of size 0
            else if(windowStart == windowEnd){
                windowStart ++;
                windowEnd ++;
            }
			// decrease window size
            else{
                map[s.charAt(windowStart++) - 'a']++;
            }      
        }
        return result;
    }
    //O(s*26)
    public List<Integer> findAnagrams2(String s, String p) {
     int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();

        int [] pCount = new int[26];
        int [] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
          pCount[(int)(ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
          // add one more letter 
          // on the right side of the window
          sCount[(int)(s.charAt(i) - 'a')]++;
          // remove one letter 
          // from the left side of the window
          if (i >= np) {
            sCount[(int)(s.charAt(i - np) - 'a')]--;
          }
          // compare array in the sliding window
          // with the reference array
          if (Arrays.equals(pCount, sCount)) {
            output.add(i - np + 1);
          }
        }
        return output;
    }
}
