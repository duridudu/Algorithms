
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int arr1[] = new int[N];
			int arr2[] = new int[M];
			int arrSums[] = new int[100];
			
			// 카드세트1 저장 
			for (int i = 1; i <= N; i++) {
				arr1[i - 1] = i;
			}
			// 카드세트 2 저장
			for (int i = 1; i <= M; i++) {
				arr2[i - 1] = i;
			}
			
			// 모든 합을 arrSums의 인덱스로 저장해서 카운트 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int num = arr1[i] + arr2[j];
					arrSums[num] += 1;
				}
			} // 합 저장
			
			int max = arrSums[0];
			// 최댓값 구하기 
			for (int i = 0; i < arrSums.length; i++) {
				if (arrSums[i] >= max) {
					max = arrSums[i];
				} 
			}
			
			// 최댓값에 해당하는 원소 출력하기 
			System.out.printf("#%d ", tc);
			for (int i=0;i<arrSums.length;i++) {
				if (arrSums[i]==max) {
					System.out.printf("%d ", i);
				}
			}
            System.out.println();
		} // tc
	}// main
}
