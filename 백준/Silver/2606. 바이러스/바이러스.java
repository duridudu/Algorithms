
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int vertex;
	static int edge;
	static boolean[] isVirus;

	private static void findVirus(int idx) {
		// 처음 감염된 컴퓨터 감염표시 해줌.
		isVirus[idx] = true;

		// 그 컴퓨터랑 이어진 컴퓨터들 조사
		for (int i = 0; i < arr.get(idx).size(); i++) {
			int temp = arr.get(idx).get(i);
			// 이어진 컴퓨터가 감염 처리 안돼있으면 처리 하고 그거랑 이어진 컴퓨터로 넘어감.
			if (isVirus[temp] == false) {
				isVirus[temp] = true;
				findVirus(temp);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// 첫째줄 : 정점 수, 둘째줄 : 간선 수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		vertex = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		isVirus = new boolean[vertex + 1];

		// 정점 수대로 빈 어레이리스트 만들기
		for (int i = 0; i < vertex + 1; i++) {
			arr.add(new ArrayList<>());
		}

		// 정점-간선 그래프 채워넣기
		for (int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			arr.get(first).add(second);
			arr.get(second).add(first);
		}

		findVirus(1);
		int cnt = 0;
//		System.out.println(Arrays.toString(isVirus));
		for (int i = 2; i < isVirus.length; i++) {
			if (isVirus[i] == true) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

}
