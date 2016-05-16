package calculator;

public class Calculator {

    private int result;

    public void add(int n)
    {
        result += n;
    }

    public void subtract(int n)
    {
        result -= n;
    }

    public void square(int n)
    {
        result = n*n;
    }

    public int getResult()
    {
        return result;
    }

}

