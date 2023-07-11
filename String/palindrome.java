class Solution {
    public String longestPalindrome(String s) {
        // Here, we will handle two  cases
        // One for odd palindrome and other for even palindromes
        String ans = "";
        int len = 0;

        for(int i = 0 ; i < s.length() ; i++){
            int l = i , r = i;
            // handle odd palindrome substrings
            while( l >=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > len){
                    len = r-l+1;
                    ans = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            // handle even palindrome substrings
            l = i;
            r = i +1;
            while( l >=0 && r < s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > len){
                    len = r-l+1;
                    ans = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}