
import java.util.Scanner;

public class Main {
	public static int isPrime(int n) {
		if (n==1) {
			return 0;
		}
		
		for (int i = 2; i<=(int)Math.sqrt(n); i++) {
	      if (n % i == 0) {
	          return 0;
	      }
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int sum=0;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			sum+=isPrime(a);
		}//for
		
		System.out.println(sum);
	}
}
