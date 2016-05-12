package foo;
public class Foo {
    public static int foo(int n){
        if (n < 1){
            return 0;
        } else { 
            return 1 + foo(n / 10);
        }
    }

    public static void main(String[] args){
        if (args.length == 0)
            System.out.println(foo(123));
        else
            for (String s: args)
                System.out.println(foo(Integer.parseInt(s)));
    }
}
