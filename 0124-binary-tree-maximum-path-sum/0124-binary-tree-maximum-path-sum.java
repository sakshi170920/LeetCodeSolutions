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
    int res = Integer.MIN_VALUE;
    public int sum(TreeNode root){
        int left = 0,right = 0;
        if(root.left != null)
            left = sum(root.left);
        if(root.right != null)
            right = sum(root.right);
        int result = Math.max(root.val, 
        Math.max(Math.max(left,right)+root.val,left+right+root.val));
        res = Math.max(res,result);
        return Math.max(root.val,Math.max(left,right)+root.val);
    }
    public int maxPathSum(TreeNode root) {
        sum(root);
        return res;
    }
}