/**
 * Created by wzhao on 2/12/16.
 */
public class LN {
    public static double ln(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return ln(n-1) + ln(n-2);
        }
    }
}
