import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_키순서 {
	
	static int n,m;
	static int INF = 501; // 의미없는 큰값
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans =0; // 자신의키를 알수있는 학생의 수
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int arr[][] = new int[n+1][n+1]; // 플로이드워샬 알고리즘 2차원배열
		
		for(int i=1; i<=n; i++) Arrays.fill(arr[i], INF);
		for(int i=1; i<=n; i++) arr[i][i] = 0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1; // 경로가 존재하면 1로 값을 준다
		}
		print(arr);
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(arr[i][j] > arr[i][k]+ arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j]; //플로이드워샬 구조
					}
				}
			}
		}
		print(arr);
		
		int path[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue; //자기자신에서 자기자신으로는 넘기고
				if(arr[i][j] <INF) { // i j로가는 값이 존재한다면
					// 자기로 오거나 자기가 갈 수잇는 경우가 n개중에 자기자신을뺀 n-1경우가 나오면 그건 모두의 위치를 알고있으므로 
					// 자기가 몇번째인지 확인이가능하다
					path[i] +=1;
					path[j] +=1;
				}
			}
		}
		
		System.out.println(Arrays.toString(path));
		for(int i : path) {
			if(i==n-1) ans++;
		}
		

		
		System.out.println(ans);
	}
	static void print(int arr[][]) {
		for(int i=1; i<=n; i++) {
			System.out.print("("+i+"번)  ");
			for(int j=1; j<=n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

