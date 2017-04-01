package generic_functional_interface;

/**
 * to illustrate functional programming (generic version)
 * 
 * @author Pierre-Yves Saumont
 * @version 0.1
 */
public interface Function<T1,T2>
{
    /**
     * to implement simple functions
     * 
     * @param  arg    the argument of the function
     * @return        the result of the opertion on arg
     */
    T2 apply(T1 arg);
}
