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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int sum = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) {
                if (n.left.left == null && n.left.right == null)
                    sum += n.left.val;
                else
                    q.offer(n.left);
            }
            if(n.right!=null)q.offer(n.right);

        }
        return sum;
    }

}
// Every left leaf is counted exactly once.
// Non-leaf left children are explored further.
// Right subtrees are still traversed because they may contain left leaves deeper down.
// No unnecessary processing is done for left leaves that have already been counted.