package baserecursion;

/**
 * Created by code on 9/2/17.
 * n queens using backtrack
 */
public class Queens {
    int queenArray[];
    int possibleWaysCount = 0;
    Queens(int i){
        queenArray =  new int[i];
    }
    public static void main(String [] args){
        new Queens(4).allHailTheQueen();
    }
    void allHailTheQueen(){
        placeQueens(0,queenArray.length);
        System.out.println("all possible combinations "+possibleWaysCount+"for board size "+queenArray.length);
    }

    boolean placeQueen(final int r,final int c){
        for(int i=0;i<r;i++){
            if(queenArray[i] == c ||  Math.abs(i-r)==Math.abs(queenArray[i]-c))
                return false;
        }
        return true;
    }
    void placeQueens(final int r,final int n){
        //1. try to place queen for every column
        for(int c=0;c<n;c++){
            if(placeQueen(r,c)){
                queenArray[r] = c;
                // if reached end print
                if(r==n-1){
                    possibleWaysCount++;
                    //System.out.println(Arrays.toString(queenArray));
                }
                //place other queens
                else {
                    placeQueens(r+1,n);
                }
            }
        }
    }
}
