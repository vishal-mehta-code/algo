package stack;

import java.util.*;

public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval [start=" + start + ", end=" + end + "]";
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3}, {5, 7}, {2, 4}, {6, 8}};
        mergeIntervals(array);
    }

    private static void mergeIntervals(int[][] array) {
        List<Interval> intervals = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            intervals.add(new Interval(array[i][0], array[i][1]));
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Stack<Interval> stack = new Stack<>();
        for (Interval interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                if (stack.peek().end > interval.start) {
                    stack.peek().end = interval.end;
                } else {
                    stack.push(interval);
                }
            }
        }

        while (!stack.isEmpty()) {
            Interval interval = stack.pop();
            System.out.println(interval.start + " " + interval.end);
        }
    }
}
