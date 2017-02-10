package baserecursion;

import java.util.Arrays;

/**
 * Created by code on 8/2/17.
 * Print all combinations of array [ [] , [] ]
 */
public class ArrayOfArray {
    int res[];
    ArrayOfArray(int size){
        res = new int[size];
    }
    public static void main(String [] args){
        int arr[][] = new int[4][4];
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                arr[i][j] = j;
        new ArrayOfArray(4).arrayofarray(arr,0);

    }
    public void arrayofarray(int arr[][],int index){
        if(index == res.length ){
            System.out.println(Arrays.toString(res));
            return;
        }
        for(int i=0;i<arr[index].length;i++){
            res[index] = arr[index][i];
            arrayofarray(arr,index+1);
        }
    }
}
