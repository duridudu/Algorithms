
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[1] = arr[i];
			} else if (i == 2) {
				dp[2] = arr[1] + arr[2];
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
			}
		} // for
		System.out.println(dp[N]);
	}
}
