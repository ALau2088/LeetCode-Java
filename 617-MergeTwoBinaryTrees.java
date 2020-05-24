/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/*
 * I: two tree O: one tree, each node sum of each node at same position in each
 * tree C: none E: one node
 */
class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    Stack<TreeNode[]> stack = new Stack<TreeNode[]>();
    // Edge case- t1 root is null
    if (t1 == null) {
      return t2;
    }

    if (t2 == null) {
      return t1;
    }

    stack.push(new TreeNode[] { t1, t2 });
    while (!stack.isEmpty()) {
      TreeNode[] currentNode = stack.pop(); // Can also be written as TreeNode[] currentNode
      // Set val
      if (currentNode[0] != null) {
        if (currentNode[1] != null) {
          currentNode[0].val = currentNode[0].val + currentNode[1].val;
        }
      } else {
        if (currentNode[1] != null) {
          currentNode[0] = currentNode[1];
        }
      }

      // Pre-Order Traversal
      if (currentNode[0].left != null) {
        if (currentNode[1].left != null) {
          stack.push(new TreeNode[] { currentNode[0].left, currentNode[1].left });
        }
      } else {
        if (currentNode[1].left != null) {
          currentNode[0].left = currentNode[1].left;
        }
      }

      if (currentNode[0].right != null) {
        if (currentNode[1].right != null) {
          stack.push(new TreeNode[] { currentNode[0].right, currentNode[1].right });
        }
      } else {
        if (currentNode[1].right != null) {
          currentNode[0].right = currentNode[1].right;
        }
      }
    }
    return t1;
  }
}