class Solution {
    static Map <Integer, Boolean> safe ; 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List <Integer> ans = new ArrayList<>();
        safe = new HashMap<>();
        for(int i = 0 ; i <graph.length ; i++){
            if(dfs(i,graph)){
                ans.add(i);
            }
        }
        return ans;
    }
    static boolean dfs(int i, int[][]g){
        if (safe.containsKey(i))
        return safe.get(i);
       safe.put(i, false);
        for(int data : g[i]){
            if(dfs(data, g) == false){
                return safe.get(i);
            }
        }
        safe.put(i, true);
        return true;
    }
}