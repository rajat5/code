public class SqrtOfNumber {
    public int sqrt(int a) {
        long low =0,high=a;
        while(low<high){
            long mid = (low+high)/2;
            System.out.println(String.format("%d,%d,%d",low,mid,high));
            if(mid*mid==a){
                return (int)mid;
            }
            else if(mid*mid>a){
                high = mid;
            }else{
                low = mid;
            }
            if((low+high)/2==mid){
                return (int)mid;
            }
        }
        return (int)low;
    }

    public double sqrt(double a) {
        double low =0,high=a;
        while(low<high){
            double mid = (low+high)/2;
            System.out.println(low+","+mid+","+high);
            if(mid*mid==a){
                return mid;
            }
            else if(mid*mid>a){
                high = mid;
            }else{
                low = mid;
            }
            if((low+high)/2==mid){
                return mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtOfNumber().sqrt(2147483647));
        System.out.println(new SqrtOfNumber().sqrt((double)2147483647));
        System.out.println(Math.sqrt(2147483647));
    }
}
