import java.util.*;
import java.lang.*;

class BombKingdoms {
    class Kingdom{
        public Kingdom(int l, int r) {
            this.l = l;
            this.r = r;
        }
        int l;
        int r;
        @Override
        public String toString() {
            return "Kingdom{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        new BombKingdoms().readInput();
    }
    public void readInput() throws java.lang.Exception{
        java.io.BufferedReader reader = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
        int tries = Integer.parseInt(reader.readLine());
        while (tries-- > 0){
            int noOfKingdoms = Integer.parseInt(reader.readLine());
            List<Kingdom> bombKingdoms = new ArrayList<>();
            while (noOfKingdoms-- >0) {
                String[] input = reader.readLine().split(" ");
                int l = Integer.parseInt(input[0]), r= Integer.parseInt(input[1]);
                bombKingdoms.add(new Kingdom(l, r));
            }
            //System.out.println(bombKingdoms);
            System.out.println(findMinBombs(bombKingdoms));
        }
    }

    public int findMinBombs(List<Kingdom> kingdoms){
        Collections.sort(kingdoms, new Comparator<Kingdom>() {
            @Override
            public int compare(Kingdom o1, Kingdom o2) {
                if(o1.r < o2.r){
                    return -1;
                } else if (o1.r > o2.r){
                    return 1;
                }
                return Integer.compare(o1.l,o2.l);
            }
        });
        if (kingdoms.size()==0){
            return 0;
        }
        //System.out.println(kingdoms);
        int bombs = 1;
        Kingdom kingdom = kingdoms.get(0);
        for(int i=1;i<kingdoms.size();){
            if(kingdoms.get(i).l <= kingdom.r){
                i++;
            } else {
                kingdom = kingdoms.get(i);
                i++;bombs++;
            }
        }
        return bombs;
    }
}
