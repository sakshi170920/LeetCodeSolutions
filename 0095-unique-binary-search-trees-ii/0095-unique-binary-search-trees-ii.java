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
    public List<TreeNode> allPossibleBST(int start,int end)
    {
        List<TreeNode> result= new ArrayList();
        if(start > end)
        {
            result.add(null);
            return result;
        }
        for(int i = start;i<= end;i++)
        {
            List<TreeNode> lefts = allPossibleBST(start,i-1);
            List<TreeNode> rights = allPossibleBST(i+1,end);
            for(TreeNode left : lefts)
            {
                for(TreeNode right : rights)
                {
                    TreeNode root = new TreeNode(i,left,right);
                    result.add(root);
                }
            }
        }
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList();
        return allPossibleBST(1,n);
    }
}