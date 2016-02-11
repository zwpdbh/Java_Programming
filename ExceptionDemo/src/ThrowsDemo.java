/**
 * Created by wzhao on 2/11/16.
 * the prompt( ) method does not handle IOException itself. Instead, it uses a throws clause,
 * which means that the calling method must handle it. In this example,
 * the calling method is main( ), and it deals with the error.
 */
public class ThrowsDemo {
    public static char prompt(String str) throws java.io.IOException {
        System.out.print(str + ": ");
        return (char) System.in.read();
    }

    public static void main(String args[]) {
        char ch;
        try {
            ch = prompt("Enter a letter");
        } catch (java.io.IOException exc) {

            System.out.println("I/O exception occurred.");
            ch = 'X';
        }
        System.out.println("You pressed " + ch);
    }
}
