/**
 * Created by wzhao on 2/11/16.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior= new Quack();
    }

    public void display() {
        System.out.println("I am a model duck");
    }
}
