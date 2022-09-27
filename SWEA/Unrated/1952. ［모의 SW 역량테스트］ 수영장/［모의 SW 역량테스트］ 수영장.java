
import java.util.Scanner;
import java.util.*;

public class Solution {
	static int[] price;
	static int[] month;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			month = new int[13];
			// 가격, 월별계획 입력 완.
			for (int i = 0; i < 4; i++) {
				price[i] = sc.nextInt();
			}
			for (int i = 1; i < 13; i++) {
				month[i] = sc.nextInt();
			}
			// dp 저장할 배열
			int[] dp = new int[13];

			// 1,2개월치 저장
			dp[0] = 0;
			dp[1] = Math.min(month[1] * price[0], price[1]); // 첫 달은 무조건 price[1]
			dp[2] = Math.min(dp[1] + month[2] * price[0], dp[1] + price[1]); // 둘째달은 1월 + (2월 이용계획 * 1일 이용 ) vs 1월 + 1달
																				// 이용

			// 3월부터 12월까지 반복
			for (int i = 3; i <= 12; i++) {
				// 그때마다 dp 배열은 다음 세 개 중 작은 값으로 채워짐
				// min(전 달+해당 달*하루 이용, 전 달+한달 이용, 전전전달 + 세달 이용)
				dp[i] = Math.min(dp[i - 1] + month[i] * price[0], Math.min(dp[i - 1] + price[1], dp[i - 3] + price[2]));

				// 12월일때는 1년 이용권 비교도 해야하므로 price[3] 등장
				if (i == 12) {
					dp[i] = Math.min(dp[i], price[3]);
				}
			}
			// dp 배열의 가장 마지막 원소 출력하면 답
			System.out.println("#" + tc + " " + dp[12]);
		}
	}
}