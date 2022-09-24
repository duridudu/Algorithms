
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] arr;
	static int cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class loc {
		int x, y;

		loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(arr[N-1][M-1]);
	}// main

	private static void bfs(int r, int c) {
		Queue<loc> q = new LinkedList<>();
		loc l = new loc(r, c);
		q.offer(l);
		while (!q.isEmpty()) {
			loc l1 = q.poll();
			for (int i = 0; i < 4; i++) {
				int rr = l1.x + dr[i];
				int cc = l1.y + dc[i];
				if (rr >= 0 && rr < N && cc >= 0 && cc < M && arr[rr][cc] == 1) {
					arr[rr][cc] = arr[l1.x][l1.y] + 1;
//					System.out.print("(r,c) value is ("+r+", "+c+")\n");
//					System.out.print("arr[r][c] is "+arr[r][c]+"\n");
//					System.out.print("arr[rr][cc] is "+arr[rr][cc]+"\n");
					loc l2 = new loc(rr,cc);
					q.offer(l2);
				}
			}

		}
	}

}
