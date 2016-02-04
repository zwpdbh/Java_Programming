/**
 * Created by wzhao on 2/5/16.
 * Here, the type of a in transform( ) is Double[ ], because Double is specified
 * as the type parameter for MyTransform when sqrts is declared.
 * Therefore, the type of a in the lambda expression is inferred as Double[ ].
 */
public class UseArrayAsParameter {
    public static void main(String[] args) {
        MyTransform<Double> sqrts = a -> {
            for (int i=0; i<a.length; i++) {
                a[i] = Math.sqrt(a[i]);
            }
        };
    }
}

// Notice that the parameter to the transform( ) method is an array of type T.
interface MyTransform<T> {
    void transform(T[] a);
}
