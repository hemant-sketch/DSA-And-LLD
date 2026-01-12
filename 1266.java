class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for(int idx = 0; idx < points.length-1; idx++) {
            int x1 = points[idx][0];
            int y1 = points[idx][1];

            int x2 = points[idx + 1][0];
            int y2 = points[idx + 1][1];

            int xdist = Math.abs(x2-x1);
            int ydist = Math.abs(y2-y1);

            time += Math.max(xdist, ydist);
        }

        return time;
    }
}
