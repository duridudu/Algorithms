
import java.util.Scanner;

public class Solution {

	static int[] sorted;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			StringBuilder sb = new StringBuilder();
			sorted = new int[N];

			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			// arr, left, right 삽입 후 재귀
			mergeSort(arr, 0, N - 1);

			System.out.print("#" + tc + " ");
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i] + " ");
			}
			System.out.println(sb);
		}

	}

	static void mergeSort(int[] arr, int left, int right) {
		// 왼 인덱스가 오 인덱스보다 작을때
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid); // 왼쪽 분할
			mergeSort(arr, mid + 1, right);// 오른쪽 분할
			merge(arr, left, mid, right);// 정렬하며 합치기
		}
	}

	static void merge(int[] arr, int left, int mid, int right) {
		int L = left; // 왼쪽 시작 인덱스
		int R = mid + 1; // 오른쪽 시작 인덱스
		int idx = left; // sorted에 넣을 인덱스

		while (L <= mid && R <= right) { // 왼 인덱스가 중간보다 작거나 같고, 오 인덱스가 맨오른쪽보다 작거나 같을 때만 반복
			// 왼쪽이 오른쪽보다 작으면 ㅇㅋ하고 인덱스 왼 전진
			if (arr[L] <= arr[R]) {
				sorted[idx] = arr[L++];
			}
			// 반대면 ㅇㅋ하고 인덱스 오 전진
			else {
				sorted[idx] = arr[R++];
			}
			idx++;
		}

		// 위 과정 후 왼쪽 혹은 오른쪽에 남아있는 경우 처리 
		if (L <= mid) { // 왼쪽이 남
			while (L <= mid) {
				sorted[idx++] = arr[L++];
			}
		} else { // 오른쪽이 남
			while (R <= right)
				sorted[idx++] = arr[R++];
		}
		// arr에 정렬된 원소 채우기 
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}

	}
}
