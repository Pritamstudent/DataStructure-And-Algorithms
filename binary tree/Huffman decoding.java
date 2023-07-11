void decode(String s, Node root) {
        StringBuilder st = new StringBuilder();
        Node c = root;
        for(int i = 0 ; i<s.length() ; i++){
            c = s.charAt(i)=='1' ? c.right :c.left;
            if(c.right == null && c.left == null){
                st.append(c.data);
                c = root;
            }
            
        }
        System.out.print(st);
    
    }