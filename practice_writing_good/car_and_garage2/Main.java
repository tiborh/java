package car_and_garage2;

import fueltank.FuelTank;

/**
 * Meant to be an Integration Test module
 */
public class Main
{
    /**
     * Integration test to check working of FuelTank, Car, GasStation modules.
     * Results are printed out, for visual check.
     * 
     * @attrib argv unused
     */
    public static void main(String[] argv)
    {
        FuelTank tank = new FuelTank(40, 15);
        Car car = new Car(tank, 0.09);
        GasStation gs = new GasStation(0.8,1.0);
        double km = 250.0;
        double kmsB4Refill = car.travel(km);
        System.out.println(" Kilometers to travel: expected not 0, obtained: " + kmsB4Refill);
        System.out.println(" Cost of refill: " + gs.refuel(car, kmsB4Refill));
        PetrolStation ps = new PetrolStation(1,2,0.01);
        ps.fillEuros(car, 100);
    } 
}