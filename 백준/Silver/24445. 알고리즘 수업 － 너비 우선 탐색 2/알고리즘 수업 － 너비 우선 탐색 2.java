import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int[] check;
	static int cnt;

	// 너비 우선!!!!!!!!! 현재 노드 자식 다 체크해서 큐에 넣고 들어가야댐.
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;
		q.offer(start);
		check[start] = cnt++; // check에 넣고 cnt 하나 증가

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < arr.get(temp).size(); i++) {
				int k = arr.get(temp).get(i);
				if (check[k] == 0) {
					check[k] = cnt++;
					q.offer(k);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		check = new int[vertex + 1];

		for (int i = 0; i < vertex+1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr.get(first).add(second);
			arr.get(second).add(first);

		}

		for (int i = 0; i < arr.size(); i++) {
			Collections.sort(arr.get(i), Collections.reverseOrder());
		}

		bfs(start);
		for (int i = 1 ; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);
	}
}
