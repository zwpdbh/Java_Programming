/**
 * Created by wzhao on 2/5/16.
 * when a lambda expression uses a local variable from its enclosing scope,
 * a special situation is created that is referred to as a variable capture.
 * In this case, a lambda expression may only use local variables that are effectively final.
 */
public class Capture {
    public static void main(String[] args) {
        // A local variable that can be captured
        int num = 10;

        MyFunc myLambda = n -> {
            // This use of num is OK. It does not modify num
            int v = num + n;
            // However, the following is illege because it attempts to modify the value of num
            // num++
            v++;
            return v;
        };

        System.out.println(myLambda.func(8));

        // The following line would also cause error, because it would remove the effectively final status from num.
        // System.out.println(num++);

    }
}


interface MyFunc {
    int func(int n);
}
