class Solution {
    public int countVowelPermutation(int n) {
        long[] vow = new long [5];
        Arrays.fill(vow, 1);
        int  i = 2;
        long MOD = 1000000007;
        while(i<=n){
            long[] temp = new long [5];
            temp[0] = (vow[1]+vow[2]+vow[4])%MOD;
            temp[1] = (vow[0]+vow[2])%MOD;
            temp[2] = (vow[1]+vow[3])%MOD;
            temp[3] = vow[2]%MOD;
            temp[4] = (vow[2]+vow[3])%MOD;
            vow = temp;
            i++;
        }
        return (int)((vow[1]+vow[2]+vow[4]+vow[0]+vow[3])%MOD);
    }
}