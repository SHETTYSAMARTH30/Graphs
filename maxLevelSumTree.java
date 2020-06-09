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
    
    int n = 10000;
    int levelSum[] = new int[n];
    
    public int maxLevelSum(TreeNode root) {
        
        inorder(root,1);
        
        int maxIdx = 0;
        for(int i=0;i < n; i++){
            maxIdx = (levelSum[i] > levelSum[maxIdx])?i:maxIdx;
        }
        
        return maxIdx;
    }
    
    public void inorder(TreeNode node,int level){
        
        if(node != null){
            inorder(node.left,level+1);
            levelSum[level]+= node.val;
            inorder(node.right,level+1);
        }
        
    }
}
