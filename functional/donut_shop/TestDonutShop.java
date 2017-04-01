package donut_shop;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import edu.mit.utils.imlist.*;

/**
 * The test class TestDonutShop.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestDonutShop
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    @Test
    public void testBuyDonuts() {
        CreditCard creditCard = new CreditCard();
        Pair<ImList<Donut>, Payment> purchase = DonutShop.buyDonuts(5, creditCard);
        assertEquals("price check",Donut.price * 5, purchase._2.amount);
        assertEquals("credit card check",creditCard, purchase._2.creditCard);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
