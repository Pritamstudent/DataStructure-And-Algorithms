class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
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
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        int m =  text1.length();
        int n =  text2.length();
        while(m >0 && n >0){
            if(text1.charAt(m-1) == text2.charAt(n-1)){
                    str.append(text1.charAt(m-1));
                    m--;
                    n--;
                }
            else{
                if(dp[m][n-1] < dp[m-1][n]){
                    str.append(text1.charAt(m-1));
                     m--;           
                }
                else{
                    str.append(text2.charAt(n-1));
                    n--;
                }
              
            }
        }
        if( m > 0){
            while(m>0){
                str.append(text1.charAt(m-1));
                m--;
            }
        }
        else{
            while(n>0){
                 str.append(text2.charAt(n-1));
                  n--;
            }
        }
        str.reverse();
        return str.toString();
    }
}