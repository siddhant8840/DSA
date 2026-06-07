import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node provided by LeetCode.
 */
class TreeNode {
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

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to map node values to actual TreeNode references
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to track all nodes that are children
        Set<Integer> childrenSet = new HashSet<>();

        // 1. Process all structural relationships
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            // Ensure parent node exists
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            // Ensure child node exists
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parentNode = nodeMap.get(parentVal);
            TreeNode childNode = nodeMap.get(childVal);

            // Establish the child link
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Track this child value
            childrenSet.add(childVal);
        }

        // 2. Identify the true root node
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            // The root node is a parent that is never anyone's child
            if (!childrenSet.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }

        return null;
    }
}
