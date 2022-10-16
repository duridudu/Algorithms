
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static int[] numLinked;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new ArrayList[N + 1];
		numLinked = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			arr[i] = new ArrayList();
		}

		int[][] tmp = new int[M][];
		for (int i = 0; i < M; i++) {
			int singerNum = sc.nextInt();
			tmp[i] = new int[singerNum];
			for (int j = 0; j < singerNum; j++) {
				tmp[i][j] = sc.nextInt();
			}
		}
//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(tmp[i]));
//		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < tmp[i].length - 1; j++) {
//				System.out.println(tmp[i][j]);
//				System.out.println(tmp[i][j + 1]);
				arr[tmp[i][j]].add(tmp[i][j + 1]);
				numLinked[tmp[i][j + 1]] += 1;
			}
		} // arr, numLinked

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N + 1; i++) {
			if (numLinked[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n).append('\n');
			for (int nextSinger : arr[n]) {
				numLinked[nextSinger]--;
				if (numLinked[nextSinger] == 0) {
					q.add(nextSinger);
				}
			}
		} // while
		if (sb.length() < N * 2) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}
}
