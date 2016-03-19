import comp102x.ColorImage;
import comp102x.Canvas;

public class Lab03
{  
    
    public void loadAnImage() 
    {
        // Please write your code after this line
        ColorImage testimage = new ColorImage();
        Canvas canvas = new Canvas(testimage.getWidth(), testimage.getHeight());
        canvas.add(testimage);
        
        
    }
    
    public void loadTwoImagesOnTheSameCanvas()
    {
        // Please write your code after this line
        ColorImage testimage1 = new ColorImage();
        ColorImage testimage2 = new ColorImage();
        Canvas canvas = new Canvas(2*testimage1.getWidth(), testimage1.getHeight());
        canvas.add(testimage1);
        canvas.add(testimage2,testimage1.getWidth(),0);
        
        
    }
    
    public void imageAddition() 
    {    
        // Please write your code after this line
        ColorImage testimage1 = new ColorImage();
        ColorImage testimage2 = new ColorImage();
        ColorImage testimage3 = testimage1;
        testimage3 = testimage3.add(testimage1,testimage2);
        Canvas canvas = new Canvas(3*testimage1.getWidth()+20, testimage1.getHeight());
        canvas.add(testimage1);
        canvas.add(testimage2,testimage1.getWidth()+10,0);
        canvas.add(testimage3,2*testimage1.getWidth()+20,0);

        
        
        
    }
   
    public void imageMultiplication() 
    {
        // Please write your code after this line
        ColorImage testimage1 = new ColorImage();
        ColorImage testimage2 = new ColorImage();
        ColorImage testimage3 = testimage1;
        testimage3 = testimage3.multiply(testimage1,testimage2);
        Canvas canvas = new Canvas(3*testimage1.getWidth()+20, testimage1.getHeight());
        canvas.add(testimage1);
        canvas.add(testimage2,testimage1.getWidth()+10,0);
        canvas.add(testimage3,2*testimage1.getWidth()+20,0);
        
        
        
        
    }
    
    public void changeColor()
    {
        ColorImage image = new ColorImage();
        image.increaseRed(40);
        Canvas canvas = new Canvas(image.getWidth(), image.getHeight());
        canvas.add(image);
        
        //image.save();
    }
}
