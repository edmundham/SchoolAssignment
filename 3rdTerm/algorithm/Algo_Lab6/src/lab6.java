
import java.util.Comparator;
import java.util.PriorityQueue;

public class lab6 {

    private final static int NUM_OF_SMALLEST_VAL = 4;

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};

        MaxComparator pqMaxComparetor = new MaxComparator();
        PriorityQueue<Integer> pqResult = new PriorityQueue<>(NUM_OF_SMALLEST_VAL, pqMaxComparetor);

        for (int x : a) {
            if (pqResult.size() < NUM_OF_SMALLEST_VAL) {
                pqResult.offer(x);
            } else if (x < pqResult.peek()) {
                pqResult.poll();
                pqResult.offer(x);
            }
        }

        System.out.println("size: " + pqResult.size());
        System.out.println("Smallest " + NUM_OF_SMALLEST_VAL + " numbers: " + pqResult);

    }

    static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }
}
