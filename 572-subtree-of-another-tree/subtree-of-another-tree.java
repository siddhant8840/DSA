/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        if (same(root,subRoot))return true; 
        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
        //checks l and r

        
    }
    public boolean same(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;//bcase
         if(p == null || q == null) return false;//fbcase
         if(p.val!=q.val)return false;//identify
          return same(p.left, q.left) &&same(p.right, q.right);//dfs


    }
}