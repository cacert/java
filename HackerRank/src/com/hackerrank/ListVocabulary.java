package com.hackerrank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

interface VocabularyItf {
    boolean add(String word);
    boolean isPrefix(String prefix);
    boolean contains(String word);
}
public class ListVocabulary implements VocabularyItf {
    private List<String> words = new ArrayList<String>();

    /**
     * Constructor that adds all the words and then sorts the underlying list
     */
    public ListVocabulary(Collection<String> words) {
        this.words.addAll(words);
        Collections.sort(this.words);
    }

    public boolean add(String word) {
        int pos = Collections.binarySearch(words, word);
        // pos > 0 means the word is already in the list. Insert only
        // if it's not there yet
        if (pos < 0) {
            words.add(-(pos+1), word);
            return true;
        }
        return false;
    }

    public boolean isPrefix(String prefix) {
        int pos = Collections.binarySearch(words, prefix) ;
        if (pos >= 0) {
            // The prefix is a word. Check the following word, because we are looking 
            // for words that are longer than the prefix
            if (pos +1 < words.size()) {
                String nextWord = words.get(pos+1);
                return nextWord.startsWith(prefix);
            }
            return false;
        }
        pos = -(pos+1);
        // The prefix is not a word. Check where it would be inserted and get the next word.
        // If it starts with prefix, return true.
        if (pos == words.size()) {
            return false;
        }
        String nextWord = words.get(pos);
        return nextWord.startsWith(prefix);
    }

    public boolean contains(String word) {
        int pos = Collections.binarySearch(words, word);
        return pos >= 0;
    }
    public static void main(String[] args) {
    	ArrayList<String> list = new ArrayList<>();
    	list.add("kasim");
    	list.add("Merve");
    	list.add("Eren");
    	ListVocabulary vocabulary = new ListVocabulary(list);
    	System.err.println(vocabulary.isPrefix("kas"));
    	System.err.println(vocabulary.isPrefix("m"));
		
	}
}

class StringCompareEmp{
	   public static void main(String args[]){
	      String str = "Hello World";
	      String anotherString = "HELL";
	      Object objStr = str;

	      System.out.println( str.compareTo(anotherString) );
	      System.out.println( str.compareToIgnoreCase(anotherString) );
	      System.out.println( str.compareTo(objStr.toString()));
	   }
	}


class MyList extends ArrayList{
	
	public Enumeration enumeration(){
		return new MyEnumeration(iterator());
	}
	class MyEnumeration implements Enumeration{

		Iterator it ;
		public MyEnumeration(Iterator it) {
			this.it=it;
		}
		@Override
		public boolean hasMoreElements() {
			// TODO Auto-generated method stub
			return it.hasNext();
		}

		@Override
		public Object nextElement() {
			return it.next();
		}
		
	}
	
	public static void main(String[] args) {
		MyList myList = new MyList();
		myList.add("kasim");
		Iterator it = myList.iterator();
		while(it.hasNext()){
			System.err.println(it.next());
		}
		Enumeration e = myList.enumeration();
		while(e.hasMoreElements()){
			System.err.println(e.nextElement());
		}
	}
	
}