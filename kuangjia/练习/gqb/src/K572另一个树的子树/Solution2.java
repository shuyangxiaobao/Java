package K572另一个树的子树;


//
class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2 ();
        TreeNode s = new TreeNode ( 3 );
//        s.right = new TreeNode ( 1 );
//        s.right.right = new TreeNode ( 1 );
//        s.right.right.left = new TreeNode ( 2 );

        TreeNode t = new TreeNode ( 3 );
//        t.right = new TreeNode ( 1 );
//        t.right.right = new TreeNode ( 1 );
//        t.right.right.left = new TreeNode ( 2 );
        boolean b = solution.isSubtree ( s, t );
        System.out.println (b);
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder str1 = new StringBuilder ();
        StringBuilder str2 = new StringBuilder ();

        traversal ( s ,str1);
        traversal ( t ,str2);
        return str1.toString ().contains ( str2.toString () );
    }


//    后续遍历
//    public void traversal(TreeNode node, StringBuilder builder){
//        if (node == null){
//            builder.append ( "#!" );
//            return;
//        }
//        if (node.left == null){
//            builder.append ( "#!" );
//        } else {
//            traversal ( node.left,builder );
//        }
//        if (node.right == null){
//            builder.append ( "#!" );
//        } else {
//            traversal ( node.right,builder );
//        }
//        builder.append ( node.val ).append ( "!" );
//    }

//    前序遍历
    public void traversal(TreeNode node, StringBuilder builder){
        if (node == null){
            builder.append ( "#!" );
            return;
        }
        builder.append ( "?" ).append ( node.val ).append ( "!" );

        if (node.left == null){
            builder.append ( "#!" );
        } else {
            traversal ( node.left,builder );
        }
        if (node.right == null){
            builder.append ( "#!" );
        } else {
            traversal ( node.right,builder );
        }
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }




}