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
 * Create even head pointer
 * 
 * start currentoddnode 1
 * 
 * start currentevennode 2
 * 
 * set odd pointer to 3
 * 
 * set odd pointer to 4
 * 
 * set odd to 5
 * 
 * set even pointer to null
 * 
 * repeat while even node is not null and even.next is not null
 * 
 * set odd pointer to even head pointer
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
 * pseudocode ---------------------------------------------
 * 
 * create pointers for even head, current odd and current even
 * 
 * while current even and current even next nodes are not null set next
 * currentOddNode set next currentEvenNode
 * 
 * set last odd node to point to even head return head
 */
class Solution {
  public ListNode oddEvenList(ListNode head) {
    if (head == null)
      return head;
    ListNode startEvenNode = head.next, currentOddNode = head, currentEvenNode = startEvenNode;

    while (currentEvenNode != null && currentEvenNode.next != null) {
      currentOddNode.next = currentEvenNode.next;
      currentOddNode = currentOddNode.next;
      currentEvenNode.next = currentOddNode.next;
      currentEvenNode = currentEvenNode.next;
    }

    currentOddNode.next = startEvenNode;
    return head;
  }
}