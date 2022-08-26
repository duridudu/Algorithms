
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 알파벳 26개 저장
			int arr[] = new int[27];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				int idx = (int) str.charAt(0) - 64; // A=64이므로 1로 바꿔서 인덱스 저장.
				arr[idx] += 1;
			} // 입력받은 알파벳 개수 세서 arr에 저장 완
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				// 인덱스 1인 A부터 시작
				if (arr[i + 1] >= 1) {
					cnt += 1;
				} else {
					break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
