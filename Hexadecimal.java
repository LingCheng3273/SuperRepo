//James Hua
//APCS1 pd10
//HW43 -- This or That
//2015-12-07

//skeleton file for class Hexadecimal

public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }

    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHex(n);	
    }

    public Hexadecimal( String s ) {
	_hexNum = s;
	_decNum = binToDec(s);	
    }

    public String toString() { 
	return _hexNum;
    }
    
    public static String decToHex( int n ) {
	String retstr = "";
	for ( ; n > 0; n/=16){
	    int hex = n%16;
	    retstr = HEXDIGITS.substring(hex,hex+1)  + retstr;
	}
	return retstr;
    }

    public static String decToHexR( int n ) { 
	String retstr = "";
	if ( n == 0)
	    return "";
	int hex = n%16
	else
	    retstr = decToHexR( n/2 ) + HEXDIGITS.substring(hex,hex+1);
	return retstr;
    }
    
    public static int hexToDec( String s ) {
	int baseten = 0;
	int basepos = 1;
	for ( int x = s.length(); x > 0; x--){
	    baseten += Integer.parseInt(s.substring(x-1,x)) * basepos;
	    basepos *= 2;	   
	}
	return baseten;
    }

    public static int hexToDecR( String s ) { 
	int baseten = 0;
        if (s.length() == 1)
	    baseten += Integer.parseInt(s);
	else
	    baseten += (int)Math.pow(2,s.length()-1)*Integer.parseInt(s.substring(0,1)) + hexToDecR( s.substring(1));
	return baseten;	
    }

    public boolean equals( Object other ) { 
	return (this==other || this.compareTo(other)==0);	    
    }    

    public int compareTo( Object other ) {
	if ( ! ( other instanceof Hexadecimal))
	    throw new ClassCastException("\nMy first error message!" + "compareTo() input not a binary");
	else
	    return (this._decNum - ((Hexadecimal)other)._decNum);
    }


    //main method for testing
    public static void main( String[] args ) {
	Hexadecimal test= new Hexadecimal(0);
	
	/*=========================================	  

	  System.out.println();
	  System.out.println( "Testing ..." );

	  Hexadecimal b1 = new Hexadecimal(5);
	  Hexadecimal b2 = new Hexadecimal(5);
	  Hexadecimal b3 = b1;
	  Hexadecimal b4 = new Hexadecimal(7);

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

	  =========================================*/
    }//end main()

} //end class
