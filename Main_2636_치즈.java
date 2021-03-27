import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N, M;
	static int arr[][];
	static boolean visit[][];
	static int dy[] = {-1,1,0,0};//상하좌우
	static int dx[] = {0,0,-1,1};
	static int time;//치즈가 모두 녹아 없어지는 시간
	static int cheeseCnt; //녹을 예정인 치즈들 갯수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
	}


	
	private static void bfs() {
		Queue<node> q = new LinkedList<node>();
		visit = new boolean[N][M]; // 치즈를 한번 녹일때마다 방문햇던기록을 초기화시켜줘야한다 이걸안해서처음에 값이이상하게나
		q.offer(new node(0,0));
		int tempCnt=0; // 녹일치즈 임시값
		while(!q.isEmpty()) {
			node qq = q.poll();
			int y = qq.y;
			int x = qq.x;
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx >= M) continue;
				if(arr[ny][nx]==2) continue;
				if(arr[ny][nx]==1) {//공기와 맡닿아있는 1과만난다면 녹일예정치즈인 2로바꾼다
					tempCnt++;
					arr[ny][nx] = 2;
				}
				if(arr[ny][nx]==0 && visit[ny][nx]==false) {
					visit[ny][nx]= true;
					q.offer(new node(ny,nx));
				}
			}
		}
		
		if(tempCnt==0) { // 녹일치즈가 하나도없다면 걸린시간과 직전에 녹였던 치즈개수를 출
			System.out.println(time);
			System.out.println(cheeseCnt);
			return;
		}else { // 녹일치즈가 존재하면 녹이려고 하는치즈개수를 cheeecnt에 저장한뒤 치즈를 녹이고 다시 bfs를 돌린
			cheeseCnt = tempCnt;
			time++;
			meltCheese();
			bfs();
		}
		
	}



	private static void meltCheese() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==2) arr[i][j]=0;	
			}
		}
		
	}



	static class node{
		int y,x;
		
		node(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

}
