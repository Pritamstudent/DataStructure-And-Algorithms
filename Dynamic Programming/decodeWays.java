class Solution {
    static int []dp;
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
        return 0;
        dp  = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s, 0);
    }
    static int helper(String s, int ind){
        if(ind == s.length()){
            return 1;
        }
        if(s.charAt(ind) == '0'){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int take = helper(s,  ind+1);
        if(ind <s.length()-1 &&( s.charAt(ind) == '1' || s.charAt(ind) == '2' && s.charAt(ind+1) < '7')){
            take+=helper( s,ind+2);
        }
        return dp[ind] = take;

    }


}