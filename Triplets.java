import java.util.ArrayList;
import java.util.Arrays;

public class Triplets {

    static int Solution(int[] a, int[] b, int[] c) {
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int j_a = 0;
        int j_c = 0;
        int j_b = 0;
        int triplets = 0;
        int count_a = 0;
        int count_c = 0;
        while (j_b < b.length) {
            if (j_b != 0 && b[j_b] == b[j_b - 1]) {
                j_b++;
                continue;
            }
            while (j_a < a.length && a[j_a] <= b[j_b]) {
                if (j_a != 0 && a[j_a] == a[j_a - 1]) j_a++;
                else {
                    j_a++;
                    count_a++;
                }
            }

            while (j_c < c.length && c[j_c] <= b[j_b]) {
                if (j_c != 0 && c[j_c] == c[j_c - 1]) j_c++;
                else {
                    j_c++;
                    count_c++;
                }
            }
            triplets += count_a * count_c;
            j_b++;
        }
        return triplets;
    }

    static int makeDistinct(int[] arr) {
        int[] temp = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) temp[j++] = arr[i];
        }
        for (int i = 0; i < j; i++) arr[i] = temp[i];
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 5};
        int[] b = {2, 3, 3};
        int[] c = {1, 2, 3};
        int res = Solution(a, b, c);
        ArrayList<Integer> x = new ArrayList<>();
        System.out.println(res);
    }
}
