
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		} // 배열 입력 완료

		int lost = arr[0];
		int ans = 0;
		// 벌벌꿀
		for (int i = 1; i < N; i++) {
			// 2번 벌은 1번 벌 인덱스부터 i까지 못먹음 (자기 왼쪽)
			lost += arr[i];
			ans = Math.max(ans, sum - arr[0] + sum - lost - arr[i]);
		}

		// 꿀벌벌
		lost = arr[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			// 2번 벌은 1번 벌 인덱스(맨 오른쪽)부터 i까지 못먹음 (자기 오른쪽)
			lost += arr[i];
			ans = Math.max(ans, sum - arr[N - 1] + sum - lost - arr[i]);
		}

		for (int i = 1; i < N; i++) {
			ans = Math.max(ans, sum - arr[0] - arr[N - 1] + arr[i]);
		}
		System.out.println(ans);
	}// main
}
