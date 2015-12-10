//binary-> decimal: index value*2^distance from right
//decimal -> binary: divide decimal by 2, remainder is rightmost value and recurse quotient

public class Binary implements Comparable{

    private int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_decNum= 0;
	_binNum= "0";
    }
    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum= n;
	_binNum= decToBin(n);
    }
    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_binNum= s;
	_decNum= binToDec(s);
    }
    //accessor
    public int getDec(){
	return _decNum;
    }
    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum+ " Base 2";
    }
    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
	String ans= "";
	while (n != 0){
	    ans= n%2 + ans;
	    n= n/2;
	}
	return ans;
    }
    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	String ans= "";
	if (n< 1)
	    return n+"";
	ans+= decToBinR(n/2)+decToBinR(n % 2);
	return ans;
    }
    /*=====================================
      String binToDec(String) -- converts binary input to base-10
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int _decimal= 0;
	for (int i= 0; i< s.length(); i++){
	    int temp= Integer.parseInt(s.substring(i, i+1));
	    _decimal+= temp* Math.pow(2, s.length()-i-1);
	} 
	return _decimal;
    }
    /*=====================================
      String binToDecR(String) -- converts binary input to base-10, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
	int ans= 0;
	int firstNum= Integer.parseInt(s.substring(0,1));
	if (s.length()==1)
	    return firstNum;
	ans+= firstNum*Math.pow(2, s.length()-1)+binToDecR(s.substring(1));
	return ans;
    }
    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	if (other instanceof Binary)
	    return this._binNum.equals(((Binary)other)._binNum);
	System.out.println("Classes don't match");
	return false;
	    
    }
    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (!(other instanceof Comparable))
	    throw new ClassCastException("\ncompareTo() input not a Comparable");
	if (other == null)
	    throw new NullPointerException("\ncompareTo() has no input");

	if (other instanceof Hexadecimal)
	    return this._decNum- ((Hexadecimal)other).getDec();
	if (other instanceof Binary)
	    return this._decNum- ((Binary)other).getDec();

	System.out.println("Error: compareTo() input is not Binary or Hexadecimal");
	return -100000;
    }
    
    //main method for testing
    public static void main( String[] args ) {
	Comparable test= new Binary(6);
	Comparable test2= new Hexadecimal(5);
	
	System.out.println(test);
	System.out.println(test2);
	System.out.println(test.compareTo(test2));
	/*
	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	*/
    }//end main()

} //end class
