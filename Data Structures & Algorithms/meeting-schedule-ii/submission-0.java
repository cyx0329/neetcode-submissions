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

        Collections.sort(intervals, (a, b)-> Integer.compare(a.start, b.start));
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        
        for(int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if(!minHeap.isEmpty() && minHeap.peek().end <= curr.start) {
                minHeap.poll();
            }
           
            minHeap.add(curr);
            
        }

        return minHeap.size();
    }
}
