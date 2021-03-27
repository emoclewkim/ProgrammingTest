import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {
	static int dy[] = {-1,1,0,0}; // 상하좌우
	static int dx[] = {0,0,-1,1};
	static int W, H ; // 가로 ㅅㅔ로
	static char arr[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new char[H][W];
			visit = new boolean[H][W];
			pos sg = new pos(0,0,1);
			ArrayList<pos> fire = new ArrayList<pos>(); 
			
			for(int i=0; i<H; i++) {
				String str = br.readLine();
				for(int j=0; j<W; j++) {
					arr[i][j] = str.charAt(j);
					if(arr[i][j]=='@') {
						sg.r =i;
						sg.c =j;
					}else if(arr[i][j]=='*') {
						fire.add(new pos(i,j));
					}
				}
			}

			bfs(sg,fire);
			
		}
	}
	private static void bfs(pos sg, ArrayList<pos> fire) {
		Queue<pos> q = new LinkedList<pos>();
		Queue<pos> f = new LinkedList<pos>();
		q.offer(sg);
		
		for(int i=0; i<fire.size(); i++) {
			f.offer(fire.get(i));
		}
		
		while(!q.isEmpty()) {

			
			
			int fsize = f.size();
			for(int i=0; i< fsize; i++) {
				pos firetemp = f.poll();
				for(int j=0; j<4; j++) {
					int ny = firetemp.r +dy[j];
					int nx = firetemp.c +dx[j];
					if(ny<0 || nx<0 || ny>=H || nx >=W) continue;
					if(arr[ny][nx]=='.') {
						arr[ny][nx] = '*';
						f.offer(new pos(ny,nx));
					}
				}
			}
			int qsize = q.size();
			for(int w=0; w<qsize; w++) {				
				pos temp = q.poll();
				int r = temp.r;
				int c = temp.c;
				int t = temp.t;
	
				for(int i=0; i<4; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					
					if(ny<0 || nx<0 || ny>=H || nx >=W){
						System.out.println(t);
						return;
					}
	
					if(arr[ny][nx]=='.' && visit[ny][nx]==false) {
						
						visit[r][c] = true;
						arr[ny][nx]='@';
						q.add(new pos(ny,nx,t+1));
					}
				}
			}
			
			//print();
		}
		System.out.println("IMPOSSIBLE");
		return;
	}

	
	
	static class pos{
		int r, c, t;
		
		public pos(int r, int c ,int t) {
			this.r =r;
			this.c =c;
			this.t = t;
		}
		
		public pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static void print() {
		for(int i=0; i<H; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}
}
