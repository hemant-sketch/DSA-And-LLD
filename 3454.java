import java.util.*;

/**
 * Segment Tree that maintains covered length on x-axis
 * using coordinate compression.
 */
class SegmentTree {
    private final int n;                 // number of segments = xs.length - 1
    private final int[] xs;               // compressed x-coordinates
    private final int[] coveredCount;     // lazy cover count
    private final int[] coveredWidth;     // covered width for this node

    public SegmentTree(int[] xs) {
        this.xs = xs;
        this.n = xs.length - 1;
        this.coveredCount = new int[4 * n];
        this.coveredWidth = new int[4 * n];
    }

    // Adds val to range [i, j)
    public void add(int i, int j, int val) {
        add(0, 0, n - 1, i, j, val);
    }

    // Returns total covered width
    public int getCoveredWidth() {
        return coveredWidth[0];
    }

    private void add(int treeIndex, int lo, int hi, int i, int j, int val) {
        // No overlap
        if (j <= xs[lo] || xs[hi + 1] <= i) {
            return;
        }

        // Fully covered
        if (i <= xs[lo] && xs[hi + 1] <= j) {
            coveredCount[treeIndex] += val;
        } else {
            int mid = (lo + hi) / 2;
            add(2 * treeIndex + 1, lo, mid, i, j, val);
            add(2 * treeIndex + 2, mid + 1, hi, i, j, val);
        }

        // Update covered width
        if (coveredCount[treeIndex] > 0) {
            coveredWidth[treeIndex] = xs[hi + 1] - xs[lo];
        } else if (lo == hi) {
            coveredWidth[treeIndex] = 0;
        } else {
            coveredWidth[treeIndex] =
                coveredWidth[2 * treeIndex + 1] +
                coveredWidth[2 * treeIndex + 2];
        }
    }
}

class Solution {

    public double separateSquares(int[][] squares) {
        // events: (y, delta, xl, xr)
        List<int[]> events = new ArrayList<>();
        TreeSet<Integer> xsSet = new TreeSet<>();

        for (int[] square : squares) {
            int x = square[0];
            int y = square[1];
            int l = square[2];

            events.add(new int[]{y, 1, x, x + l});
            events.add(new int[]{y + l, -1, x, x + l});

            xsSet.add(x);
            xsSet.add(x + l);
        }

        // Sort events by y
        events.sort(Comparator.comparingInt(a -> a[0]));

        int[] xs = xsSet.stream().mapToInt(Integer::intValue).toArray();

        double halfArea = getArea(events, xs) / 2.0;

        long area = 0;
        int prevY = 0;
        SegmentTree tree = new SegmentTree(xs);

        for (int[] e : events) {
            int y = e[0];
            int delta = e[1];
            int xl = e[2];
            int xr = e[3];

            int coveredWidth = tree.getCoveredWidth();
            long areaGain = (long) coveredWidth * (y - prevY);

            if (area + areaGain >= halfArea) {
                return prevY + (halfArea - area) / coveredWidth;
            }

            area += areaGain;
            tree.add(xl, xr, delta);
            prevY = y;
        }

        throw new RuntimeException("Unreachable");
    }

    // Computes total area using sweep line
    private long getArea(List<int[]> events, int[] xs) {
        long totalArea = 0;
        int prevY = 0;
        SegmentTree tree = new SegmentTree(xs);

        for (int[] e : events) {
            int y = e[0];
            int delta = e[1];
            int xl = e[2];
            int xr = e[3];

            totalArea += (long) tree.getCoveredWidth() * (y - prevY);
            tree.add(xl, xr, delta);
            prevY = y;
        }

        return totalArea;
    }
}
// i dont no segment trees thats why copied this question 14-01-2026
