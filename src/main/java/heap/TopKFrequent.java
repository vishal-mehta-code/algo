package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
        String str = "hello how are you Vishal Vishal are you okie yes Vishal is okie";
        int k = 5;
        topKFrequent(str.split(" "), k);
    }


    private static void topKFrequent(String[] str, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String curr : str) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(k, (a, b) -> a.freq - b.freq);

        int index = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (index < k) {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            } else {
                if (queue.peek().freq < entry.getValue()) {
                    queue.poll();
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            index++;
        }

        Pair[] output = new Pair[k];
        int i = k - 1;
        while (!queue.isEmpty()) {
            output[i--] = queue.poll();
        }

        System.out.println(Arrays.toString(output));
    }

}

class Pair {
    String val;
    int freq;

    Pair(String val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "val: " + val + " " + "freq:" + freq;
    }
}
