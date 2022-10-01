package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GetMaxChain {
	private static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		set.addAll(Arrays.asList(new String[] { "a", "b", "ab", "abc", "abd", "abcd" }));
		getMaxChain(set);
	}

	private static void getMaxChain(Set<String> set) {
		int max = 1;
		for (String str : set) {
			maxChainUtilCount = 0;
			getMaxChainUtil(str, 0);
			max = Math.max(max, maxChainUtilCount);
		}

		System.out.println(max);
	}

	private static int maxChainUtilCount = 0;

	private static void getMaxChainUtil(String str, int count) {

		if (set.contains(str)) {
			count++;
			if (count > maxChainUtilCount) {
				maxChainUtilCount = count;
			}
		}

		for (int i = 1; i <= str.length(); i++) {
			getMaxChainUtil(str.substring(0, i - 1) + str.substring(i, str.length()), count);
		}
	}
}
