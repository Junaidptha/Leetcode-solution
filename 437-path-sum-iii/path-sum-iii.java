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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Long totalSum = 0l;
        return helper(root, targetSum , totalSum) + pathSum(root.left,  targetSum) + pathSum(root.right , targetSum);
    }
    public int helper(TreeNode root, int targetSum , Long sum){
        if(root == null) return 0;
        int count = 0;
        Long currentSum = sum + root.val;
        if(currentSum == (long) targetSum) count++;
        count += helper(root.left , targetSum , currentSum);
        count += helper(root.right , targetSum , currentSum);
        return count;
    }   
}