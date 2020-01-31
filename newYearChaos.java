public class newYearChaos {
    static void minimumBribes(int[] q) {
        int count = 0;
        boolean chaotic = false;
        for (int i = 0; i < q.length; i++) {
//            System.out.print("\n");
//            System.out.print(q[i] + ": ");
            int diff = q[i] - i - 1;
            if (diff > 2) {
                chaotic = true;
                break;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
//                System.out.print(q[j] + " ");
                if (q[i] < q[j]) {
//                    System.out.println(q[i] + " ");
//                    System.out.print(q[j] + " ");
                    count++;
//                    System.out.print("count = " + count + " ");
                }

            }
        }
        if (chaotic) System.out.println("Too chaotic");
        else System.out.println(count);
    }

    public static void main(String[] args) {
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(q);
    }
}
