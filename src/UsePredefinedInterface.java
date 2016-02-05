import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Created by wzhao on 2/5/16.
 */
public class UsePredefinedInterface {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (n) -> (n%2) == 0;
        if (isEven.test(4)) System.out.println("4 is even");

        UnaryOperator<Double> unaryOperation = aDouble -> {
            return aDouble * -1;
        };

        System.out.println(unaryOperation.apply(9.0));


    }
}
