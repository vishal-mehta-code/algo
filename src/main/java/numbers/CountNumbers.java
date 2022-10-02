package numbers;

/**
 * Count numbers till a given no that does not contain a given no.
 */
public class CountNumbers {

    public static void main(String[] args) {
        int n = 45;
        int k = 3;

        System.out.println(countNumbers(n, k));
    }

    private static int countNumbers(int n, int k) {
        if (n < k)
            return n;
        if (n >= k && n < 10)
            return n - 1;

        int pow = pow(n);
        int msd = n / pow;

        if (msd == k) {
            return countNumbers((msd * pow) - 1, k);
        }

        return countNumbers(msd, k) * countNumbers(pow - 1, k) + countNumbers(msd, k) + countNumbers(n % pow, k);
    }

    private static int pow(int n) {
        int pow = 1;

        while (n / 10 != 0) {
            n = n / 10;
            pow = pow * 10;
        }
        return pow;
    }
}
