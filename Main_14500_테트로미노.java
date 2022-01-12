import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_14500_테트로미노 {
	static int N,M;
	static int arr[][];
	static int dy[] = {0,0,1,-1};
	static int dx[] = {-1,1,0,0};
	static int ans,sum;
	static boolean vst[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;//
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		ans = 0;
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				vst = new boolean[N][M];

				sum=arr[i][j];
				vst[i][j]=true;
				
				dfs(i,j,1,sum);
			}
		}
		System.out.println(ans);
		
	}
	
	private static void dfs(int r, int c, int cnt, int sum) {
		if(cnt==4){
			if(sum > ans){
				//System.out.println(sum);
				ans = sum;
			}
			return;
		}
		
		for(int d=0; d<4; d++){
			int ny = r + dy[d];
			int nx = c + dx[d];
			
			if(ny<0 || nx<0 || ny>=N || nx >=M) continue;
			if(vst[ny][nx]) continue;
			
			vst[ny][nx] =true;
			dfs(ny,nx,cnt+1,sum+arr[ny][nx]);
			vst[ny][nx] =false;
		}
	}

}
