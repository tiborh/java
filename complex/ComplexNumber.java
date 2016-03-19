public class ComplexNumber{
    private double real;
    private double imag;
    
    public ComplexNumber(double real, double imag){
        this.real = real;
        this.imag = imag;
    }
    
    // to handle real numbers
    public ComplexNumber(double real){
        this(real,0);
    }
    
    public double getReal(){
        return real;
    }
    
    public double getImag(){
        return imag;
    }
    
    public void print(){
        System.out.println(real+ " + " + imag + "i");
    }
}
