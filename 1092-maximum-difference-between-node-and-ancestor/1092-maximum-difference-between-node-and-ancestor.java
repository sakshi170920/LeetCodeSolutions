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
    public int helper(TreeNode root,int min,int max)
    {
        int left = 0, right = 0;
        min = Math.min(root.val,min);
        max = Math.max(root.val,max);
        if(root.left == null && root.right == null )
        {
            return max-min;
        }
        if(root.left != null)
            left = helper(root.left,min,max);
        if(root.right != null)
            right = helper(root.right,min,max);
        return Math.max(left,right);
        
    }
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,root.val,root.val);
    }
}