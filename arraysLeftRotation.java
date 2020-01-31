public class arraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[(i + d) % a.length];
        }
        return arr;
    }

    static void arrPrint(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] res = rotLeft(a, 1);
        arraysLeftRotation.arrPrint(res);
    }
}
