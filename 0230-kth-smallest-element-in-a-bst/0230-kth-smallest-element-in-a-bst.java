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
    int count = 0;
    public int inorder(TreeNode root, int k)
    {
        int left=0,right=0;
        if(root.left != null)
        {
            left = inorder(root.left,k);
            if(left != -1)
                return left;
        }
        count++;
        if(k == count)
        {
            return root.val;
        }
        if(root.right != null)
        {
            right = inorder(root.right,k);
            if(right != -1)
                return right;
        }
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root,k);
    }
}