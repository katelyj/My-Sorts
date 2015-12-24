/*======================================
  class MySorts -- implements various sort methods
  ======================================*/

import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    //returns whether an array is sorted or not
    public static boolean isSorted( ArrayList<Comparable> input) {
	for ( int n = 0 ; n < input.size() - 1 ; n++ ) {
	    if ( input.get(n).compareTo(input.get(n+1)) > 0 ) {
		return false;
	    }
	}
	return true;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for ( int x = 0 ; x < data.size() - 1 ; x++ ) {
	    for ( int i = data.size() - 1 ; i > 0 ; i-- ) {
		if ( data.get(i).compareTo(data.get(i-1)) < 0 ) {
		    Comparable temp = data.get(i);
		    data.set(i,data.get(i-1));
		    data.set(i-1,temp);
		}
	    }
	}
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	// make a copy
	ArrayList input1 = new ArrayList<Comparable>(input.size());
	for ( int c = 0 ; c < input.size() ; c++ ) {
	    input1.add((Comparable)input.get(c));
	}

	// actual sorting
	for ( int x = 0 ; x < input1.size() - 1 ; x++ ) {
	    for ( int i = input1.size() - 1 ; i > 0 ; i-- ) {
		if ( ((Comparable)input1.get(i)).compareTo(input1.get(i-1)) < 0 ) {
		    Object temp = input1.get(i);
		    input1.set(i,input1.get(i-1));
		    input1.set(i-1,temp);
		}
	    }
	}

	return input1;
    }//end bubbleSort -- O(n^2)

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	for ( int n = 0 ; n < data.size() - 1 ; n++ ) {
	    Comparable min = data.get(n);
	    int iMin = n;
	    for ( int i = n ; i < data.size() ; i++ ) {
		if ( data.get(i).compareTo(min) < 0 ) {
		    min = data.get(i);
		    iMin = i;
		}
		Comparable temp = data.get(n);
		data.set(n,min);
		data.set(iMin,temp);
	    }
	}
    }//end selectionSort -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList data = new ArrayList<Comparable>(input.size());
	for ( int x = 0 ; x < input.size() ; x++ ) {
	    data.add((Comparable)input.get(x));
	}

	for ( int n = 0 ; n < data.size() - 1 ; n++ ) {
	    Object min = data.get(n);
	    int iMin = n;
	    for ( int i = n ; i < data.size() ; i++ ) {
		if ( ((Comparable)data.get(i)).compareTo(min) < 0 ) {
		    min = data.get(i);
		    iMin = i;
		}
		Object temp = data.get(n);
		data.set(n,min);
		data.set(iMin,temp);
	    }
	}
	    
        return data;
    }//end selectionSort -- O(n^2)

    //VOID version of BogoSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bogoSortV( ArrayList<Comparable> data ) {
	while ( ! isSorted(data) ) {
	    shuffle(data);
	}
    }//end BogoSprtV -- O(n^infinity)

    //ArrayList-returning BogoSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input ) {
	ArrayList data = new ArrayList(input.size());
	for ( int x = 0 ; x < input.size() ; x++ ) {
	    data.add(input.get(x));
	}
	while ( ! isSorted(data) ) {
	    shuffle(data);
	}
	return data;
    }//endBogoSort -- O(n^infinity)

}
