/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 *  report number of meaningful items
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *  add item (at end)
 *  insert item
 *  remove item (while maintaining "left-justification")
 *****************************/

public class SuperArray{
 
    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;

		
    //~~~~~METHODS~~~~~
    //default constructor  initializes 10-item array
    public SuperArray() { 
    	_data = new Comparable[10];
    	_lastPos = -1; //flag to indicate no lastpos yet
    	_size = 0;	
    }

		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() { 
    	String foo = "[";
    	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
    	}
	//shave off trailing comma
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

		
    //double capacity of this SuperArray
    private void expand() { 
	Comparable[] temp = new Comparable[ _data.length * 2];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

		
    //accessor -- return value at specified index
    public Comparable get( int index ) {
    	return _data[index]; }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public Comparable set( int index, Comparable newVal ) {
	Comparable temp= _data[index];
	_data[index]= newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable  newVal ) {
    	//if _data is full, expand the array
    	if (_size == _data.length){
	    expand();
    	}
    	
	set(_lastPos + 1, newVal);
    	//increases _lastPos and _size
    	_lastPos++;
    	_size++;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) { 
    	//checks if there is a meaningful value at index
    	if (index> _lastPos){
	    System.out.println("No meaningful int at index");
    	} else {
	    //If _data is full, increase length of _data
	    if (_size == _data.length) {
		expand();
	    }		
	    //copies everything before index from _data to temp 
	    for (int i = _lastPos; i >= index; i--) {
		_data[i+1]= _data[i];
	    }
	    _data[index]= newVal;
	    _size++;
	    _lastPos++;
	}//end else
	   
    }//end add
    

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
	if (index > _lastPos)
	    System.out.println("No meaningful value at index");
	else {for (int i= index; i < _lastPos; i++){
		_data[i]= _data[i+1];
	    }
	    _size--;
	    _lastPos--;
	}
    }


    //return number of meaningful items in _data
    public int size() { return _size;}


    public int linSearch(Comparable c){
	for (int i=0; i< _size; i++){
	    if (_data[i]==c)
		return i;
	}
	return -1;
    }
    public boolean isSorted(){
	if (_size== 1)
	    return true;
	for (int i = 1; i< _size; i++){
	    if (_data[i].compareTo(_data[i-1])< 0)
		return false;
	}
	return true;
    }
    public static void main( String[] args ) {
	SuperArray test0= new SuperArray();
	Comparable test1= new Binary("10");
	Comparable test2= new Hexadecimal("2");
	Binary test3= null;
	Comparable test4= new Rational(6, 3);
	/*
	System.out.println(test1.compareTo(test2));
	System.out.println(test1.compareTo(test4));
	System.out.println(test2.compareTo(test4));
	System.out.println(test4.compareTo(test2));*/
	/*
	System.out.println(test1);
	System.out.println(test2);
	test0.add(test1);
	test0.add(test2);
	System.out.println(test0);
	System.out.println(test0.get(0).compareTo(test0.get(1)));
	test0.remove(0);
	System.out.println(test0);
	test0.add(test2);
	test0.add(test2);
	System.out.println(test0);
	test0.add(1, test1);
	System.out.println(test0);
	System.out.println(test1.compareTo(test3));*/
	test0.add(test2);
	test0.add(test2);
	test0.add(test1);
	test0.add(test2);
	System.out.println(test0);
	System.out.println(test0.linSearch(test1));
	System.out.println(test0.isSorted());
    }//end main
		
}//end class
