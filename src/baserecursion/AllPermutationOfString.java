package baserecursion;

import java.util.Arrays;

/**
 * Created by code on 9/2/17.
 * print all permutations of a string
 *
 * TODO : unique permutations and lexicographic order
 */
public class AllPermutationOfString {
    private char arr[];

    public AllPermutationOfString(char[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        String s  = "abc";
        new AllPermutationOfString(s.toCharArray()).permutation(0,s.length());
    }
    void permutation(int left,final int size){
        if(left == size){
            System.out.println(Arrays.toString(arr));
        }
        else {
            for(int i=left;i<size;i++){
                //fix each character at left position one by one
                swap(i,left);
                permutation(left+1,size);
                //revert change
                swap(i,left);
            }
        }
    }
    void swap(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
