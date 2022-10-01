package heap;

public class IsHeap {

	private static final int[] array = { 90, 15, 10, 7, 12, 2 };

	public static void main(String[] args) {
		System.out.println("is heap  : " + (isMaxHeap() || isMinHeap()));
	}

	private static boolean isMinHeap() {
		for (int i = 0; i <= (array.length - 2) / 2; i++) {
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if ((l < array.length && array[i] > array[l]) || (r < array.length && array[i] > array[r])) {
				return false;
			}
		}
		return true;
	}

	private static boolean isMaxHeap() {
		for (int i = 0; i <= (array.length - 2) / 2; i++) {
			int l = 2 * i + 1;
			int r = 2 * i + 2;

			if ((l < array.length && array[i] < array[l]) || (r < array.length && array[i] < array[r])) {
				return false;
			}
		}

		return true;
	}
}
