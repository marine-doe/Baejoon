import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int[] cake = new int[l + 1];
		
		int n = sc.nextInt();
		int[] nCount = new int[n + 1];
		
		int max = 0;
		int idx = 0;
		for(int i = 1; i <= n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(b - a + 1 > max) { // 케이크 욕심
				max = b - a + 1;
				idx = i;
			}
			
			for(int j = a; j <= b; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					nCount[i]++; // 실제 가져간 케이크
				}
			}
		}
		
		max = 0;
		int realIdx = 0;
		for(int i = 1; i <= n; i++) {
			if(nCount[i] > max) {
				max = nCount[i];
				realIdx = i;
			}
		}
		
		System.out.println(idx);
		System.out.println(realIdx);
	}
}