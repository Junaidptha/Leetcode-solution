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
     int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, map, 0, inorder.length - 1);
    }

    TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int l, int r) {
       
        if (l > r) return null;

        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.left = helper(preorder, map, l, mid - 1);
        root.right = helper(preorder, map, mid + 1, r);

        return root;
    }
}