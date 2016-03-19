public class int_div_recursive
{
    /**
     * Returns an array with the quotient and remainder of the
     * integer division
     *
     * @param dividend a positive int
     * @param divisor a positive int
     */
    static int[] division(int dividend, int divisor){

	    int result[] = {0, dividend};
	
	    if ( dividend < divisor ){
	        return result;
	    }else{
	        int tmp[] = division(dividend - divisor,divisor);
	        result[0] = 1 + tmp[0];
	        result[1] = tmp[1];
	    
	        return result;
	    }
	
    }

    public static void main(String[] args){
	    int result[]=division(13,3);
	    System.out.println("Quotient: "+ result[0]
			   + " Remainder: "+ result[1]);
    }
}
