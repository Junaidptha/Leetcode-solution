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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));   

        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long minIndex = q.peek().index; 
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long currIndex = p.index - minIndex;

                if (i == 0) first = currIndex;
                if (i == size - 1) last = currIndex;

                if (p.node.left != null)
                    q.offer(new Pair(p.node.left, 2 * currIndex));

                if (p.node.right != null)
                    q.offer(new Pair(p.node.right, 2 * currIndex + 1));
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
        
    }
    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        } 
    }
}