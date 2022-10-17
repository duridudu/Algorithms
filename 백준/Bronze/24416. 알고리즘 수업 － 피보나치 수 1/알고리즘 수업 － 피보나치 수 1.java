import java.util.Scanner;

public class Main {
	static int rec;
	static int dp;
	static int[] dpArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dpArr = new int[41];
		rec=1;
		dp=0;
		fiboRec(num);
		fiboDp(num);
		System.out.println(rec + " " + dp);
	}

	private static int fiboRec(int num) {
		if (num == 1 || num == 2) {
			return 1;
		} else {
			rec++;
			return (fiboRec(num - 1) + fiboRec(num - 2));
		}
	}
	
	private static int fiboDp(int num) {
		dpArr[1]=1;
		dpArr[2]=1;
		for (int i=3; i<=num;i++) {
			dpArr[i]=dpArr[i-1]+dpArr[i-2];
			dp++;
		}
		return dpArr[num];
	}

}
