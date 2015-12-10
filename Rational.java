public class Rational implements Comparable{

    //Instance Variables
    private int num;
    private int den;

    //Default Constructor
    public Rational(){
        num = 0;
        den = 1;
    }

    //Overloaded Constructor
    public Rational(int x, int y){
        this();
        if (y==0) {
            System.out.println("Error: undefined.");
        }
        else {
            num = x;
            den = y;
        }
    }

    //accessors
    public int getNum(){
	return num;
    }

    public int getDen(){
	return den;
    }
    //Methods

    //returns Rational as "a/b" (e.g. "1/2")
    public String toString(){
        return num+"/"+den;
    }

    //returns floating value of numerator (typecasted as double) divided by denominator
    public double floatValue(){
        double num2 = num;
        return num2/den;
    }

    //multiplies numerators, multiplies denominators
    public void multiply(Rational R){
        num = num*R.num;
        den = den*R.den;
    }

    //divides numerators, divides denominators
    public void divide(Rational R){
        num = num/R.num;
        den = den/R.den;
    }

    //PHASE II

    //returns gcd of numerator and denominator, Euclidean Algo
    public  int gcd() {
        int ret = 1; int a = num; int b = den;
        if (a==b) {
            ret = a;
        }
        else {
            while (a!=0 && b!= 0) {
                if (a>b) {
                    a = a%b;
                    ret= b;
                }
                else {
                    b=b%a;
                    ret =a;
                }
            }
        }
        return ret;
    }

    //adds two rational objects
    public void add(Rational R){
        num = num*R.den+den*R.num;
        den = den*R.den;
    }

    //substracts two rational objects
    public void subtract(Rational R){
        num = num*R.den-den*R.num;
        den = den*R.den;
    }

    //reduces fraction, using gcd
    public void reduce() {
        int g = gcd();
        num /= g;
        den /= g;
    }

    //PHASE III

    public static int gcd(int num, int den){
        int ret = 1;
        if (num==den) {
            ret = num;
        }
        else {
            while (num!=0 && den!= 0) {
                if (num>den) {
                    num = num%den;
                    ret= den;
                }
                else {
                    den=den%num;
                    ret =num;
                }
            }
        }
        return ret;
    }

    //PHASE IV

    public boolean equals(Rational R){
        if (num/den==R.num/R.den) {
            return true;
        }
        R.reduce();
        if ((num/gcd(num,den))/(den/gcd(num,den))==(R.num/R.den)) {
            System.out.println(num/gcd(num,den));
            return true;
        }
        Rational S = new Rational(num, den);
        if (S.equals(R)) {
            return true;
        }
        else {
            return false;
        }
    }

    public int compareTo( Object other ) {
	if (!(other instanceof Comparable))
	    throw new ClassCastException("\ncompareTo() input not a Comparable");
	if (other == null)
	    throw new NullPointerException("\ncompareTo() has no input");

	if (other instanceof Hexadecimal)
	    return num- ((Hexadecimal)other).getDec()*den;
	if (other instanceof Binary)
	    return num- ((Binary)other).getDec()*den;
	if (other instanceof Rational)
	    return num*((Rational)other).getDen()-((Rational)other).getNum()*den;
	
	System.out.println("Error: compareTo() input is not Binary, Hexadecimal, or Rational");
	return -100000;
    }

    //main method -- Diagnostics
    public static void main(String[] args){
        Rational m = new Rational(1,2);
        Rational n = new Rational(1,3);
	Rational o = new Rational(1,4);
	Rational p = new Rational(1,2);
	System.out.println(n.compareTo(m)+": should return -1");
	System.out.println(n.compareTo(o)+": should return 1");
	System.out.println(n.compareTo(p)+": should return 0");
        System.out.println(n.compareTo(2)+": should return Error then -2");
    }

}//end of class Rational
