
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		} // 삼각형 입력 완

		dp[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (j == 0) {
//					System.out.println("지금 i는 " + i + ", 지금 j는 " + j);
					dp[i][j] = dp[i - 1][j] + arr[i][j];
//					System.out.println("지금 i는 " + dp + ", 지금 j는 " + j);
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
				}
			}
		} // dp

		int res = 0;	
		int [] temp = new int[N];
		for (int i=0;i<N;i++) {
			temp[i]=dp[N-1][i];
		}
		Arrays.sort(temp);
		res = temp[N-1];
		System.out.println(res);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < i + 1; j++) {
//				System.out.print(dp[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
	}
}
