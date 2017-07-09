package com.backtracking;

import java.util.Arrays;
import java.util.List;

//TODO: complete this object/class

public class PaginationHelper<I> {
private List<I> list = null;
private int itemsPerPage =0;
/**
* The constructor takes in an array of items and a integer indicating how many
* items fit within a single page
*/
public PaginationHelper(List<I> collection, int itemsPerPage) {
 list = collection;
 this.itemsPerPage = itemsPerPage;
}

/**
* returns the number of items within the entire collection
*/
public int itemCount() {
 return list.size();
}

/**
* returns the number of pages
*/
public int pageCount() {
 return  itemCount()% itemsPerPage == 0 ? itemCount()/itemsPerPage : (itemCount()/itemsPerPage) +1 ;
}

/**
* returns the number of items on the current page. page_index is zero based.
* this method should return -1 for pageIndex values that are out of range
*/
public int pageItemCount(int pageIndex) {
 if(pageCount()<=pageIndex || pageIndex < 0)
   return -1;
 if(pageCount() - pageIndex != 1)
   return itemsPerPage;
 return itemCount() % itemsPerPage == 0  ?  itemsPerPage : itemCount() % itemsPerPage;
}

/**
* determines what page an item is on. Zero based indexes
* this method should return -1 for itemIndex values that are out of range
*/
public int pageIndex(int itemIndex) {
   if(itemCount()<=itemIndex || itemIndex < 0)
     return -1;
   itemIndex++;
   return (itemIndex)%itemsPerPage == 0  ? (itemIndex)/itemsPerPage : ((itemIndex)/itemsPerPage) +1;
}
public static void main(String[] args) {
	PaginationHelper<Integer> helper = new PaginationHelper<>(Arrays.asList(1,2,3,4,5), 2);
	System.err.println(helper.itemCount());
	System.err.println(helper.pageCount());
	System.err.println(helper.pageIndex(4));
}
}