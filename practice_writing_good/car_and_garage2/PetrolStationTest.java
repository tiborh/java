package car_and_garage2;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fueltank.FuelTank;

/**
 * The test class PetrolStationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PetrolStationTest
{
    /** the fuel tank of the car */
    FuelTank tank;
    /** the car used for tests */
    Car car;
    /** Euro-customised petrol station */
    PetrolStation ps;
    /** The size of the fuel tank in the car (ltr)*/
    double tankSize;
    /** the amount of fuel in the car when created (ltr)*/
    double initFuel;
    /** the consumption of the car (ltr/km) */
    double carCons;
    /** size of increments when filling it up */
    double fillIncr;
    
    /**
     * Default constructor for test class PetrolStationTest
     */
    public PetrolStationTest()
    {
        tankSize = 60;
        initFuel = 10;
        carCons = 0.05;
        fillIncr = 0.01;
    }
 
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        tank = new FuelTank(tankSize,initFuel);
        car = new Car(tank,carCons);
        ps = new PetrolStation(1,2,fillIncr);
    }

    /**
     * Zero Euros to spend
     */
    @Test
    public void testFillEurosZero()
    {
        double remaining = ps.fillEuros(car, 0.0);        
        assertEquals(remaining,0.0,0);
    }
    
    /**
     * large increment
     */
    @Test
    public void testFillEurosLargeIncr()
    {
        ps = new PetrolStation(1,2,50);
        FuelTank tft = car.getTank();
        double remaining = ps.fillEuros(car,100);
        
        assertEquals(remaining,0.0,0);
    }
}
