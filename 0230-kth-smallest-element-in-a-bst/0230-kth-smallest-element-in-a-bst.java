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
    public int inorder(TreeNode root, int k,int[] result)
    {
        int left=0,right=0;
        if(root.left != null)
        {
            left = inorder(root.left,k,result);
            if(left != -1)
                return left;
        }
        result[0]+=1;
        if(k == result[0])
        {
            return root.val;
        }
        if(root.right != null)
        {
            right = inorder(root.right,k,result);
            if(right != -1)
                return right;
        }
        return -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        result[0] = 0; 
        return inorder(root,k,result);
    }
}