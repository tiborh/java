import comp102x.IO;
/**
 * savings_account is a subclass of bank_account
 * and implements the extensions needed to savings accounts
 */
public class savings_account extends bank_account {
    private double interest_rate;
    
    /**
     * constructor that makes use of the constructor from the super class
     * @param   initial_balance     the initial balance
     * @param   name                the name of the owner of the account
     * @param   rate                the interest rate of the savings account
     */
    public savings_account(double initial_balance, String name, double rate) {
        super(initial_balance,name);
        interest_rate = rate;
    }

    /**
     * a getter method to get the interest rate as a string
     * @return  the interest rate as a string
     */
    public String get_rate_string() {
        return "" + interest_rate;
    }
    
    /**
     * Return data as a concatenated string
     * @return  the owner, the balance, and the interest rate as a string
     */
    public String get_savings_data() {
        return(get_data() + " (" + get_rate_string() + ")");
    }
    
    /**
     * Return data as a concatenated string
     * @param  duration     the number of years the money is on the account
     */
    public void compound_interest(int duration) {
        for(int i = 1; i <= duration; i++) {
            double current_balance = get_balance();
            deposit(current_balance * interest_rate);
        }
    }
    
    /**
     * Change interest rate
     * @param  rate     the new interest rate
     */
    public void set_interest_rate(double rate) {
        interest_rate = rate;
    }
}
