package com.general.microsoft;

/**
 * for custom LL
 * @author MohsinIqbal
 * https://stackoverflow.com/questions/49437396/sort-an-integer-linked-list-in-groups-of-k
 *
 */
public class LinkedListSortKPairs2 
{
	static class LinkedListNode {
	    int val;
	    LinkedListNode next;
	}
	
	static LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b){
        LinkedListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val <= b.val){
            result = a;
            result.next = sortedMerge(a.next, b);
        }else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
	
    static LinkedListNode getMiddle(LinkedListNode h){
        if (h == null)
            return h;
        LinkedListNode fastptr = h.next;
        LinkedListNode slowptr = h;
        while (fastptr != null){
            fastptr = fastptr.next;
            if(fastptr!=null){
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
    
	static LinkedListNode mergeSort(LinkedListNode h){
        if (h == null || h.next == null){
            return h;
        }
        LinkedListNode middle = getMiddle(h);
        LinkedListNode nextofmiddle = middle.next;
        middle.next = null;
        LinkedListNode left = mergeSort(h);
        LinkedListNode right = mergeSort(nextofmiddle);
        // Merge the left and right lists
        LinkedListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
	
	static LinkedListNode sort(int k, LinkedListNode list) {
	    LinkedListNode end = list;
	    for (int i = 0; i < k - 1 && end.next != null; i++) {
	        end = end.next; // get end of first group
	    }
	    if (end.next == null) {
	        return mergeSort(list); // if last group, sort and return
	    }

	    LinkedListNode rest = sort(k, end.next); // sort rest of list
	    end.next = null; // split first group from list
	    list = mergeSort(list); // sort first group

	    end = list;
	    while (end.next != null) {
	        end = end.next; // get end of sorted first group
	    }
	    end.next = rest; // rejoin sorted rest of list to sorted first group

	    return list;
	}
	
	static void print(LinkedListNode list) {
		while(list!=null) {
			System.out.print(list.val+"->");
			list=list.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode l1=new LinkedListNode();
		LinkedListNode l2=new LinkedListNode();
		LinkedListNode l3=new LinkedListNode();
		LinkedListNode l4=new LinkedListNode();
		LinkedListNode l5=new LinkedListNode();
		LinkedListNode l6=new LinkedListNode();
		LinkedListNode l7=new LinkedListNode();
		LinkedListNode l8=new LinkedListNode();
		LinkedListNode l9=new LinkedListNode();
		LinkedListNode l10=new LinkedListNode();
		l1.val=4;
		l2.val=8;
		l3.val=3;
		l4.val=9;
		l5.val=1;
		l6.val=3;
		l7.val=6;
		l8.val=7;
		l9.val=5;
		l10.val=2;
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=l6;
		l6.next=l7;
		l7.next=l8;
		l8.next=l9;
		l9.next=l10;
		l10.next=null;
		print(l1);
		System.out.println();
		print(sort(4, l1));
	}
}