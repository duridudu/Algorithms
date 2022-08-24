
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // arr 입력
			
			int[][] arr90 = Rotation(arr);
			int[][] arr180 = Rotation(arr90);
			int[][] arr270 = Rotation(arr180);
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.print("\n");
			}// 출력 
		}//tc
	}// main

	private static int[][] Rotation(int[][] a) {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// i는 j 끝날때까지 고정 - temp에게는 행, arr에게는 열 (지금은 arr 행이 아래에서 위로 가야하므로)
				temp[i][j] = a[N - j - 1][i];
			}
		}
		return temp;
	}

}
