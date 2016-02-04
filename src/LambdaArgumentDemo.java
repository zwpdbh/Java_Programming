/**
 * Created by wzhao on 2/5/16.
 */
public class LambdaArgumentDemo {
    static String changeSr(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda Expressions Expand Java";
        String outStr;

        System.out.println("Here is input string: " + inStr);

        outStr = changeSr(str -> (str.replace(" ", "+")), inStr);
        System.out.println("Here is output: " + outStr);

        outStr = changeSr(str -> {
            String result = "";
            char ch;
            for (int i=0; i<str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    result += Character.toLowerCase(str.charAt(i));
                } else {
                    result += Character.toUpperCase(str.charAt(i));
                }
            }

            return result;
        }, inStr);

        System.out.println("Here is output: " + outStr);

    }
}

interface StringFunc {
    String func(String str);
}