public class ZigZag {

	public static void main(String[] args) {
		int numTiles = 8;
		for(int i=0; i<numTiles;i++){
			for(int j=0; j<numTiles;j++){
				if(i%2==0){
					System.out.print("1");	
				}else if ((i-1)%4==0 && j==numTiles-1){
					System.out.print("1");				
				}else if((i+1)%4==0 && j==0){
					System.out.print("1");	
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}