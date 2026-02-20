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
 class Tuple{
    int lmax;
    int rmin;
    int sum;
    boolean flag;

    public Tuple(int a, int b, int c, boolean d){
        this.lmax = a;
        this.rmin = b;
        this.sum = c;
        this.flag = d;
    }

 }
class Solution {
    int maxSum = 0;
    public Tuple helper(TreeNode root){
        if(root == null){
            return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE,  0, true);
        }
        Tuple left = helper(root.left);
        Tuple right = helper(root.right);
        if(left.flag == true && right.flag == true && root.val > left.lmax && root.val < right.rmin ){
            int currSum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, currSum);
            int maxVal = Math.max(root.val, right.lmax);
            int minVal = Math.min(root.val, left.rmin);

            return new Tuple(maxVal, minVal, currSum,true);
        }
        return new Tuple(0, 0 , 0, false);
    }
    public int maxSumBST(TreeNode root) {
        
        helper(root);
        return maxSum;
    }
}