import java.util.ArrayList;
import java.util.HashMap;

public class SherlockValidString {
    static String Solution(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        HashMap<Integer, Integer> freqOfFreq = new HashMap<>();
        for (int f : freq.values()) {
            freqOfFreq.put(f, freqOfFreq.getOrDefault(f, 0) + 1);
        }
        int n = freqOfFreq.size();
//        System.out.println(n);
        if (n <= 1) return "YES";
        if (n > 2) return "NO";
        ArrayList<Integer> keys = new ArrayList<>(freqOfFreq.keySet());
        int maxKey = Math.max(keys.get(0), keys.get(1));
        int minKey = Math.min(keys.get(0), keys.get(1));
        boolean c1 = (maxKey - minKey == 1) && freqOfFreq.get(maxKey) == 1;
        boolean c2 = minKey == 1 & freqOfFreq.get(minKey) == 1;
//        System.out.println(c1);
//        System.out.println(c2);
        if (c1 || c2) return "YES";
        else return "NO";


    }

    public static void main(String[] args) {
        String s = "aabbcd";
//        for (char c : s.toCharArray()) System.out.println(c);
        String res = Solution(s);
        System.out.println(res);
    }
}


