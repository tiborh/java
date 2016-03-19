import comp102x.IO;
/**
 * Checking account charges a fee for each withdrawal
 * deposits are free
 */
public class checking_account extends bank_account {
    // instance variables - replace the example below with your own
    private double per_cheque_fee = 0.01;

    /**
     * constructor that makes use of the constructor from the super class
     * @param   initial_balance     the initial balance
     * @param   name                the name of the owner of the account
     * @param   fee                 the interest rate of each withdrawal
     */
    public checking_account(double initial_balance, String name, double fee) {
        super(initial_balance,name);
        per_cheque_fee = fee;
    }

    /**
     * Add deposited amount to balance
     * @param   withdrawn      the withdrawn amount
     */
    public void withdraw(double withdrawn) {
        super.withdraw(withdrawn + per_cheque_fee);
    }
}
