
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			} // arr 채우기 완료

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1 - i; j++) {
					if (arr[j + 1] < arr[j]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}

			} // 정렬 완료
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
		} // TC

		sc.close();
	}// main
}
