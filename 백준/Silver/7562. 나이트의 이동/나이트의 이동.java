
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int T, I;
	static int arr[][];
	static int sr, sc, fr, fc;
	static int[] dr = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int[] dc = { 2, -2, 1, -1, 2, -2, 1, -1 };

	static class loc {
		int r, c;

		loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner scc = new Scanner(System.in);
		T = scc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			I = scc.nextInt();
			arr = new int[I][I];
			sr = scc.nextInt();
			sc = scc.nextInt();
			fr = scc.nextInt();
			fc = scc.nextInt();
//			arr[sr][sc] = 1;
			bfs(sr, sc);
			System.out.println(arr[fr][fc]);
		}
	}

	private static void bfs(int sr, int sc) {
		if (sr==fr && sc ==fc) {
			return;
		}
		Queue<loc> q = new LinkedList<>();
		loc l = new loc(sr, sc);
		q.add(l);
		while (!q.isEmpty()) {
//			q.toString();
			loc l2 = q.poll();
			for (int i = 0; i < 8; i++) {
				int nr = l2.r + dr[i];
				int nc = l2.c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < I && nc < I && arr[nr][nc] == 0) {
					arr[nr][nc] = arr[l2.r][l2.c] + 1;
//					System.out.print(nr + " " + nc + " " + "arr[nr][nc] is (" + arr[nr][nc] + ")" + "\n");
					loc l3 = new loc(nr, nc);
					q.add(l3);
				}
			}

		}

	}
}
