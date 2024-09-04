import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] prefix = new int[n + 1];
        int sum = 0;
        for(int i= 1;i<n+1;i++){
            sum+=arr[i-1];
            prefix[i]=sum;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<m;i++){
            st =new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int answer=prefix[end]-prefix[start-1];
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
}