/**
 * Created by wzhao on 2/12/16.
 */
public class Mys {
    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b % 2 == 0) {
            return mystery(a+a, b/2);
        }

        return mystery(a+a, b/2) + a;
    }
}
