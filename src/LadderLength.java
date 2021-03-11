import java.util.*;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        Queue<String> a = new LinkedList<>();
        Queue<String> b = new LinkedList<>();
        a.add(beginWord);
        visited.add(beginWord);
        if(!set.contains(endWord)){
            return 0;
        }
        int count = 0;
        while(a.size()!=0||b.size()!=0){
            if(a.size()==0){
                a = b;
                b = new LinkedList<>();
                count++;
            }
            String word = a.poll();
            if(word.equals(endWord)){
                return count+1;
            }
            addValidSeq(word,b,set,visited);
        }
        return 0;
    }

    void addValidSeq(String word,Queue<String> b,Set<String> set,Set<String> visited){
        String org = word;
        for(int i=0;i<word.length();i++){
            StringBuilder t = new StringBuilder(org);
            for(int j=0;j<26;j++){
                char c = (char)('a'+j);
                if(c==org.charAt(i)){
                    continue;
                }
                t.setCharAt(i,c);
                String x= t.toString();
                if(set.contains(x) && !visited.contains(x)){
                    b.add(x);
                    visited.add(x);
                }
            }
        }
    }
}
