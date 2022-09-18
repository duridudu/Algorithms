
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int[] check;
	static int cnt;

	public static void dfs(int num) {
		check[num] = cnt;
		for (int i = 0; i < arr.get(num).size(); i++) {
			int next = arr.get(num).get(i);
			if (check[next] == 0) {
				cnt += 1;
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		check = new int[vertex + 1];

		for (int i = 0; i < vertex + 1; i++) {
			arr.add(new ArrayList<>());
		}

		// 그래프 채워넣기
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr.get(first).add(second);
			arr.get(second).add(first);
		}

		// 각 배열 요소 오름차순으로 정리
		for (int i = 0; i < arr.size(); i++) {
			Collections.sort(arr.get(i));
		}

		cnt = 1;
		dfs(start);

		for (int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);
	} // main

}
