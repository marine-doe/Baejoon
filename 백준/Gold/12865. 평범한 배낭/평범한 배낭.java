import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Thing implements Comparable<Thing>{
		int w, v;

		public Thing(int w, int v) {
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Thing o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		PriorityQueue<Thing> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			pq.offer(new Thing(w, v));
		}
		
		int[][] dp = new int[2][k + 1];
		
		for (int i = 0; i < n; i++) {
			Thing cur = pq.poll();
			for (int j = 1; j <= k; j++) {
				if(j >= cur.w) {
					dp[1][j] = Math.max(dp[0][j], dp[0][j - cur.w] + cur.v);
				}
			}
			
			for (int j = 0; j < k+1; j++) {
				dp[0][j] = dp[1][j];
			}
		}
		
		System.out.println(dp[1][k]);
	}
}