import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_파핑파핑지뢰찾기 {

	static int arr[][],n;
	static int dy[] = {0,-1,-1,-1,0,1,1,1}; // 상 상좌 좌 좌하 하 하우 우 우상
	static int dx[] = {1, 1, 0,-1,-1,-1,0,1};
	// % 팔방탐색하는 인덱스 잘못써서 처음에 값이 제대로 안나왔다 일일이 프린트해줘서 오류찾음
//	static int ddy[] = {-1,1,0,0}; // 상하 좌우
//	static int ddx[] = {0,0,-1,1};
	//큐에서 찾을때도 4방이 아닌 8방탐색을 해야함
	
	static int ans; // 몇번 클릭해야하나
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			ans =0; // swea는 케이스마다 초기화해주는거 잊지말자
			for(int i=0; i<n; i++) {
				String st = br.readLine();
				for(int j=0; j<n; j++) {
					if(st.charAt(j)=='.') arr[i][j] = 10; // . 은 10
					else if(st.charAt(j)=='*') arr[i][j] = -1; // 지뢰는 -1
				}
			}
			//print();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==-1) {
						countBomb(i,j);
					}
				}
			}
			//print();
			
			bfs();
			
			System.out.println("#"+t+" "+ans);
			//print();
			
		}
	}
	
	
	
	private static void bfs() {
		Queue<point> q = new LinkedList<point>();
		boolean visit[][] = new boolean[n][n];
		
		while(true) {
			int ii=n, jj=n;
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					if(arr[i][j]==10 && visit[i][j]==false) { // .(10)인거 다찾아서 저장
						ii = i;
						jj = j;
					}
			
			if(ii==n && jj==n) { // bfs로 다돌렸으면 남으거 카운트해서 종료
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j]!= -1 && visit[i][j] == false) ans++;
					}
				}
				return;
			}
			
			q.add(new point(ii,jj)); // 큐에 넣고
			ans++;// (클릭한번할때마다) 카운트
			
			
			while(!q.isEmpty()) { //bfs돌린다
				point p = q.poll();
				visit[p.r][p.c] = true;
				
				for(int d=0; d<8; d++) {
					int ny = p.r +dy[d];
					int nx = p.c +dx[d];
					
					if(ny <0 || nx <0 || ny>=n || nx >=n) continue; //범위 밖이면 날리고
					if(arr[ny][nx]==-1) continue; //지뢰면 날리고
					if(visit[ny][nx]) continue; //방문했으면 날리고
						
					if(arr[ny][nx]==10) { // .(10)이면 방문체크하고 큐에넣어준다
						visit[ny][nx]=true;
						q.add(new point(ny,nx));
					}else { // 이외의 숫자들은 방문처리만
						visit[ny][nx]=true;
					}
				}
			}
			
		}
		
	}



	private static void countBomb(int i, int j) {
		for(int d=0; d<8; d++) { // 8방탐색했을때
			int ny = i + dy[d];
			int nx = j + dx[d];
			if(ny<0 || nx <0 || ny>=n || nx>=n) continue; //범위밖이면 날리고
			if(arr[ny][nx] == -1) continue; // 지뢰라면 날리고
			
			if(arr[ny][nx]==10) { // 초기값이라면 1더해주고
				arr[ny][nx] =1;
			}else { // 이외의것들은 하나씩 ++
				arr[ny][nx]++;
			}
		}
	}

	static class point{
		int r, c;
		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}

	static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
