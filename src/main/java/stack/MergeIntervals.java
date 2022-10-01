package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

		int[][] array = { { 1, 3 }, { 5, 7 }, { 2, 4 }, { 6, 8 } };

		mergeIntervals(array);
	}

	private static void mergeIntervals(int[][] array) {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			intervals.add(new Interval(array[i][0], array[i][1]));
		}

		sort(intervals, 0, intervals.size() - 1);
		System.out.println(intervals);

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

	private static void sort(List<Interval> intervals, int start, int end) {
		if (start < end) {
			int p = pivot(intervals, start, end);
			sort(intervals, start, p - 1);
			sort(intervals, p + 1, end);
		}

	}

	private static int pivot(List<Interval> intervals, int start, int end) {
		int x = intervals.get(end).start;
		int i = start - 1;
		for (int j = 0; j < end; j++) {
			if (intervals.get(j).start < x) {
				i = i + 1;
				swap(intervals, i, j);
			}
		}
		swap(intervals, i + 1, end);
		return i + 1;
	}

	private static void swap(List<Interval> intervals, int i, int j) {
		Interval tmp = intervals.get(i);
		intervals.set(i, intervals.get(j));
		intervals.set(j, tmp);
	}

}
