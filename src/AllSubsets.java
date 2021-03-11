import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        N = 1<<N;
        for(int mask=0;mask<N;mask++){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                int entry = 1<<i;
                if((mask&entry)==entry)
                    list.add(nums[i]);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String ... args){
        new AllSubsets().subsets(new int[]{1,2,3});
    }
}
