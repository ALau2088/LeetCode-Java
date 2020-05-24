/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

/*
 * I: linkedlist O: group odds and even node number linkedlist C: o(1) space E:
 * 
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL
 * 
 * 1->3->5
 * 
 * 2->4
 * 
 * start currentoddnode 1
 * 
 * start currentevennode 2
 * 
 * currentnode
 * 
 * set 1 pointer to 3
 * 
 * set 2 pointer to 4
 * 
 * set 3 to 5
 * 
 * current node is null set current odd node.next to start evennode
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 * 
 * start currentoddnode 2
 * 
 * start currentevennode 1
 * 
 * set currentoddnode.next = 3 set currentoddnode = 3
 * 
 * set currentevennode.next = 5 set currentevennode = 5
 * 
 * 
 * 
 */

// pseudocode ---------------------------------------------
// if head is null return head
// if head.next is null return head
// currentnode number = 3
// set startoddnode = head
// set startevennode = head.next
// set currentoddnode = startoddnode
// set currentevennode = startevennode
// set currentnode = head.next.next
// loop while node is not equal to null
// --if current node number is odd set currentoddnode.next to node
// --if current node number is even est currentevennode.next to node
//
// set currentoddnode.next to startevennode
//
// return head
class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    int currentNumber = 3;
    ListNode startOddNode = head;
    ListNode startEvenNode = head.next;
    ListNode currentOddNode = startOddNode;
    ListNode currentEvenNode = startEvenNode;
    ListNode currentNode = head.next.next;

    while (currentNode != null) {
      if (currentNumber % 2 == 0) {
        currentEvenNode.next = currentNode;
        currentEvenNode = currentEvenNode.next;
      } else {
        currentOddNode.next = currentNode;
        currentOddNode = currentOddNode.next;
      }
      currentNumber += 1;
      currentNode = currentNode.next;
    }

    currentOddNode.next = startEvenNode;
    currentEvenNode.next = null;

    return head;
  }
}