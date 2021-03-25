import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n];
			int dp[] = new int[n];
			dp[0] =1;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<n; i++) {
				dp[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[j] <arr[i] && dp[j]+1 > dp[i]) {
						dp[i] = dp[j] +1;
					}
				}
			}
			Arrays.sort(dp);
			System.out.println("#"+t+" "+dp[n-1]);
		}
	}

}
