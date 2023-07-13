class Solution {
    public boolean isMatch(String s, String p) {
        boolean [][]dp = new boolean [p.length()+1][s.length()+1];
        for(int i = p.length() ; i>=0 ; i--){
            for(int j = s.length() ; j >= 0 ; j--){
                if(i == p.length() && j == s.length() ){
                    dp[i][j] = true;
                }
                else if(i == p.length()){
                    dp[i][j] = false;
                }
                else if(j == s.length()){
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else {
                    if(p.charAt(i) == '?'){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    }
                    else if(p.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }
}