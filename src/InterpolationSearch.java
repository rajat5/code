import java.util.*;

/**
 * Created by code on 15/2/17.
 */
public class InterpolationSearch {
    static int search(Integer arr[],int key){
        int low = 0;
        int high = arr.length-1;

        // additional checks needed
        // or it will try to interpolate outside array
        while (low<=high && arr[low]<=key && arr[high]>=key){
            //interpolate y -> f(x)
            // (y - f[low])/(f[high] - f[low]) = (x - low) / (high - low)
            int mid = low + (int)( (((double)(high-low))/(arr[high]-arr[low]))*(key - arr[low]));

            if(arr[mid]==key)
                return mid;
            else if(arr[mid]<key)
                low = mid +1;
            else
                high = mid - 1;
        }
        return -1;
    }
    static List<Integer> generateNumbers(int size){
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<size;i++){
            al.add(Math.abs(new Random().nextInt()));
        }
        Collections.sort(al);
        return al;
    }
    public static void main(String[] args) {
        int size = 10000000;
        Integer a[] = InterpolationSearch.generateNumbers(size).toArray(new Integer[size]);
        int index = Math.abs(new Random().nextInt()) % size;
        System.out.println("item present at " + index + " :" + a[index]);
        System.out.println(InterpolationSearch.search(a, a[index])==index);
    }

}
