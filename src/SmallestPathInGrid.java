public class SmallestPathInGrid {
    public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1];
        int v = destination[0];

        String s = "";
        while(k!=0 && h>0 && v>0){
            int options = (int)nCr(h+v-1,v);
            if(options>=k){
                h--;
                s += "H";
            } else{
                v--;
                s += "V";
                k = k - options;
            }
        }
        while(h-->0){
            s += "H";
        }
        while(v-->0){
            s += "V";
        }
        return s;
    }

    long nCr(int a,int b){
        if(a==b){
            return 1;
        }
        return fact(a)/(fact(b)*fact(a-b));
    }

    long fact(int a){
        long res = 1;
        for(int i=2;i<=a;i++){
            res *= i;
        }
        return res;
    }
}
