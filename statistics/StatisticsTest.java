import org.junit.Assert;
import org.junit.Test;

/**
 * StatisticsTest
 * @author Michael
 * @link http://www.wolframalpha.com/input/?i=variance%281%2C+2%2C+3%2C+4%2C+5%2C+6%29&a=*C.variance-_*Variance-
 * @since 8/15/12 7:42 PM
 */
public class StatisticsTest {

    private static final double TOLERANCE = 1.0E-9;

    @Test
    public void testCalculateMean() {
        double [] values = new double[] {
            1.0, 2.0, 3.0, 4.0, 5.0, 6.0
        };
        Statistics stats = new Statistics();
        for (double value : values) {
            stats.addValue(value);
        }
        double expected = 3.5;
        Assert.assertEquals(expected, stats.calculateMean(), TOLERANCE);
    }

    @Test
    public void testCalculateVariance() {
        double [] values = new double[] {
                1.0, 2.0, 3.0, 4.0, 5.0, 6.0
        };
        Statistics stats = new Statistics();
        for (double value : values) {
            stats.addValue(value);
        }
        double expected = 3.5;
        Assert.assertEquals(expected, stats.calculateVariance(), TOLERANCE);
    }


    @Test
    public void testCalculateStandardDeviation() {
        double [] values = new double[] {
                1.0, 2.0, 3.0, 4.0, 5.0, 6.0
        };
        Statistics stats = new Statistics();
        for (double value : values) {
            stats.addValue(value);
        }
        double expected = Math.sqrt(3.5);
        Assert.assertEquals(expected, stats.calculateStandardDeviation(), TOLERANCE);
    }

}
