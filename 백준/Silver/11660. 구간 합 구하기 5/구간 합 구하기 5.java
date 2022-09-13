
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
//		int[][] target = new int[M][4];
		int[][] dp = new int[N + 1][N + 1];

		// 배열 입력
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int nn = 1; nn <= N; nn++) {
				arr[n][nn] = Integer.parseInt(st.nextToken());
			}
		}


		// x1, y1 -> x2, y2 순회
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j] - dp[i - 1][j - 1];

			}
		}

		StringBuilder sb = new StringBuilder();
		int x1, y1, x2, y2;
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sb.append((dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
		} // for
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
