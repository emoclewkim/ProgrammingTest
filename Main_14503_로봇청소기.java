import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_14503_로봇청소기 {
	static int dy[] = {-1,0,1,0};//상우하좌 0123
	static int dx[] = {0,1,0,-1};
	//왼쪽 0->3  1->0  2->1 3->2
	// (d+3)%4
	// 후진 0->2 1->3 3->1 2->0
	// (d+2)%4
	static int N,M;	
	static int map[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇청소기 위치
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken()); // 쳐다보는 방향 
		int ans =0;	//청소한 칸의 개수
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		map[r][c]=9; 
		// 9는 청소한 구역 - 1번 조건을 없애고 a뒤에 가져다붙인다 그래서 맨처음함수들어가기전에 1번조건 한번 실	행
		clean(r,c, d);
	
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==9) ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	static void clean(int r, int c, int d) {
		int leftD = (d+3)%4; //왼쪽방향
		int backD = (d+2)%4; // 뒤방향
		
		int ly = r + dy[leftD];
		int lx = c + dx[leftD];
		
		int by = r + dy[backD];
		int bx = c + dx[backD];
		
		int y0 = r+dy[0]; 
		int x0 = c+dx[0];
		int y1 = r+dy[1];
		int x1 = c+dx[1];
		int y2 = r+dy[2];
		int x2 = c+dx[2];
		int y3 = r+dy[3];
		int x3 = c+dx[3];
		// **여기 코드에서 r c 로 해줘야하는데 r  r r r 로 해줘서 오타 나서 계속 프린트로 찍어보면서 오류 찾고 결국 해결 로직은 애초에 맞았음
			
		
		if(map[ly][lx]==0) { // a 왼쪽방향에 청소하지 않은 공간이 존재한다면 
			map[ly][lx] =9; // 먼저 청소하고
			clean(ly,lx,leftD); // 2번 으로 돌아간다
		}else if(map[ly][lx]!=0 &&
				(map[y0][x0]==0||
				map[y1][x1]==0||
				map[y2][x2]==0||
				map[y3][x3]==0)) { //b 왼쪽이 청소되있고 나머지방향중 하나라도 청소가 안되있는공간이라
			clean(r,c,leftD);
		}else if(map[y0][x0]!=0 && 
				map[y1][x1]!=0 && 
				map[y2][x2]!=0 && 
				map[y3][x3]!=0 && 
				map[by][bx]==9){// c 네 방향 다청소되어있거나 벽이고 뒤 방향이 벽이아닐 때
			clean(by,bx,d); //바라보는 방향 유지한채로 한칸 후진하고 2번 으로 돌아간다
		}else {
			return;// d 다막혀있으면 더 가지않고 그대로 종료
		}
	}
	
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
					System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}	
		System.out.println();
	}

}
