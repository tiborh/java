/**
 * Pattern selections: 0 1 2, default is 0
 */

public class SelectPattern {
    private static int numTiles = 8;
    private static int selection;
    //private static final int LIGHTUP = 0;
    //private static final int Z_PATTERN = 1;
    //private static final int ZIGZAG_PATTERN = 2;
    //private static int selection = Z_PATTERN; //Change value of "selection"

  public static void main (String[] args){
    if (args.length == 0)
        selection = 0;
    else
        selection = Integer.parseInt(args[0]);
    
    if(selection == 0){
        lightUp(numTiles);
    }else if(selection == 1){
        zPattern(numTiles);
    }else if(selection == 2){
        zigzagPattern(numTiles);
    }else{
        System.out.println("Non valid pattern");
    }
  }

  public static void lightUp(int numTiles){
    for(int i = 0; i < numTiles; i++){
        for(int j = 0;j < numTiles; j++){
            if((i+j)%2 == 0){
                System.out.print("1");
            }else{
                System.out.print("0");
            }
        }
        System.out.println();
        }
    }
  public static void zPattern(int numTiles){
    for(int i = 0; i < numTiles; i++){
        for(int j = 0; j < numTiles; j++){
            if(i == 0 || i == numTiles-1){
                System.out.print("1");  
            }else if (i+j == numTiles-1){
                System.out.print("1");              
            }else{
                System.out.print(" ");
            }               
        }
        System.out.println();
    }
  }

  public static void zigzagPattern(int numTiles){
    for(int i = 0; i < numTiles; i++){
        for(int j = 0; j < numTiles; j++){
            if(i%2 == 0){
                System.out.print("1");  
            }else if ((i-1)%4 == 0 && j == numTiles-1){
                System.out.print("1");              
            }else if((i+1)%4 == 0 && j == 0){
                System.out.print("1");  
            }else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
  }
}