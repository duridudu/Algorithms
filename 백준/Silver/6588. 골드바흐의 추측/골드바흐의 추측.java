import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    final static int SQRT_PRIME_LIMIT = 1000;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // find prime numbers
        final boolean[] isPrime = findPrimeNumbers();

        // solution accumulation
        StringBuilder sb = new StringBuilder();

        // iterate over testCases
        while (true)
        {
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                break;
            }
            int midN = n / 2;
            for (int idx2 = 3; idx2 <= midN; idx2++) {
                if (isPrime[idx2] && isPrime[n - idx2]) {
                    sb.append(n).append(" = ").append(idx2).append(" + ").append(n-idx2).append("\n");
                    break;
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
        br.close();
    }

    private static boolean[] findPrimeNumbers() {
        int sqrtPrimeLimitNum = SQRT_PRIME_LIMIT;
        int PrimeLimitNum = sqrtPrimeLimitNum * sqrtPrimeLimitNum;
        final boolean[] isPrime = new boolean[PrimeLimitNum];
        Arrays.fill(isPrime, Boolean.TRUE);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= sqrtPrimeLimitNum; i++) {
            if (isPrime[i]) {
                for (int j = i; j < PrimeLimitNum; j += i) {
                    if (isPrime[j] && i != j) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
    }
}