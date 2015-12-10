public class Rational{

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

    /*Original compareTo method
      public int compareTo(Rational R) {
      int dif= num*R.den-R.num*den;
      if (dif > 0){
      return 1;
      }else if(dif < 0){
      return -1;
      } else{
      return 0;
      }
      }*/

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

    //Interface
    public int compareTo(Object o){
	int ret;
	if (this instanceof Rational && o instanceof Rational){
	    int dif= num*((Rational)o).den-((Rational)o).num*den;
	    if (dif > 0){
		ret= 1;
	    }else if(dif < 0){
		ret= -1;
	    } else{
		ret= 0;
	    }
	}else{
	    System.out.println( "Error: Objects are not of the same type");
	    ret= -2;
	}
	return ret;
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
