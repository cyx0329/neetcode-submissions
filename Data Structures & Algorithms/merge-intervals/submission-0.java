class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] prev = res.get(res.size()-1);
            int[] curr = intervals[i];
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
