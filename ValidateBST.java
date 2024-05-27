/** Time Complexity: O(n)
Space Complexity: O(h); h: height of the tree
Approach: During an inorder traversal over BST. Always maintain a previous node and current node. 
After traversing a node, assign current value to previous value and kepp comping with current value. 
If the previous value is higher or equal to current node then return false. Otherwise keep traversing until end of the elements.
In order traversal technique follows left-root-right. 
*/

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
   TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);        
    }

    public boolean helper(TreeNode root){
        if(root == null)  return true;
        boolean left=helper(root.left);        
        if(prev!=null && (root.val<=prev.val)) return false;
        prev=root;
        boolean right=helper(root.right);
        return left && right;
    }
}

/**Time Complexity: O(n)
Space complexity: O(h). h is the height of the tree.
Approach: For a node calculate min and max. Example: Left node will have the value min value as -infinity while the max value of root node.
Similarly right node will have a min value as root node and max value of root to root node. A node value cant be less than min value and greater than max value.
*/

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

    public boolean isValidBST(TreeNode root) {              
       return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer min, Integer max){
        if(node==null) return true;                
        if(min!=null && node.val<=min.intValue()) return false;
        if(max!=null && node.val>=max.intValue()) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);   
    }        
}
