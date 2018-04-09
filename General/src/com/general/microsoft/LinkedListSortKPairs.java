package com.general.microsoft;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * for JAVA List api..
 * @author MohsinIqbal
 *
 */
public class LinkedListSortKPairs 
{
	static <T extends Comparable<? super T>> void sort(int k, List<T> list) {
	    sort(k, list, null);
	}

	static <T> void sort(int k, List<T> list, Comparator<? super T> comp) {
	    int size = list.size();
	    for (int i = 0; i < size; i += k) {
	        Collections.sort(list.subList(i, Math.min(i + k, size)), comp);
	    }
	}
}