class Solution {
    static int MOD;
    public int numWays(int steps, int arrLen) {
        MOD = 1000000007;
        arrLen = Math.min(arrLen, steps);
        long [][]dp = new long [steps+1][arrLen+1];
        for(long []row : dp){
            Arrays.fill(row,-1);
        }
        return (int)helper(steps, arrLen,0,dp);
    }
    static long helper(int steps, int len,int ind, long [][]dp){
        if(ind<0 || ind >=len || steps < 0){
            return 0;
        }
        if( steps == 0&&ind == 0 ){
           
            return 1;
        }
        if(dp[steps][ind]!=-1){
            return dp[steps][ind];
        }
        long stay = helper(steps-1,len,ind,dp);
        long left = helper(steps-1,len,ind-1,dp);
        
        long right = helper(steps-1,len,ind+1,dp);
        return dp[steps][ind] = (left+right+stay)%MOD;

    }
}