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
    public void  flat(TreeNode root,List<Integer> result)
    {
        if(root == null)
        {
            result.add(null);
            return;
        }
        result.add(root.val);
        flat(root.left,result);
        flat(root.right,result);
    }
    public void helper(int n,TreeNode root,boolean[] visited,List<TreeNode> result,
    List<List<Integer>> res)
    {
        boolean flag = true;
        for(int i = 0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                root = insertNode(root,i+1);
                helper(n,root,visited,result,res);
                visited[i] = false;
                root = deleteNode(root,i+1);
                flag = false;
            }
        }
        if(flag == true && root!= null)
        {
            //System.out.println("added in result with root : "+root.val); 
            List<Integer> prev = new ArrayList();
            // if(!result.isEmpty())
            // {
            // flat(result.get(result.size()-1),prev);
            // List<Integer> curr = new ArrayList();
            // flat(root,curr);
            // if(prev.equals(curr))
            //     return;
            // }
            List<Integer> curr = new ArrayList();
            flat(root,curr);
            if(res.contains(curr))
                return;
            res.add(curr);
            TreeNode temp = clone(root);   
            result.add(temp);
        }
    }
    public TreeNode clone(TreeNode root)
    {
        if(root == null)
        return root;
        TreeNode clone = new TreeNode(root.val);
        clone.left = clone(root.left);
        clone.right = clone(root.right);
        return clone;
    }
    public TreeNode insertNode(TreeNode root,int key)
    {
        if(root == null)
        {
            //System.out.println("inserted : "+key);      
            root = new TreeNode(key);
            return root;
        }
        if(key == root.val)
        {
            return root;
        }
        if(key < root.val)
        {
            root.left = insertNode(root.left,key);
        }
        else
        {
            root.right = insertNode(root.right,key);         
        }
        return root;
    }
    public TreeNode smallest(TreeNode root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val > key)
        {
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right,key);
        }
        else
        {     
            //System.out.println("found : "+root.val);      
            //found
            if(root.left == null && root.right == null)
                return null;
            if(root.right == null)
            {
                return root.left;
            }
            TreeNode smallest = smallest(root.right);
            root.val = smallest.val;
            // left will stay same
            root.right = deleteNode(root.right,smallest.val);
        }
        return root;
    }
    public List<TreeNode> generateTrees(int n) {
        boolean[] visited = new boolean[n];
        List<TreeNode> result = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        helper(n,null,visited,result,res);
        return result;
    }
}