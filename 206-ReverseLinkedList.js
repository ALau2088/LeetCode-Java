/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
I: linkedlist
O: reversed linkedlist
C: none
E: empty list

examples
---------------------
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL


explanation: use three pointers to keep track of the current, prev and next node

psuedocode
---------------------------
set current = head
set prev = null
traverse nodes while current node is not null
    set next = current.next
    set current.next = prev
    set prev = current
    set current = next
    
set head = prev

return head

time: 19min
*/
// time complexity: traverse each node O(n)
// space complexity: 3 pointers O(1)
class Solution {
  public ListNode reverseList(ListNode head) {
      ListNode current = head;
      ListNode prev = null;
      
      
      while (current != null){
          ListNode next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      
      return prev;
  }
}