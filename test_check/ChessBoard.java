public class ChessBoard {

	public static void main(String[] args) {
		int numTiles=8;
		for(int i=0; i<numTiles;i++){
			for(int j=0;j<numTiles;j++){
				if((i+j)%2==0){
					System.out.print("0");
				}else{
					System.out.print("1");
				}
			}
			System.out.println();
		}
	}
}