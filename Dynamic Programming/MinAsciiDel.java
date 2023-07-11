class Solution {
    public int minimumDeleteSum(String text1, String text2) {
        int [][] dp = new int [text1.length()+1][text2.length()+1];
        for(int i = 0 ; i < text1.length() ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i < text2.length() ; i++){
            dp[0][i] = 0;
        }
        for(int i = 1 ; i < text1.length()+1 ; i++ ){
            for( int j = 1; j < text2.length()+1 ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = (int)text1.charAt(i-1) + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int total = 0;
        for(int i = 0 ; i < text1.length() ; i++){
            total+=(int)text1.charAt(i);
        }
        for(int i = 0 ; i < text2.length() ; i++){
            total+=(int)text2.charAt(i);
        }
        return   total - 2*dp[text1.length()][text2.length()];


    }
}