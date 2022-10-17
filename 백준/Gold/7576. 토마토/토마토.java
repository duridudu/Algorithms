
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static ArrayList<Loc> tomts;
	static int[][] isVisited;
	static int N, M, date;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 }; // row
	static int[] dc = { 0, 0, -1, 1 }; // col

	static class Loc {
		int x, y;

		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		isVisited = new int[N][M];
		tomts = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				// 익은 토마토이면 위치를 기록해두자
				if (arr[i][j] == 1) {
					Loc tomt = new Loc(i, j);
//					isVisited[i][j]==1
					tomts.add(tomt);
				}
			}
		} // arr
		int res = 0;
		date = 0;
		res = bfs(tomts.size());

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(isVisited[i]));
//		}
		int tmp = 0;
		int tmp2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isVisited[i][j] == 0 && arr[i][j] != -1) {
					res = -1;
					break;
				} else if (arr[i][j] == 1) {
					tmp2++;
				}
				else if (isVisited[i][j] != 0 && arr[i][j] != -1) {
					tmp++;
				} 
			}
		}

		if (res > 0) {
			res -= 1;
		} else if (tmp == N * M) {
			res = 1;
		} else if (tmp2 == N * M) {
			res = 0;
		}
		System.out.println(res);
	}

	private static int bfs(int num) {
		Queue<Loc> q = new LinkedList<>();
		// 익은 토마토 개수만큼 돌면서 냅다 큐에 모든 연결 토마토를 넣음
		// 단, 옆이 비어있으면 탈락!!!!!
		for (int i = 0; i < num; i++) {
			Loc now = tomts.get(i);
			int x = now.x;
			int y = now.y;
			isVisited[x][y] = 1;
			// arr[x][y] = 1일 수 밖에 없음! 1만 넣엇으니까... 당연함
			for (int j = 0; j < 4; j++) {
				int nx = x + dr[j];
				int ny = y + dc[j];
				if (nx < N && nx >= 0 && ny < M && ny >= 0 && isVisited[nx][ny] == 0 && arr[nx][ny] != -1) {
					q.add(new Loc(nx, ny));
					isVisited[nx][ny] = isVisited[x][y] + 1;
				}
			}
		}
//		for (int ii = 0; ii < N; ii++) {
//			System.out.println(Arrays.toString(isVisited[ii]));
//		}
		while (!q.isEmpty()) {
			Loc next = q.poll();
			int xx = next.x;
			int yy = next.y;

//			System.out.println("(" + xx + ", " + yy + ")");
			for (int j = 0; j < 4; j++) {
				int nxx = xx + dr[j];
				int nyy = yy + dc[j];
				if (nxx < N && nxx >= 0 && nyy < M && nyy >= 0 && isVisited[nxx][nyy] == 0 && arr[nxx][nyy] != -1) {
					q.add(new Loc(nxx, nyy));
					isVisited[nxx][nyy] = isVisited[xx][yy] + 1;
					date = isVisited[nxx][nyy];
				}
			}
		} // while
		return date;

	}
}
