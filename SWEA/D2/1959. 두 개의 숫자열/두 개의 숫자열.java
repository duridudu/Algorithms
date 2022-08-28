
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, M;
	static int[] arrN;
	static int[] arrM;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arrN = new int[N];
			arrM = new int[M];
			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			Arrays.toString(arrN);
			for (int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}
			int max = 0;
			if (N > M) {
				max = calSum(arrM, arrN);
			} else {
				max = calSum(arrN, arrM);
			}
			System.out.println("#" + tc + " " + max);
		} // TC
		sc.close();
	}// main

	private static int calSum(int[] shorts, int[] longs) {
		int max = 0;
		for (int j = 0; j <= longs.length - shorts.length; j++) {
			int i = 0;
			int tmp = j;
			int sum = 0;
			while (i < shorts.length) {
				sum += shorts[i] * longs[tmp];
				i++;
				tmp++;
			}
			max = Math.max(sum, max);
		}
		return max;
	}
}
