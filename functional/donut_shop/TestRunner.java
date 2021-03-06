package donut_shop;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {    
    /**
     * main test engine
     * @return String
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestDonutShop.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}  	