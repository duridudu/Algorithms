
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			arr[i][2] = sc.nextInt();
		} // RGB 거리 별 색 입력완

		int[][] dp = new int[N][3];
		// 젤 첫 값은 첫번째 집 값 그대로 넣어줌.
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		// 모든 색의 경우를 다 저장하고, 마지막 집의 세가지 색 중 최소 비용 찾음 
		for (int i = 0; i < N - 1; i++) {
			// 현재 집에서 빨간색을 고른다면 누적 비용은 = min(이전 집의 초록 비용, 이전 집의 파란 비용) + 현재 집의 빨간 비용 
			dp[i + 1][0] = Math.min(dp[i][1], dp[i][2]) + arr[i + 1][0];
			
			// 현재 집에서 초록색을 고른다면 누적 비용은 = min(이전 집의 빨강 비용, 이전 집의 파란 비용) + 현재 집의 초록 비용 
			dp[i + 1][1] = Math.min(dp[i][0], dp[i][2]) + arr[i + 1][1];
			
			// 현재 집에서 파란색을 고른다면 누적 비용은 = min(이전 집의 빨강 비용, 이전 집의 초록 비용) + 현재 집의 파란 비용 
			dp[i + 1][2] = Math.min(dp[i][0], dp[i][1]) + arr[i + 1][2];
		}

		int res = Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2]));
		System.out.println(res);

	}
}
