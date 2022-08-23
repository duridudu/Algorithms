
import java.util.Scanner;

public class Solution {
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			// 사이즈 N만큼 저장할 배열 
			char[][] arr = new char[N][N];
			// 한줄 받아서 row에 넣고, charAt으로 각각 쪼개어 넣음 
			for (int i = 0; i < N; i++) {
				String row = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = row.charAt(j);
				}
			} // 오목판 입력 완료

			int[] dr = { 0, 1, 1, 1 }; // 동 남동 남 남서
			int[] dc = { 1, 1, 0, -1 };
			
			// 5번 연속으로 나왔는지 확인하는 플래그 
			// 전체 배열을 순회 
			flag=false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 순회하다가 오목 만나면 그 오목에 대해 네 방향 확인 
					if (arr[i][j] == 'o') {
						// 한 방향 확인할 때 스트레이트로 그 방향 쭉 * 4번 확인해서 연속됐는지 확인 
						for (int d = 0; d < 4; d++) {
							for (int c = 1; c < 5; c++) {
								// 다음 칸 지정 
								int nr = i + dr[d] * c;
								int nc = j + dc[d] * c;
								// 각 경계를 넘으면 종료 
								if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
									break;
								}
								// 그 다음 칸이 오목이 아니어도 종료(연속이어야 하므로) 
								else if(arr[nr][nc]!='o') {
									break;
								}
								// 개수가 5개 연속됐을 때 True 저장 (위의 두 break에서 살아남았을 때) 
								if (c==4) {
									flag=true;
								}
							}
						}
					}
				}
			}
 
			if (flag) {
				System.out.printf("#%d YES\n", tc);				
			}
			else {
				System.out.printf("#%d NO\n", tc);
			}
		} // tc
		sc.close();
	}// main
}
