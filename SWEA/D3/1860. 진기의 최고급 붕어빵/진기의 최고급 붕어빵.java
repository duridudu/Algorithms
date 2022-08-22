
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
        // 테스트 케이스 
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
            
            // 붕어빵 사러오는 초를 입력받을 배열
			int[] customers = new int[N];
			for (int i = 0; i < N; i++) {
				customers[i] = sc.nextInt();
			}
            // 오름차순으로 정렬
			Arrays.sort(customers);
			
            // 가능한지 안한지 플래그 사용, 초기화는 Possible로
			String flag = "Possible";
			
            // 손님 수만큼 반복문 돌며 불가능하면 플래그를 Impossible로 바꾸고 종료, 아니면 그대로 유지
			for (int i = 0; i < N; i++) {
                // 손님이 오는 초에 만들 수 있는 붕어빵의 개수
				int numFish = customers[i] / M * K;
                // numFish가 현재 초보다 작으면 붕어빵 못 주므로 불가능으로 바꿔야함
				if (numFish < i + 1) {
					flag = "Impossible";
					break;
				}
			}
			
			System.out.printf("#%d %s\n", tc, flag);
		} // TC
		sc.close();
	}// main
}
