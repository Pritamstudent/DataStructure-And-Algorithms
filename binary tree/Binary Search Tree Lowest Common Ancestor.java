public static Node lca(Node root, int v1, int v2) {
      	// Write your code here.
          Node ans = null;
          while (root!=null){
              if(v1 > root.data && v2 > root.data){
                  root = root.right;
              }
              else if(v1 < root.data && v2 < root.data){
                  root = root.left;
              }
              else{
                  return root;
              }
          }
          return ans;
    }