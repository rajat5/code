import java.util.Random;

public class RotateMat {
    public static void main(String[] args) {
        int matrix[][] = new int[5][5];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                matrix[i][j] = Math.abs(new Random().nextInt())%100;
            }
        }
        printMat(matrix);
        new RotateMat().rotate(matrix);
        printMat(matrix);
    }
    public static void printMat(int[][] m){
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void rotate(int[][] m) {
        int n = m.length;
        for(int left=0;left<n/2;left++){
            int right = n-left-1;
            int top = left;
            int bottom = n-top-1;
            for(int i=0;i<(right-left);i++){
                int topLeft = m[top][left+i];
                m[top][left+i] = m[bottom-i][left];
                m[bottom-i][left] = m[bottom][right-i];
                m[bottom][right-i] = m[top+i][right];
                m[top+i][right] = topLeft;

                /*System.out.printf("%d,%d\n",top,left+i);
                System.out.printf("%d,%d\n",top+i,right);
                System.out.printf("%d,%d\n",bottom,right-i);
                System.out.printf("%d,%d\n",bottom-i,left);
                */
            }
        }
    }
}
