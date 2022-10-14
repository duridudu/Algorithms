import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// N은 500까지밖에 안되겟지만........... 팩토리얼 하면........ 엄청커지겟지...
		// 그럼 long으로 잡아야되냐 double 등으로 잡아야되냐........... 모르겟는데 일단 long으로 해보기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int ans = 0;
//		long num = N;
//		for (int i = 1; i < N - 1; i++) {
//			num *= (N - i);
//			System.out.println(num);
//		}
		
		int ans=0;
		while (N>=5) {
			ans+=N/5;
			N /= 5;
		}
		System.out.println(ans);
	}
}
