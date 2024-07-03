package org.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {
  public static void main(String[] args) {

  }

  public Node copyRandomList(Node head) {
    if (head == null) return null;

    // Map to store original nodes
    // as keys and copied nodes as values
    Map<Node, Node> map = new HashMap<>();

    // First pass: create copies of each node without
    // random pointers and store them in the map
    Node current = head;
    while (current != null) {
      map.put(current, new Node(current.val));
      current = current.next;
    }

    // Second pass: assign next and random pointers
    // for each copied node based on the original list
    current = head;
    while (current != null) {
      Node copy = map.get(current);
      copy.next = map.get(current.next);
      copy.random = map.get(current.random);
      current = current.next;
    }

    return map.get(head); // Return the head of the copied list
  }
}


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

