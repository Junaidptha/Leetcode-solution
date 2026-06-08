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
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        helper(root.left, true, 1);
        helper(root.right, false, 1);
        return maxLen;
    }

    void helper(TreeNode root, boolean left, int currLen){
        if(root == null) return;
        maxLen = Math.max(currLen, maxLen);
        if(left){
            helper(root.right, false, currLen + 1);
            helper(root.left, true, 1);
        }else{
            helper(root.left, true, currLen + 1);
            helper(root.right, false, 1);
        }
    }
}