public class Solution {
    public int minDistance(String text1, String text2) {
        
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for(int i = 0 ; i <= text1.length() ; i++){
            dp[i][0] = i;
        }
        for(int i = 0 ; i <= text2.length() ; i++){
            dp[0][i] = i;
        }
        for(int i = 1 ; i < text1.length()+1 ; i++ ){
            for( int j = 1; j < text2.length()+1 ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    // if same char is found
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }
            }
        }
        if(text1.length() == 0){
            return text2.length();
        }
        else if(text2.length() == 0){
            return text1.length();
        }
        else{
            return dp[text1.length()][text2.length()];
        }
    }
} {
    
}
