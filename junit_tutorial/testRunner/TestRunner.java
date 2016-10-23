package testRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {    
    /**
     * main test engine
     * @return String
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJUnit.class,
                JavaTest.class,
                TestJunit1.class,
                TestJunit2.class,
                TestJunit3.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}  	