
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
		// 나머지 1,2 경우밖에 없으니까여 두 개 수동으로 계산했더요
		if (mod == 1) {
			// 나머지 1일때는 맨 앞 한자리만 짤리니까 걔 숫자를 저장해여
			sb.append(N.charAt(0) - '0');
		} else if (mod == 2) {
			// 나머지 2일때는 앞에서 두개 잘리니까 첫번째거*2+두번째거*1한거 더해서 Sb에 저장해여
			sb.append(2 * (N.charAt(0) - '0') + (N.charAt(1) - '0'));
		}
		// 시작 인덱스를 구해여 
		int idx = n - 3 * (n / 3);
		// 여기는 3으로 잘 짤리는 구간이라 1,2,3번째거에 각각 4,2,1 곱해서 더하고 sb에 추가해주면 댑니당 
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
