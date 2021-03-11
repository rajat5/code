import java.util.*;

public class GridIllumination {

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] res = new int[queries.length];
        Set<Lamp> set = new HashSet<>();
        Map<Integer,Integer> r = new HashMap<>();
        Map<Integer,Integer> c = new HashMap<>();
        Map<Integer,Integer> d1 = new HashMap<>();
        Map<Integer,Integer> d2 = new HashMap<>();
        for(int i=0;i<lamps.length;i++){
            Lamp l= new Lamp(lamps[i][0],lamps[i][1]);
            set.add(l);
            r.put(l.r,r.getOrDefault(l.r,0)+1);
            c.put(l.c,c.getOrDefault(l.c,0)+1);
            d1.put(l.r-l.c,d1.getOrDefault(l.r-l.c,0)+1);
            d2.put(l.r+l.c,d2.getOrDefault(l.r+l.c,0)+1);
        }
        int[][] adj = {
                {-1,-1},{-1,0},{-1,1},
                {0,-1},{0,0},{0,1},
                {1,-1},{1,0},{1,1}
        };
        for(int i=0;i<queries.length;i++){
            Lamp l= new Lamp(queries[i][0],queries[i][1]);
            if(r.getOrDefault(l.r,0)>0 || c.getOrDefault(l.c,0)>0 ||
                    d1.getOrDefault(l.r-l.c,0)>0 || d2.getOrDefault(l.r+l.c,0)>0){
                res[i] = 1;
            } else {
                res[i] = 0;
            }
            //remove
            for(int j=0;j<adj.length;j++){
                Lamp t = new Lamp(l.r+adj[j][0],l.c+adj[j][1]);
                if(set.contains(t)){
                    r.put(t.r,r.get(t.r)-1);
                    c.put(t.c,c.get(t.c)-1);
                    d1.put(t.r-t.c,d1.get(t.r-t.c)-1);
                    d2.put(t.r+t.c,d2.get(t.r+t.c)-1);
                    set.remove(t);
                }
            }
        }
        return res;
    }
    class Lamp{
        int r,c;
        Lamp(int x,int y){
            r=x;
            c=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lamp lamp = (Lamp) o;
            return r == lamp.r &&
                    c == lamp.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }


    public static void main(String ... args){
        System.out.println(new GridIllumination().gridIllumination(
                5,new int [][]{{0,0},{4,4}},new int[][]{{1,1},{1,0}}
        ));
    }
}
