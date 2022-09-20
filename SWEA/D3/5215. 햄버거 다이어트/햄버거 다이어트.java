// 비트연산 버전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, L;
	static int[][] arr;
	static boolean[] check;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			check = new boolean[N];
			res = 0;
			powerSet();
			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.println(sb);
	}// main

	private static void powerSet() {
        // 주어진 재료에 대해 가능한 모든 부분집합의 경우의 수 탐색
		for (int i = 0; i < (1 << N); i++) {
			int taste = 0;
			int kcal = 0;
            // 현재 부분집합과 재료 개수별 일치 여부 비교
			for (int j = 0; j < N; j++) {
                // 현재 부분집합의 원소와 일치하는 부분집합이면 맛, 칼로리에 합산
				if ((i & (1 << j)) > 0) {
					taste += arr[j][0];
					kcal += arr[j][1];
				}
			}
			// 칼로리가 L보다 작으면 res와 taste 비교
			if (kcal<=L) {
				res= Math.max(res, taste);
			}
		}
	}

}
