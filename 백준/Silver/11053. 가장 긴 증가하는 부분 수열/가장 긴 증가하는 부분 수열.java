import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j] >= dp[i] && arr[i] > arr[j]) {
					dp[i] += 1;
				}
			}
		} // for
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);
	}
}
