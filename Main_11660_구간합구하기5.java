import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // n행n열 맵
		int m = Integer.parseInt(st.nextToken()); // 연산횟수
		int arr[][] = new int[n+1][n+1];
		int dp[][] = new int[n+1][n+1];
		int sum=0;
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		

		
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {			
				dp[i][j] = dp[i][j-1]+dp[i-1][j] - dp[i-1][j-1] + arr[i][j]; 
			}
		}
		
		for(int i=0; i<n+1; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		for(int t=0; t<m; t++) {
			sum=0;
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 2
			int y = Integer.parseInt(st.nextToken()); // 2
			int x2 = Integer.parseInt(st.nextToken()); //3
			int y2 = Integer.parseInt(st.nextToken()); //4
			
			sum = dp[x2][y2] - dp[x-1][y2] - dp[x2][y-1] + dp[x-1][y-1];
			
			System.out.println(sum);
		}
		
		
	}

	
}
