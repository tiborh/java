public class switch_test
{
    public switch_test(int score) {
        char grade;
        
        switch(score/10) {
            case 10: grade = 'A';
            case  9: grade = 'A'; break;
            case  8: grade = 'B';
            case  7: grade = 'C';
            case  6: grade = 'C'; break;
            case  5: grade = 'D';
            default: grade = 'F';
        }
        
        System.out.println("grade = " + grade);
    }
    public static void main(String[] args)
    {
        int score = 52;
        switch_test test1 = new switch_test(score);
        
        score = 89;
        switch_test test2 = new switch_test(score);
    }
}
