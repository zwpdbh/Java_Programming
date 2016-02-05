/**
 * Created by wzhao on 2/5/16.
 * There is an important feature related to lambda expressions called the method reference.
 * A method reference provides a way to refer to a method without executing it.
 * It relates to lambda expressions because it, too,
 * requires a target type context that consists of a compatible functional interface.
 * When evaluated, a method reference also creates an instance of a functional interface.
 */

// Demonstrate a method reference for a static method

interface IntPredicate {
    boolean test(int n);
}

public class MethodReference {
    static boolean numTest(IntPredicate p, int v) {
        return p.test(v);
    }

    public static void main(String[] args) {
        boolean result;

        // Here, a method reference to isPrime is passed to numTest()
        result = numTest(MyIntPredicates::isPrime, 17);
        if (result) System.out.println("17 is prime.");




        MyIntNum myNum = new MyIntNum(12);
        IntPredicate ip = myNum::isFactor; // A method reference to an instance method
        // Here, the method reference assigned to ip refers to an instance method isFactor( ) on myNum.
        // Thus, when test( ) is called through that reference, as shown here
        result = ip.test(3);
        if (result) System.out.println("3 is a factor of " + myNum.getNum() );

    }
}


/**
 *This class defines three static methods that check an integer against some condition.
 * */
class MyIntPredicates {
    static boolean isPrime(int n) {
        if (n<2) return false;
        for (int i=2; i<=n/i; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isEven(int n) {
        return n%2 == 0;
    }

    static boolean isPositive(int n) {
        return n>0;
    }
}


/**This class stores an int value and defines the instance method isFactor()
 * which returns true if its argument is a factor of the stored value.
 */
class MyIntNum {
    private int v;
    public MyIntNum(int x) {
        v = x;
    }

    int getNum() { return v; }

    boolean isFactor(int n) {
        return (v%n)==0;
    }
}

