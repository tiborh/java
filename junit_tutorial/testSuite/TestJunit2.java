package testSuite;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestJunit2 {

    String message = "Robert";	
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi! Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
    
    @Test
    public void testSalutationMessageNotEqual() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertFalse(message.equals(messageUtil.salutationMessage()));
    }
    
    @Test
    public void testSalutationMessageFail() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}