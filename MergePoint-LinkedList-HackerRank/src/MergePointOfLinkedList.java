
/*
 * 
 * Given pointers to the head nodes of  linked lists that merge together at some point, find the Node where the two lists merge. 
 * It is guaranteed that the two head Nodes will be different, and neither will be NULL.

In the diagram below, the two lists converge at Node x:

[List #1] a--->b--->c
                     \
                      x--->y--->z--->NULL
                     /
     [List #2] p--->q
Complete the int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) method so that it finds and returns the data value of the Node where the two lists merge.
 */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergePointOfLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode currentA = head1;
        SinglyLinkedListNode currentB = head2;

        while(currentA!=currentB) {

            if(currentA.next==null) {

                currentA=head2;
            }
            else {
                currentA = currentA.next;
            }

            if(currentB.next==null) {

                currentB = head1;
            }
            else {
                currentB =currentB.next;
            }
        }
        return currentB.data;


    }
    
    public static void main(String[] args) {
    	
    	SinglyLinkedListNode node1 = new SinglyLinkedListNode(1);
    	SinglyLinkedListNode node2 = new SinglyLinkedListNode(2);
    	SinglyLinkedListNode node3 = new SinglyLinkedListNode(3);
    	SinglyLinkedListNode node4 = new SinglyLinkedListNode(4);
    	SinglyLinkedListNode node5 = new SinglyLinkedListNode(1);
    	
    	SinglyLinkedListNode node6 = new SinglyLinkedListNode(6);
    	SinglyLinkedListNode node7 = new SinglyLinkedListNode(7);
    	
    	node1.next=node2;
    	node2.next=node3;
    	node3.next=node4;
    	node5.next=node4;
    	node4.next=node6;
    	node6.next=node7;
    	node7.next=null;
    	
   int data = 	findMergeNode(node1 , node5);
  System.out.println(data);
    	
  }

}
