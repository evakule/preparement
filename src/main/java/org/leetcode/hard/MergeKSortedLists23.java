package org.leetcode.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


//https://leetcode.com/problems/merge-k-sorted-lists/submissions/1219538171/
public class MergeKSortedLists23 {
  public static void main(String[] args) {
    MergeKSortedLists23 m = new MergeKSortedLists23();

    ListNode[] lists1 = new ListNode[3];
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);
    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);

    lists1[0] = l1;
    lists1[1] = l2;
    lists1[2] = l3;

    ListNode result1 = m.mergeKLists(lists1);
    System.out.println("Test Case 1: " + result1); // Expected output: [1, 1, 2, 3, 4, 4, 5, 6]
  }

  //My solution #2
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

    for (ListNode list : lists) {
      while (list != null) {
        ListNode next = null;
        if (list.next != null) {
          next = list.next;
        }
        list.next = null;
        pq.add(list);
        list = next;
      }
    }

    if (pq.isEmpty()) return null;

    ListNode head = pq.poll();
    ListNode curr = head;

    while (!pq.isEmpty()) {
      curr.next = pq.poll();
      curr = curr.next;
    }
    return head;
  }



  //My solution
//  public ListNode mergeKLists(ListNode[] lists) {
//    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//
//    for (ListNode list : lists) {
//      pq.addAll(unPack(list));
//    }
//
//    if (pq.isEmpty()) return null;
//
//    ListNode head = new ListNode();
//    ListNode curr = head;
//
//    while (!pq.isEmpty()) {
//      curr.val = pq.poll();
//      if (!pq.isEmpty()) {
//        curr.next = new ListNode();
//        curr = curr.next;
//      }
//    }
//    return head;
//  }

//  private List<Integer> unPack(ListNode l) {
//    List<Integer> res = new ArrayList<>();
//
//    while (l != null) {
//      res.add(l.val);
//      l = l.next;
//    }
//
//    return res;
//  }
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
