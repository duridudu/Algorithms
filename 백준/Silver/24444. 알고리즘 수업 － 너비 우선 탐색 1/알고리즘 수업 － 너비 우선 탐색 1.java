
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

	public static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		int cnt = 1;
		q.offer(num);
		check[num] = cnt;
		cnt += 1; // 이 두 줄은 check[num]=cnt++;로 줄여쓰기 가능 
		while (!q.isEmpty()) {
			int a = q.poll();
			// 현재 인덱스에 딸린 원소 전부 방문표시 함. bfs니깐 
			for (int i = 0; i < arr.get(a).size(); i++) {
				int k = arr.get(a).get(i);
				// 방문 안 한 거라면 방문표시 하고, 지금 for문 끝나면 들어가게 큐에 추가 
				if (check[k] == 0) {
					check[k] = cnt++;
					q.offer(k); // 현재 줄 다 체크하고 그 담에 자식 노드로 들어가는 방식으로 재귀처럼 활용 
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

		bfs(start);

		for (int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);
	} // main

}
