import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1890_점프 {

	static int arr[][],n;
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //4
		arr = new int[n][n]; // 44
		dp = new long[n][n];
		
		
		for(int i=0; i<n; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] =1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i==n-1 && j==n-1) continue;
				int next = arr[i][j];
				
				if(i +next < n ) dp[i+next][j] += dp[i][j]; //따로 선언해둔 dp배열에 간 횟수만큼 체크해준다
				
				if(j+ next < n ) dp[i][j+next] += dp[i][j];
				//System.out.println(i+" "+j);
				//print();
			}
			
		}
		
		System.out.println(dp[n-1][n-1]);
		
	}

	static void print() {
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println();
	}
}
