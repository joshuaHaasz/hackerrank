import java.util.Arrays;

public class MaxMin {

    static int Solution(int k, int[] arr) {
        Arrays.sort(arr);
        k--;
        int unfairness = arr[k] - arr[0];
        for (int i = 1; k + i < arr.length; i++) {
            int diff = arr[k + i] - arr[i];
            if (diff < unfairness) unfairness = diff;
        }
        return unfairness;
    }

    public static void main(String[] args) {
        int[] arr = {10, 100, 300, 200, 100, 30, 20};
        int res = Solution(3, arr);
        System.out.println(res);
    }
}
