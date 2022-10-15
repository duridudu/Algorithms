
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String N = sc.next();
//		// 방법1. 함수쓰기
//		int answer = Integer.parseInt(N, 2);
//		String ans = Integer.toString(answer, 8);
//		answer = Integer.parseInt(ans);
//		System.out.println(answer);
		// 웨안되지 -> 너무 오래걸리고 비효율적이라고 이렇게 하진 말랜다..

		// 방법2. 직접 계산해여
		// 11/001/100 8/3=2, 8%3=2 그럼 몫만큼 3번씩 for문 돌리고, 나머지만큼 따로...
		int n = N.length();
		int mod = n % 3;
		if (mod == 1) {
			sb.append(N.charAt(0) - '0');
		} else if (mod == 2) {
			sb.append(2 * (N.charAt(0) - '0') + (N.charAt(1) - '0'));
		}
		int idx = n - 3 * (n / 3);
		for (int i = idx; i < n; i += 3) {
			int now = N.charAt(i) - '0';
			int now2 = N.charAt(i + 1) - '0';
			int now3 = N.charAt(i + 2) - '0';
			int temp = now * 4 + now2 * 2 + now3 * 1;
			sb.append(temp);
		}
		System.out.println(sb);
	}
}
