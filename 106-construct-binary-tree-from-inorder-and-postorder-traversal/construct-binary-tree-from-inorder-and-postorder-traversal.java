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
    int postIndex;
    TreeNode helper(int[] postorder, HashMap<Integer, Integer> mp, int l, int r){
        if(l > r) return null;
        int rootVal = postorder[postIndex];
        postIndex--;
        TreeNode root = new TreeNode(rootVal);

        int mid = mp.get(rootVal);
        root.right = helper(postorder, mp, mid+1, r);

        root.left = helper(postorder, mp, l, mid-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            mp.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return helper(postorder, mp, 0, inorder.length - 1);
    }
}