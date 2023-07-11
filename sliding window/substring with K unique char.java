class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int max = 0;
        int i = 0;
        int j = 0;
        Map <Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), 1);
            }
            else{
                int oldval = map.get(s.charAt(j));
                oldval+=1;
                map.put(s.charAt(j), oldval);
            }
            if(map.size() < k){
                j++;
            }
            else if(map.size() == k){
                int tempmax = j-i+1;
                max = Math.max(tempmax,max);
				j++;
            }
            else if(map.size() > k){
                while(map.size() > k){
                    int oldval = map.get(s.charAt(i));
                    oldval-=1;
                    if(oldval>0)
                    map.put(s.charAt(i), oldval);
                    else {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if(map.size() == k){
                int tempmax = j-i+1;
                max = Math.max(tempmax,max);
                }
                j++;
                
            }
            
        }
        return max;
    }
}