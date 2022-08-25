
import java.util.Scanner;

public class Solution {
	static char arr[][];
	static int[] W;
	static int[] B;
	static int[] R;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];

			W = new int[N];
			B = new int[N];
			R = new int[N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == 'W')
						W[i] += 1;
					else if (arr[i][j] == 'B')
						B[i] += 1;
					else
						R[i] += 1;
				}
			} // 배열 입력 완. && 각 행에서의 색 개수 각 색 배열에 입력 완.
			int sum = 0;
			for (int i = 0; i < N - 2; i++) {
				for (int j = i + 1; j < N - 1; j++) {
					for (int z = j + 1; z < N; z++) {
						int cntW = 0;
						int cntB = 0;
						int cntR = 0;
						for (int k = 0; k <= i; k++) {
							cntW += W[k];
						}
						for (int f = i + 1; f <= j; f++) {
							cntB += B[f];
						}
						for (int c = j + 1; c < N; c++) {
							cntR += R[c];
						}
						sum = Math.max(sum, cntW + cntB + cntR); // sum이 클수록 이미 존재하는 칠할 색이 많은것이므로 칠해야할 곳이 적음.
//						System.out.println("sum "+i+"&"+j+"&"+z);
					}
				}
			} // sum 찾기
			int ans = N * M - sum;
			System.out.println("#" + tc + " " + ans);
		} // tc
		sc.close();
	}// main
}
