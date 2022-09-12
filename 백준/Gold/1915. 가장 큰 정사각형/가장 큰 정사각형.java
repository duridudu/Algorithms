
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[N][M];

		// 맨 아랫줄/맨 왼쪽줄 비교할 때 가장 작은 값인 0 깔아주고, 인덱스 편하게 하기 위해 +1씩 한 채로 시작
		int[][] dp = new int[N + 1][M + 1];

		// arr 입력
		for (int n = 0; n < N; n++) {
			String str = sc.next();
			for (int m = 0; m < M; m++) {
				arr[n][m] = str.charAt(m);
			}
		}

		// DP 시작 - 뒤부터 돌아보자
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				// 0이면 dp배열 0으로 채움
				if (arr[i][j] == '0') {
					dp[i][j] = 0;
				}
				// 1이면 일단 1을 채워주고 해당 칸을 둘러싼 세 칸 중 가장 작은 값 더함.
				else {
					dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
				}
				// 나중에 따로 구하지 않게 바로 최댓값 찾기
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max * max);
	}
}
