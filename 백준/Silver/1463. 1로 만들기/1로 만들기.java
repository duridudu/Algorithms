import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long[] dp = new long[(int) (N + 1)];
		dp[1] = 0;
		if (N >1) {
			dp[2] = 1;
		}
		if (N > 2) {
			dp[3] = 1;
		}
		for (int i = 4; i <= N; i++) {
			if (i % 2 != 0 && i % 3 != 0) {
				dp[i] = dp[i - 1] + 1;
			} else if (i % 2 == 0 && i % 3 == 0) {
				long temp = (long) Math.min(dp[i / 2], dp[i / 3]);
//				System.out.println("공배수" + i + " " + temp);
				dp[i] = Math.min(dp[i - 1] + 1, temp + 1);
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
			} else {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
			}
		}
		System.out.println(dp[(int) N]);
	}
}
