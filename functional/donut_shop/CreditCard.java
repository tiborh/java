package donut_shop;


public class CreditCard
{
    private final static int[] default_number = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6};
    private final static int[] default_expiry = {1,0};
    private final static String default_name = new String("John Doe");
    private final int number_width = 16;
    private final int expiry_width = 2;
    private int[] number;
    private String name;
    private int[] expiry; // m/y
    public CreditCard(int[] number, int[] expiry, String name) {
        assert(number.length == number_width);
        assert(expiry.length == expiry_width);
        this.number = new int[number_width];
        for (int i = 0; i < number_width; ++i)
            this.number[i] = number[i];
        this.expiry = new int[expiry_width];
        for (int i = 0; i < expiry_width; ++i)
            this.expiry[i] = expiry[i];
        name = new String(name);
    }
    public CreditCard() {
        this(default_number,default_expiry,default_name);
    }
}
