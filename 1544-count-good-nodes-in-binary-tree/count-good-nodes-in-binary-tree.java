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
    int count ;
    public int goodNodes(TreeNode root) {
        count = 0;
        if(root == null){
            count = 0;
        }
        int minval = root.val;
        preOrder(root, minval);
        return count;
    }
    public void preOrder(TreeNode root, int maxval){
        if(root == null){
            return;
        }

        if(root.val >= maxval){
            count++;
        }
        maxval = Math.max(root.val, maxval);
        preOrder(root.left, maxval);
        preOrder(root.right, maxval);
    }
}