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
    public TreeNode f(TreeNode root, HashSet<Integer> s,List<TreeNode> res){
        if(root == null)
            return null;
        root.left = f(root.left,s,res);
        root.right = f(root.right,s,res);
        if(s.contains(root.val)){
            if(root.left!= null){
                res.add(root.left);
            }
            if(root.right!= null){
                res.add(root.right);
            }
            s.remove(root.val);
            return null;
        }
        return root;        
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> s = new HashSet();
        List<TreeNode> res = new ArrayList();
        for(int i : to_delete){
            s.add(i);
        }
        if(!s.contains(root.val))
            res.add(root);
        f(root,s,res);
        return res;
    }
}