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
    public List<TreeNode> allPossibleBST(int start,int end,HashMap<Pair<Integer,Integer>,List<TreeNode>> map)
    {
        List<TreeNode> result= new ArrayList();
        if(start > end)
        {
            result.add(null);
            return result;
        }
        Pair<Integer,Integer> p = new Pair(start,end);
        if(map.containsKey(p))
        {
            return map.get(p);
        }
        for(int i = start;i<= end;i++)
        {
            List<TreeNode> lefts = allPossibleBST(start,i-1,map);
            List<TreeNode> rights = allPossibleBST(i+1,end,map);
            for(TreeNode left : lefts)
            {
                for(TreeNode right : rights)
                {
                    TreeNode root = new TreeNode(i,left,right);
                    result.add(root);
                }
            }
        }
        map.put(p,result);
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        HashMap<Pair<Integer,Integer>,List<TreeNode>> map = new HashMap();
        return allPossibleBST(1,n,map);
    }
}