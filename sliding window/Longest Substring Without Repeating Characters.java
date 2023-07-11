class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> map = new HashMap<>();
        // Map will store char as key and value as its freq

        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            char currentChar=s.charAt(j);
			int currentCharVal=map.getOrDefault(s.charAt(j), 0);
			map.put(currentChar, currentCharVal+1);
            if(map.size()==j-i+1){
                max = Math.max(max, j-i+1);
                j++;
            }
            else if(map.size() < j-i+1){
                //duplicate entries
                while( map.size() < j-i+1){
                    int oldval = map.get(s.charAt(i));
                    oldval = oldval -1;
                    if(oldval > 0){
                        map.put(s.charAt(i), oldval);
                    }
                    else{
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;

        }
        
    }
    return max;
}
}