
/**
 * Write a description of class bar_foo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bar_foo
{
   int foo(String x, int number, int[] array){
        number = array.length;
        x = x + "xAtfoo";
        for (int i=0; i < number; i++){
            array[i] = array[i] + x.length();
        }
        x = x + "Success";
        return x.length();
    }

    void bar(){
        String s = new String("Hello");
        int num = 6;
        int [] array = {1, 2, 3, 4};
        int result = 0;
        System.out.println(s + "\t" + num + "\t" +	array[0] + "\t" +	array[1] + "\t" +	array[2] + "\t" +	array[3] + "\t" +	result);
        result = foo(s, num, array);
        System.out.println(s  + "\t" + num + "\t" +	array[0] + "\t" +	array[1] + "\t" +	array[2] + "\t" +	array[3] + "\t" +	result);
    }
}
