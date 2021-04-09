package K572另一个树的子树;


//
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution ();
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
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        return issame ( s,t ) || isSubtree ( s.left,t ) || isSubtree ( s.right,t );
    }

    public boolean issame(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.val == 3){
            System.out.println ("12123");
        }
        return (s.val == t.val) && issame ( s.left ,t.left) && issame ( s.right,t.right );
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