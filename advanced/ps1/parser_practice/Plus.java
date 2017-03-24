package parser_practice;

public class Plus implements IntegerExpression{
    IntegerExpression left;
    IntegerExpression right;
    Plus(IntegerExpression left,IntegerExpression right){
        this.left = left;
        this.right = right;
    }
    public int eval() {
        return left.eval() + right.eval();
    }
    public String toString() {
        return left + "+" + right;
    }
}
