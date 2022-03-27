import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] ans = merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }
    private static int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]){ // Overlapping intervals, move the end if needed
                print(result);
				newInterval[1] = Math.max(newInterval[1], interval[1]);
                print(result);
            }
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}

    public static void print(List<int[]> result){
        for(int[] arr: result){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
    }
}
