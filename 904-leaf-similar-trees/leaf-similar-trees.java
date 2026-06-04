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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();

        preOrder(root1, res1);
        preOrder(root2, res2);
        
        if(res1.equals(res2)) return true;
        else return false;

    }

    public void preOrder(TreeNode node , ArrayList<Integer> res){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            res.add(node.val);
        }
        preOrder(node.left, res);
        preOrder(node.right, res);
    }
}