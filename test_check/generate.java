
/**
 * Write a description of class generate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class generate
{
   /** 
     * @param number an int value such that number >= 0
     */
    void generate(int number){
        if (number < 10){
            System.out.println(number);
        } else{
            System.out.print(number%10);
            generate(number/10);
        }
    }

}
