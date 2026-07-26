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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;
        Stack<TreeNode> st =new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode tn= st.pop();
            int n =tn.val;
            list.add(n);
            if(tn.right!=null)st.push(tn.right);
             if(tn.left!=null)st.push(tn.left);


        }
        return list; 

        
    }
}