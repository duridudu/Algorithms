
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] checkDFS, checkBFS;
	static int[] countDFS, countBFS;
	static int cntDFS, cntBFS;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sbDFS = new StringBuilder();
		StringBuilder sbBFS = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr.get(first).add(second);
			arr.get(second).add(first);
		}

		// 각 정점마다 연결돼있는 노드 오름차순 정렬
		for (int i = 0; i < N + 1; i++) {
			Collections.sort(arr.get(i));
		}

		checkDFS = new boolean[N + 1];
		countDFS = new int[N + 1];
		cntDFS = 1;
		dfs(V);
		for (int i = 1; i < countDFS.length; i++) {
			if (countDFS[i] != 0) {
				sbDFS.append(countDFS[i] + " ");
			}
		}

		checkBFS = new boolean[N + 1];
		countBFS = new int[N + 1];
		bfs(V);
		for (int i = 1; i < countBFS.length; i++) {
			if (countBFS[i] != 0) {
				sbBFS.append(countBFS[i] + " ");
			}
		}

		System.out.println(sbDFS);
		System.out.println(sbBFS);

	}// main

	private static void dfs(int start) {
		checkDFS[start] = true;
		countDFS[cntDFS] = start;
		for (int i = 0; i < arr.get(start).size(); i++) {
			int temp = arr.get(start).get(i);
			if (checkDFS[temp] == false) {
				checkDFS[temp] = true;
				countDFS[++cntDFS] = temp;
				dfs(temp);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> qBFS = new LinkedList<>();
		cntBFS = 1;
		checkBFS[start] = true;
		countBFS[cntBFS++] = start;
		qBFS.offer(start);

		while (!qBFS.isEmpty()) {
			int temp = qBFS.poll();
			for (int i = 0; i < arr.get(temp).size(); i++) {
				int temp2 = arr.get(temp).get(i);
				if (checkBFS[temp2] == false) {
					checkBFS[temp2] = true;
					countBFS[cntBFS++] = temp2;
					qBFS.offer(temp2);
				}
			}
		}

	}
}
