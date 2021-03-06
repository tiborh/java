package ps3;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {    
    /**
     * main test engine
     * @return String
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ProblemOne.class,ProblemThree.class,ProblemFour.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}