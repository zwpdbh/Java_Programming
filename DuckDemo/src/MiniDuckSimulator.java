/**
 * Created by wzhao on 2/11/16.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        // To change a duck's behavior at runtime, just
        // call the duck's setter method for that behavior.
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
 }
