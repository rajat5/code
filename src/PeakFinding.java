/**
 * Created by code on 8/2/17.
 * find a peak in an array
 */
public class PeakFinding {
    //1. a[n-1/2] > a[n] go left
    // 2. go right
    // 3. you are at peak
    int peakFinder(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(low == high){
                return low;
            }

            if(!(mid==0) && arr[mid-1] > arr[mid]){
                high = mid -1;
            }
            else if(!(mid==arr.length-1) && arr[mid] < arr[mid+1]){
                low = mid +1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    int peakFinderWithBaseCaseAsTrue(int arr[]){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(low == high){
                return low;
            }
            else if( ((mid == 0) || arr[mid]>=arr[mid-1]) && ((mid == arr.length-1) || arr[mid]>=arr[mid+1]) ){
                return mid;
            }
            else if(mid != 0 && arr[mid-1]> arr[mid]){
                high = mid -1;
            }
            else if(arr[mid+1]> arr[mid]){
                low = mid +1;
            }
        }
        return -1;
    }
    public static void main(String ... args){
        PeakFinding object = new PeakFinding();
        int a[] = {1};
        System.out.println(a[object.peakFinder(a)]);
        a = new int[]{1,2};
        System.out.println(a[object.peakFinder(a)]);
        a = new int[]{2,1};
        System.out.println(a[object.peakFinder(a)]);
        a = new int[]{1,2,3,5,6,1};
        System.out.println(a[object.peakFinder(a)]);

        int b[] = {1};
        System.out.println(b[object.peakFinderWithBaseCaseAsTrue(b)]);
        b = new int[]{1,2};
        System.out.println(b[object.peakFinderWithBaseCaseAsTrue(b)]);
        b = new int[]{2,1};
        System.out.println(b[object.peakFinderWithBaseCaseAsTrue(b)]);
        b = new int[]{1,2,3,5,6,1};
        System.out.println(b[object.peakFinderWithBaseCaseAsTrue(b)]);
    }
}
