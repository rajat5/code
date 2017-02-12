import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by code on 11/2/17.
 */
public class UniqueRowsinBooleanMatrix {

    int convertBinaryToDec(int a[]){
        int number=0;
        for(int i=a.length-1,j=0;i>=0;i--,j++){
            number = number + (1<<j)*a[i];
        }
        return number;
    }
    void printUniqueRowsMap(int mat[][]){
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<mat.length;i++){
            if(hashSet.add(convertBinaryToDec(mat[i]))){
                System.out.println(Arrays.toString(mat[i]));
            }
        }
    }
    void printUniqueRows(int mat[][]){
        printUniqueRowsMap(mat);
    }
    public static void main(String[] args) {
        int m[][] = {
                {1 , 0 , 1 , 1},
                {1 , 0 , 1 , 0},
                {1 , 0 , 1 , 1},
                {0 , 0 , 1 , 1},
                {0 , 0 , 1 , 0},
        };
        new UniqueRowsinBooleanMatrix().printUniqueRows(m);
    }
}
