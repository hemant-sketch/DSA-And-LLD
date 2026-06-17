/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int idx = 0; idx < n; idx++) {
            start[idx] = intervals.get(idx).start;
            end[idx] = intervals.get(idx).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0;
        int rooms = 0;
        int maxRooms = 0;

        while (s < n) {
            if (start[s] < end[e]) {
                rooms++;
                s++;
            } else {
                rooms--;
                e++;
            }

            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }
}


[(0,40),(5,10),(15,20)]

            s  
start 0 5 15
end   10 20 40
          e

room = 2
