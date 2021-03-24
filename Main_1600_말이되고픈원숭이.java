import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1600_말이되고픈원숭이 {
	
	static int K,W,H; //가로 세로
	static int[][] map;
	static boolean[][][] visit;
	static int []dy = {-1,1,0,0}; //상하좌우
	static int []dx = {0,0,-1,1};
	static int []hy = {-1,-2,-2,-1,1,2,2,1}; // 8가지의 이동
	static int []hx = {-2,-1,1,2,-2,-1,1,2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K= sc.nextInt(); // 말처럼 움직일수 있는 횟수
		W= sc.nextInt(); //이게 가로
		H= sc.nextInt(); // 세로
		
		map = new int[H][W]; 
		visit = new boolean[H][W][31];
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs();
		
	}
	
	private static void bfs() {
		Queue<node> q = new LinkedList<node>();
		visit[0][0][0]=true;
		q.add(new node(0,0,0,K));
		
		while(!q.isEmpty()) {
			node n = q.poll();
			int y = n.y;
			int x = n.x;
			int cnt = n.cnt;
			int k = n.k;
			
			if(y==H-1 && x== W-1) {
				System.out.println(cnt);
				return;
			}
			if(y<0 || x <0 || y>=H || x>=W) continue;
			if(map[y][x]==1) continue;
			
			if(visit[y][x][k]) continue;
			visit[y][x][k] = true;
			
			for(int i=0; i<4; i++) {
				int ny = y +dy[i];
				int nx = x +dx[i];
				
				q.add(new node(ny,nx,cnt+1,k));
			}
			if(k ==0) continue;
			for(int i=0; i<8; i++) {
				int ny = y +hy[i];
				int nx = x +hx[i];
				
				q.add(new node(ny,nx,cnt+1,k-1));
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
