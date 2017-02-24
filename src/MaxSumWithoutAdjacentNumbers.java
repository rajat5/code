import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by code on 12/2/17.
 */
public class MaxSumWithoutAdjacentNumbers {
    public static void main(String[] args) {
        int N = 5;
        List<Integer> list = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();

        for(int i=0;i<N;i++){
            list.add(Math.abs(new Random().nextInt()%10));
        }

        dp.add(list.get(0));
        if(N>1){
            dp.add(Math.max(dp.get(0),list.get(1)));
        }

        for(int i=2;i<list.size();i++){
            dp.add(Math.max(list.get(i)+dp.get(i-2),dp.get(i-1)));
        }
        System.out.println(list);
        System.out.println(dp.get(N-1));
    }
}
