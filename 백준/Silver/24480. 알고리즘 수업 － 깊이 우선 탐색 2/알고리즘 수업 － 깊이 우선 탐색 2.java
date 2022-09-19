
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

	// 내림차순 깊이우선!!!!!!!!!!!! 그러면 바로 아래 노드만 체크 표시하고 걔를 다시 재귀
	public static void dfs(int start) {
		// cnt 카운트 하는 단계
		check[start] = cnt;
		for (int i = 0; i < arr.get(start).size(); i++) {
			int next = arr.get(start).get(i);
			// 방문한 적이 없는 노드라면 cnt 하나 올리고(이 올려진 건 재귀 들어간 후에 적용)
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

		cnt = 1;
		dfs(start);
		for (int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);

	}
}
