
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N,K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			
			// 결과 0으로 초기화 
			result = 0;
			
			// 인덱스와 합 
			solve(0, 0);
			sb.append("#" + i + " " + result + "\n");
		}
		System.out.println(sb);
	}

	static int result;

	private static void solve(int idx, int sum) {
		// 합이 K이면 개수 늘리고 종료 
		if (sum == K) {
			result++;
			return;
		}
		
		// 합이 K보다 크거나 인덱스 넘어가면 종료
		if (sum > K || idx >= N)
			return;
		
		// 재귀 파트
		// 자기 자신을 포함하고 다음 인덱스로 넘어감 (sum에 자기 자신 포함)
		solve(idx + 1, sum + arr[idx]);
		// 자기 자신을 미포함하고 다음 인덱스로 넘어감 ㄴ
		solve(idx + 1, sum);
	}
}
