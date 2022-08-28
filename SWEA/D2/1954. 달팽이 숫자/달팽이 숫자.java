
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			arr = new int[N][N];
			int dr[] = { 0, 1, 0, -1 };
			int dc[] = { 1, 0, -1, 0 };
			int nr = 0;
			int nc = 0;
			int r = 0;
			int c = 0;
			int num = 1;

			arr[0][0] = num;
			num++;
			for (int i = 0; i <= N / 2; i++) {
				for (int j = 0; j < 3; j++) {
					while (true) {
						nr = r + dr[j];
						nc = c + dc[j];
						if (nr < N - i && nr >= i && nc < N - i && nc >= i) {
							arr[nr][nc] = num;
							num++;
							r = nr;
							c = nc;
						} else {
							break;
						}
					} // 좌,하, 우 방향 감
				}
				while (true) {
					nr = r + dr[3];
					nc = c + dc[3];
					if (nr > i) {
						r = nr;
						c = nc;
						arr[nr][nc] = num;
						num++;
					} else {
						break;
					}

				}
			} // 달팽이 완료
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					System.out.printf("%d ", arr[i][j]);

				}
				System.out.println();
			}
		}
	}

}