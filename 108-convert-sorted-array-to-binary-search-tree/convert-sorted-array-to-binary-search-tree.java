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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return build(0,nums.length-1,nums);

    }
    private TreeNode build(int l,int r,int[] nums){
        if(l>r)return null;
        int mid=(l+r)/2;
        TreeNode n =new TreeNode(nums[mid]);
        n.left=build(l,mid-1,nums);
        n.right=build(mid+1,r,nums);
        return n ;

         

    }
}