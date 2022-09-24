
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static Character[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] ans;
	static int cnt;
	static int each;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new Character[N][N];
		ans = new int[25*25+1];
		// 아파트 입력받기
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '1') {
					cnt++;
					each = 1;
					dfs(i, j);
//					System.out.println("한 턴 끗 ㄱ-");
//					System.out.print("이 때 개수는? "+each+"\n");
					ans[cnt]=each;
				}
			}
		}
		Arrays.sort(ans);
		System.out.println(cnt);
		for (int i=1; i<ans.length;i++) {
			if (ans[i] !=0) {
				System.out.println(ans[i]);
			}
		}
	}

	private static void dfs(int r, int c) {
		arr[r][c] = '0';
		for (int i=0;i<4;i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			if (rr>=0 && rr<N && cc>=0 && cc<N && arr[rr][cc]=='1') {
				each++;
//				System.out.print("("+rr+", "+cc+")\n");
				arr[rr][cc]='0';
				dfs(rr,cc);
			}
		}
	}
}
