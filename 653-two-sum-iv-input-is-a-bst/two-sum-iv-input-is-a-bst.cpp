/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool inorder(TreeNode* root,unordered_set<int> &uset,int k){
        if (root == nullptr) return false;

        if (uset.count(k - (root -> val))) return true;
        uset.insert(root -> val);

        bool left = inorder(root -> left,uset,k);
        bool right = inorder(root -> right,uset,k);

        return (left || right);
    }

    bool findTarget(TreeNode* root, int k) {
        
        unordered_set<int> uset;
        return inorder(root,uset,k);
    }
};