import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2 {
	
	static int []dy = {-1,1,0,0}; //상하좌우
	static int []dx = {0,0,-1,1};
	static int M,N,K, arr[][];
	static boolean visit[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M][K+1];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs();
		
	}
	
	private static void bfs() {
		Queue<node> q = new LinkedList<node>();
		visit[0][0][0] =true;
		q.add(new node(0,0,1,K));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			int y = n.y;
			int x = n.x;
			int cnt = n.cnt;
			int k = n.k;
			
			if(y==N-1 && x ==M-1) {
				System.out.println(cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y +dy[i];
				int nx = x +dx[i];
				
				if(ny<0 || nx <0 || ny>=N || nx>=M) continue;
				if(visit[ny][nx][k]) continue;
				
				visit[ny][nx][k] =true;
				
				if(arr[ny][nx] ==1) {
					if(k==0) continue;
					q.offer(new node(ny,nx,cnt+1,k-1));
				}else {
					q.offer(new node(ny,nx,cnt+1,k));
				}
				
			}

		}
		System.out.println(-1);
		return;
	}
	
	static class node{
		int y,x,cnt,k;
		
		node(int y, int x, int cnt, int k){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.k = k;
		}
	}
}
