import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_14503_로봇청소기 {
	static int dy[] = {-1,1,0,0};//상하 좌
	static int dx[] = {0,0,-1,1};
	static int N,M;
	//static int r, c; // 로봇이 있는 좌표
	//static int d; // 로봇이 바라보는 방향 상우하좌 - 0123	
	static int map[][];
	static int ans; //청소하는칸의 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ans =0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//현재칸 1칸 청소
		ans++;
		map[r][c]=9;
		
		clean(r,c, d);
	}
	static void clean(int r, int c, int d) {
		//hello
	}

}
