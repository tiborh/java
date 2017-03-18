package parser_practice;

public class Number implements IntegerExpression {
    int n;
    Number(Integer n){
        this.n = n;
    }
    public int eval() {
        return n;
    }
    public String toString() {
        return "" + n;
    }
}