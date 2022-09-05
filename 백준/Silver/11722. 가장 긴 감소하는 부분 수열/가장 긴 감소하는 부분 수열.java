
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
		} // 배열 입력 완
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				// 현재 수가 그것의 왼쪽 인덱스 중 j번째 수보다 작으면 
				if (arr[i] < arr[j]) {
					// dp 배열의 현재 인덱스 i 를 수정.
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		} // 한바퀴 돌기
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
