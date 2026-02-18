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
    TreeNode global;
    public boolean helper(TreeNode root, int target){
        if(root == null) return false;

        if(root.val == target) return true;
        if(root.val < target) return helper(root.right, target);
        else return helper(root.left, target);
    }
    public boolean find(TreeNode root, int k) {
        if(root == null) return false;
        if (k != ((root.val)*2)  && (helper(global,  k - root.val))) return true;
        return find(root.left,  k) || find(root.right,  k );

    }
    public boolean findTarget(TreeNode root, int k) {
        global = root;
        return find(root, k);

    }
}