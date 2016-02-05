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
