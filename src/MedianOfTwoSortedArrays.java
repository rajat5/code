import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by code on 23/2/17.
 */
public class MedianOfTwoSortedArrays {

    //median by merging
    int median(int arr[]){
        if(arr==null)
            return Integer.MIN_VALUE;
        int mid = (arr.length-1)/2;
        if(arr.length%2 == 0){
            return (arr[mid]+arr[mid+1])/2;
        }
        return arr[mid];
    }
    int medianUsingMerge(int a1[],int a2[]){
        if(a1==null || a1.length==0)
            return median(a2);
        if(a2==null || a2.length==0)
            return median(a1);

        int arr[] = new int[a1.length+a2.length];
        int i=0,i1 = 0,i2 = 0;
        while(i1<a1.length && i2<a2.length){
            if(a1[i1]<=a2[i2])
                arr[i++] = a1[i1++];
            else
                arr[i++] = a2[i2++];
        }

        for(;i2<a2.length;){
                arr[i++] = a2[i2++];
        }
        for(;i1<a1.length;){
            arr[i++] = a1[i1++];
        }

        return median(arr);
    }

    //median by dividing, these things can overflow make sure to keep check
    int medianOf4(List<Integer> list1,List<Integer> list2){
        return (Math.max(list1.get(0),list2.get(0))+Math.min(list1.get(1),list2.get(1)))/2;
    }
    int medianList(List<Integer> list){
        int n = list.size();
        if(n%2 != 0){
            return list.get(n/2);
        }
        return (int)(( (long)list.get(n/2)+(long)list.get(n/2-1))>>>1);
    }
    int medianByDivide(List<Integer> list1,List<Integer> list2){
        if(list1==null|| list2==null|| list1.size()==0)
            return Integer.MIN_VALUE;
        if(list1.size()!=list2.size()){
            return Integer.MAX_VALUE;
        }

        int n = list1.size();
        if(n==1)
            return (list1.get(0)+list2.get(0))/2;
        if(n==2)
            return medianOf4(list1,list2);
        int m1 = medianList(list1);
        int m2 = medianList(list2);
        if(m1==m2)
            return m1;

        if(m1<m2) {
            if (n % 2 != 0)
                return medianByDivide(list1.subList(n/2, n ), list2.subList(0, n/2 +1));
            return medianByDivide(list1.subList(n/2-1, n ), list2.subList(0, n/2+1));
        }
        else {
            if(n%2 != 0)
                return medianByDivide(list1.subList(0, n/2 +1),list2.subList(n/2, n ));
            return medianByDivide(list1.subList(0, n/2+1),list2.subList(n/2-1, n ));
        }
    }
    public static int[] combineArray(int a1[],int a2[]){
        int an[] = new int[a1.length+a2.length];
        int i=0,j=0;
        while (j<a1.length)
            an[i++] = a1[j++];
        j=0;
        while (j<a2.length)
            an[i++] = a2[j++];
        return an;
    }
    public static void main(String[] args) {
        {
            int a1[] = {1,2,3,5,7};
            int a2[] = {4,5,6,7,8};
            System.out.println(new MedianOfTwoSortedArrays().medianUsingMerge(a1,a2));
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            for(int i:a1)
                l1.add(i);
            for(int i:a2)
                l2.add(i);
            System.out.println(new MedianOfTwoSortedArrays().medianByDivide(l1,l2));
        }
        {
            int size = 1008;
            int maxSize = Integer.MAX_VALUE;
            int a1[] = new int[size];
            int a2[] = new int[size];
            for(int i=0;i<size;i++){
                a1[i] = Math.abs(new Random().nextInt()%maxSize);
                a2[i] = Math.abs(new Random().nextInt()%maxSize);
            }
            Arrays.sort(a1);
            Arrays.sort(a2);
            int array[] = combineArray(a1,a2);
            Arrays.sort(array);
            System.out.println(new MedianOfTwoSortedArrays().median(array));
            System.out.println(new MedianOfTwoSortedArrays().medianUsingMerge(a1,a2));
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            for(int i:a1)
                l1.add(i);
            for(int i:a2)
                l2.add(i);
            System.out.println(new MedianOfTwoSortedArrays().medianByDivide(l1,l2));
        }

    }
}
