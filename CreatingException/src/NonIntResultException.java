/**
 * Created by wzhao on 2/11/16.
 */
public class NonIntResultException extends Exception{
    int n;
    int a;

    public NonIntResultException(int n, int a) {
        this.n = n;
        this.a = a;
    }

    public String toString() {
        return "Result of " + n + " / " + a + " is non-integer.";
    }
}
