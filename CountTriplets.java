import java.util.HashMap;
import java.util.List;

public class CountTriplets {

    static long solution(List<Long> arr, long r) {
        long count = 0;
        HashMap<Long, Long> singlets = new HashMap<>();
        HashMap<Long, Long> doublets = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            // check arr[i] is divisable by r
            double prev = (double) arr.get(i) / r;
            if (prev == Math.floor(prev)) {
                count += doublets.getOrDefault(arr.get(i) / r, 0L);
                doublets.put(arr.get(i), doublets.getOrDefault(arr.get(i), 0L) + singlets.getOrDefault(arr.get(i) / r, 0L));
            }
            singlets.put(arr.get(i), singlets.getOrDefault(arr.get(i), 0L) + 1);
        }
        return count;
    }
}

