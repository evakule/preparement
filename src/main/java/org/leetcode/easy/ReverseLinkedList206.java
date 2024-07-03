package org.leetcode.easy;

//https://leetcode.com/problems/reverse-linked-list/description/
class ReverseLinkedList206 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    ListNode l5 = new ListNode(5);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l5;
    ReverseLinkedList206 r = new ReverseLinkedList206();
    ListNode reversed = r.reverseList(l1);
    System.out.println(reversed.val);
  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;

  }

}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, org.leetcode.easy.ListNode next) {
    this.val = val;
    this.next = next;
  }
}


