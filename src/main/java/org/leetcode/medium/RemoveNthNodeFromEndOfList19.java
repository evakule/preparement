package org.leetcode.medium;

public class RemoveNthNodeFromEndOfList19 {
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

    RemoveNthNodeFromEndOfList19 r = new RemoveNthNodeFromEndOfList19();
    ListNode l  = r.removeNthFromEnd(l1, 2);
    while (l != null) {
      System.out.print(l.val + " ");
      l = l.next;
    }


  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null) {
      return new ListNode().next;
    }

    head = reverseList(head);

    if (n == 1) {
      head = head.next;
      return reverseList(head);
    }

    int counter = 1;
    ListNode curr = head;
    while (curr != null) {
      ListNode prev = curr;
      counter++;
      if (counter == n) {
        curr = curr.next;
        prev.next = curr.next;
        return reverseList(head);
      }
      curr = curr.next;
    }
    return new ListNode();
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

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}