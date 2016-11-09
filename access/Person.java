class Person {
    private Wallet w;

    public int getNetWorth() {
        return w.getAmount();
    }

    public boolean isBroke() {
        return w.getAmount() == 0;
    }
}
