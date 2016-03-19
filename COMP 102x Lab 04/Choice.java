import comp102x.ColorImage;
import comp102x.Canvas; 

/**
 * The Choice class represents a choice made by the player or the computer.
 * It can be either "rock", "paper", or "scissors".
 */
public class Choice
{
    private int type; //stores the choice type: 0=rock, 1=paper, 2=scissors
    private ColorImage choiceImage; //stores the image to be displayed on the canvas
    
    /**
     * The constructor
     * 
     * @param   type   the choice type to be represented by this Choice object
     */
    public Choice(int type)
    {
        //initialize the "type" instance varialble
        this.type = type;
    }
    
    /**
     * Get a number that represents the choice type
     * 
     * @return  a number that represents the choice type: 0=rock, 1=paper, 2=scissors
     */
    public int getType()
    {
        return type;
    }
    
    /**
     * Compare "this" with anotherChoice
     * 
     * @param   anotherChoice   the choice to be compared
     * @return  either 1, -1, or 0 which indicates the comparison result: 1 means "this" wins anotherChoice; -1 means "this" loses to anotherChoice; 0 means "this" and anotherChoice are the same
     */
    public int compareWith(Choice anotherChoice)
    {
        // write your code after this line
        if (this.type == anotherChoice.type) // e.g. rock vs rock
            return 0;
            
        if (this.type + 1 == anotherChoice.type) // e.g. rock (0) vs paper (1)
            return -1;
            
        if (this.type - 1 == anotherChoice.type) // e.g. scissors (2) vs paper (1)
            return 1;
            
        if (this.type + 2 == anotherChoice.type) // rock vs scissors
            return 1;
            
        if (this.type - 2 == anotherChoice.type) // scissors vs rock
            return -1;
            
        return -2;               
    }
    
    /**
     * Draw the choice image (rock/paper/scissors) on the given canvas
     * 
     * @param   canvas      the canvas to draw on
     * @param   x           the x-position of the choice image to be drawn
     * @param   y           the y-position of the choice image to be drawn
     * @param   rotation    the rotation of the choice image to be drawn
     */ 
    public void draw(Canvas canvas, int x, int y, int rotation)
    {
       // write your code after this line
       ColorImage image_to_draw;
       switch(this.type) {
         case 0:
            image_to_draw = new ColorImage("rock.png");
            break;
         case 1:
            image_to_draw = new ColorImage("paper.png");
            break;
         case 2:
            image_to_draw = new ColorImage("scissors.png");
            break;
         default:
            image_to_draw = new ColorImage("wrong.png");
            System.out.println("No choice.");
        }
       image_to_draw.setRotation(rotation);
       canvas.add(image_to_draw,x,y);                                  
    }
}
