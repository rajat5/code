import java.util.Arrays;

public class Pow {

    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        int N = citations.length;
        int h=0;
        for(int i=citations.length-1;i>=0;i--){
            if(N-i<=citations[i]){
                h = Math.max(N-i,h);
            }
        }
        return h;
    }
    public double myPow(double x, long n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = n*-1;
        }
        if(n%2==0){
            return myPow(x*x,n/2);
        } else {
            return x*myPow(x*x,n/2);
        }
    }
    public double myPowIt(double x, long n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            x = 1/x;
            n = n*-1;
        }
        double res = 1;
        while(n>0){
            if(n%2==0){
                x = x*x;
                n = n/2;
            } else {
                res = res*x;
                n = n-1;
            }
        }
        return res;
    }

    public int superPow(int x, int[] b) {
        int n = 1337;
        x = x%n;
        if(b.length==0){
            return x;
        }


        int res = 1;
        int i=0;
        while(i<b.length){
            int j=i;
            int carry=0;
            if(b[b.length-1]%2!=0){
                res = (res*x)%n;
            }
            while(j<b.length){
                int num = carry*10+b[j];
                b[j] = num/2;
                carry = num%2;
                j++;
            }
            x = (x*x)%n;
            if(b[i]==0){
                i++;
            }
        }
        return res;
    }

}
