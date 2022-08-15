

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N = 100;
		for (int tc = 1; tc <= T; tc++) {
			int TC = sc.nextInt();
			String[] arr = new String[N];
			char[][] cArray = new char[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
				cArray[i] = arr[i].toCharArray();
			}
			int max = 0;
			int max2=0;
			int len = N;
			int len2=N;
			
			out:
			while (true) { // 한 행씩 돌기
				for (int row = 0; row < N; row++) {
					for (int i = 0; i < N - len + 1; i++) { // 그 행에서 가능한 len만큼 반복 (99면 인덱스1까지, 98이면 인덱스 2까지,,등등)
						int tmp = 0;
						for (int j = 0; j <= len / 2 - 1; j++) { // 회문 검사
							
//							System.out.println("------------------------------------------");
//							System.out.println("지금 len은 " + len + " i는 " + i + " j는 " + j);
//							System.out.printf("%d row, %d번째 행(시작)\n", row, i + j);
//							System.out.printf("%d row, %d번째 행(마지막)\n", row, i + (len - 1) - j);
//							System.out.println("지금 row의 가장 끝 알파벳은 "+cArray[row][i + (len - 1) - j]);
//						
//							System.out.println("len now "+len);
							if (cArray[row][i + j] != cArray[row][i + (len - 1) - j]) {
//								System.out.println("회문 아님 냅다나가버려야 혀 ");
								break;
							} else {
								tmp += 1;
//								max = len;
//								System.out.printf("#%d %d\n", TC, max);
							}
						}
						// 다음 칸으로 넘어가서 회문 검사(같은 len 안에서)
						if (tmp ==  len / 2) {
							max=len;
							break out;
						}
					}
				}
				len-=1;
			} // row 
			
			out2:
			while (true) { // 한 행씩 돌기
				for (int col = 0; col < N; col++) {
					for (int i = 0; i < N - len2 + 1; i++) { // 그 행에서 가능한 len만큼 반복 (99면 인덱스1까지, 98이면 인덱스 2까지,,등등)
						int tmp = 0;
						for (int j = 0; j <= len2 / 2 - 1; j++) { // 회문 검사
							if (cArray[i+j][col] != cArray[i+(len2-1)-j][col]) {
//								System.out.println("회문 아님 냅다나가버려야 혀 ");
								break;
							} else {
								tmp += 1;
							}
						}
						// 다음 칸으로 넘어가서 회문 검사(같은 len 안에서)
						if (tmp ==  len2 / 2) {
							max2=len2;
							break out2;
						}
					}
				}
				len2-=1;

			} // col 
			
			System.out.printf("#%d %d\n", TC, Math.max(max, max2));
		} // main
	}
}
