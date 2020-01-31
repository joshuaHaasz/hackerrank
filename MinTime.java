import java.util.Arrays;

public class MinTime {

    static long Solution(long[] machines, long goal) {
        Arrays.sort(machines);
        long dMax = goal * machines[machines.length - 1] / machines.length + 1;
        long dMin = goal * machines[0] / machines.length;
        System.out.println("Min: " + dMin);
        System.out.println("Max: " + dMax);
        System.out.println();
        long d = (dMin + dMax) / 2;
        while (dMin <= dMax) {
            System.out.println("Min: " + dMin);
            System.out.println("Max: " + dMax);
            d = (dMin + dMax) / 2;
            long count = getTotal(machines, d);
            System.out.println("Days: " + d);
            System.out.println("Count: " + count);
            System.out.println();
            if (count == goal) {
                System.out.println("Terminating here");
                return d;
            }
            if (count > goal) dMax = d - 1;
            else dMin = d + 1;
        }
        System.out.println(dMin);
        System.out.println(getTotal(machines, dMin));
        return dMin;
    }

    static long getTotal(long[] machines, long days) {
        long count = 0;
        for (long m : machines) count += days / m;
        //System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        long[] machines = {63, 2, 26, 59, 16, 55, 99, 1, 98, 65};
        long goal = 56;
//        getTotal(machines, 7);
        Solution(machines, goal);
    }

}
