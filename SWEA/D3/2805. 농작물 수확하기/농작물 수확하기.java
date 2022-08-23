
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			} // 농장 입력받기 완료
			
			for (int i = 0; i < N / 2; i++) {					 //row
				for (int j = N / 2 - i; j <= (N / 2 + i);j++) { //column 
					sum += farm[i][j];
				}
			} // 상단 세모

			for (int i = N / 2; i >= 0; i--) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum += farm[N - i - 1][j];
				}
			} // 하단 세모
			System.out.println("#" + tc + " " + sum);
		} // tc
		sc.close();
	}// main
}
