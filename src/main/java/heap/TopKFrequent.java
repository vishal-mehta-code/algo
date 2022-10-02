package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequent {

    public static class MinHeapNode {
        String str;
        int count;

        public MinHeapNode(String str, int count) {
            super();
            this.str = str;
            this.count = count;
        }

        @Override
        public String toString() {
            return "MinHeapNode [str=" + str + ", count=" + count + "]";
        }
    }


    public static void main(String[] args) {
        String str = "Welcome to the world of Geeks " +
                "This portal has been created to provide well written well thought and well explained " +
                "solutions for selected questions If you like Geeks for Geeks and would like to contribute " +
                "here is your chance You can write article and mail your article to contribute at " +
                "geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help " +
                "thousands of other Geeks";
        int k = 5;
        topKFrequent(str.split(" "), k);
    }


    private static void topKFrequent(String[] str, int k) {
        Map<String, Integer> map = new HashMap<>();

        int traversedElements = 0;
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])) {
                map.put(str[i], map.get(str[i]) + 1);
            } else {
                map.put(str[i], 1);

                if (map.size() == k) {
                    traversedElements = i;
                    break;
                }
            }
        }

        MinHeapNode[] minHeap = new MinHeapNode[k];
        int i = 0;
        for (Entry<String, Integer> entry : map.entrySet()) {
            minHeap[i++] = new MinHeapNode(entry.getKey(), entry.getValue());
        }

        createMinHeap(minHeap);

        for (int j = traversedElements + 1; j < str.length; j++) {
            if (map.containsKey(str[j])) {
                map.put(str[j], map.get(str[j]) + 1);
            } else {
                map.put(str[j], 1);
            }

            int indexInMinHeap = search(minHeap, str[j]);

            if (indexInMinHeap > -1) {
                MinHeapNode minHeapNode = minHeap[indexInMinHeap];
                minHeapNode.count = minHeapNode.count + 1;

                swap(minHeap, 0, indexInMinHeap);
                minHeapify(minHeap, 0);
            } else if (map.get(str[j]) > minHeap[0].count) {
                minHeap[0] = new MinHeapNode(str[j], map.get(str[j]));
            }
        }


        System.out.println(Arrays.toString(minHeap));
    }

    private static int search(MinHeapNode[] minHeap, String string) {
        for (int i = 0; i < minHeap.length; i++) {
            if (minHeap[i].str.equals(string)) {
                return i;
            }
        }
        return -1;
    }

    private static void createMinHeap(MinHeapNode[] minHeap) {
        int i = (minHeap.length - 2) / 2;
        while (i >= 0) {
            minHeapify(minHeap, i);
            i--;
        }
    }

    private static void minHeapify(MinHeapNode[] minHeap, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int s = i;

        if (l < minHeap.length && minHeap[l].count < minHeap[s].count) {
            s = l;
        }
        if (r < minHeap.length && minHeap[r].count < minHeap[s].count) {
            s = r;
        }

        if (s != i) {
            swap(minHeap, s, i);
            minHeapify(minHeap, s);
        }
    }

    private static void swap(MinHeapNode[] minHeap, int i, int j) {
        MinHeapNode tmp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = tmp;
    }
}
