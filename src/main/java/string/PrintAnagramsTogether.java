package string;

public class PrintAnagramsTogether {

    public static class DupItem {
        int index;
        String value;

        public DupItem(int index, String value) {
            super();
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DupItem [index=" + index + ", value=" + value + "]";
        }
    }

    public static void main(String[] args) {
        String[] array = {"cat", "dog", "tac", "act", "god"};
        printAllAnagramsTogether(array);
    }

    private static void printAllAnagramsTogether(String[] array) {
        int n = array.length;
        DupItem[] dupArray = new DupItem[n];
        for (int i = 0; i < n; i++) {
            dupArray[i] = new DupItem(i, array[i]);
        }

        // sort each word in dup array
        for (int i = 0; i < n; i++) {
            char[] charArray = dupArray[i].value.toCharArray();
            sort(charArray, 0, charArray.length - 1);
            dupArray[i].value = new String(charArray);
        }

        // now sort whole dup array based on words
        sort(dupArray, 0, n - 1);

        // print
        for (int i = 0; i < n; i++) {
            System.out.println(array[dupArray[i].index]);
        }
    }

    private static void sort(DupItem[] dupArray, int start, int end) {
        if (start < end) {
            int p = partition(dupArray, start, end);
            sort(dupArray, start, p - 1);
            sort(dupArray, p + 1, end);
        }
    }

    private static int partition(DupItem[] dupArray, int start, int end) {
        String x = dupArray[end].value;
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (dupArray[j].value.compareTo(x) <= 0) {
                i = i + 1;
                swap(dupArray, i, j);
            }
        }
        swap(dupArray, i + 1, end);
        return i + 1;
    }

    private static void swap(DupItem[] dupArray, int i, int j) {
        DupItem tmp = dupArray[i];
        dupArray[i] = dupArray[j];
        dupArray[j] = tmp;
    }

    private static void sort(char[] str, int start, int end) {
        if (start < end) {
            int p = partition(str, start, end);
            sort(str, start, p - 1);
            sort(str, p + 1, end);
        }
    }

    private static int partition(char[] str, int start, int end) {
        char x = str[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (str[j] <= x) {
                i++;
                swap(str, i, j);
            }
        }
        swap(str, i + 1, end);
        return i + 1;
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
