import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어 {
	
	//0 상 좌상 좌 좌하 하 우하 우 우상
	// 0 1  2  3   4  5  6   7  8
	// (t+i)%8
	static int dy[] = {0,-1,-1,0 ,1, 1,1,0,-1}; 
	static int dx[] = {0,0 ,-1,-1,-1,0,1,1, 1};
	static fish arr[][];
	static boolean sharkEat[]; // 상어가 먹은 물고기 번호
	static int maxSum; // 상어가 잡아먹은 최대 물고기번호 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new fish[4][4];
		sharkEat = new boolean[17];
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[i][j] = new fish(a,b);
			}
		}

		//상어가 먹음
		sharkEat[arr[0][0].n] =true;
		shark s = new shark(0,0,arr[0][0].d);
		arr[0][0] = null;

		moveShark(s);
		
		System.out.println(maxSum);
	}
	
	private static void moveFish(shark s) {
		
		for(int t=1; t<=16; t++) {
			if(sharkEat[t]) continue; //상어가 먹은물고기 번호는 패스
			
		  loop:for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
				 if(arr[i][j]!=null && arr[i][j].n==t) {
					 
					 for(int d=0; d<8; d++){
						 // 0 - 7
						 int ny,nx;
						 int fdir = arr[i][j].d; // 4
						 int fn = arr[i][j].n; // 5
						 
						 if(fdir+d > 8) {
							 ny = i + dy[(fdir +d)%8];
							 nx = j + dx[(fdir +d)%8];
						 }else {
							 ny = i + +dy[fdir+d];
							 nx = j + +dx[fdir+d];
						 }
						 
						 if(ny<0 || nx <0 || ny>=4 || nx >=4) continue;
						 if(ny == s.r && nx == s.c) continue; // 상어가 있거나
						 
						 //*문제 숙지 부족* 물고기가 방향을 틀어서 바꿀경우 해당 물고기의 방향값이 바뀐다
						 if(fdir+d >8) arr[i][j].d = (fdir+d)%8;
						 else  arr[i][j].d = fdir+d;
							 
						 fish temp = arr[ny][nx];
						 arr[ny][nx] = arr[i][j];
						 arr[i][j] = temp;
						 //print();
						 break loop; //해당 번호 물고기가 교환되었으면 다음으로
					 } 
				 }
				}
			}
		}
	}

	private static void moveShark(shark shk) {
		
		//물고기 움직임
		moveFish(shk);

		boolean isDone=true;
		for(int i=0; i<4; i++) {
			int ny = shk.r + dy[shk.d]*i;
			int nx = shk.c + dx[shk.d]*i;
			if(ny<0 || nx<0 || ny>=4 || nx >=4) continue;
			if(arr[ny][nx]==null) continue;
			isDone=false;
		}
		if(isDone) {
			int tmpSum=0;
			for(int i=1; i<17; i++) {
				if(sharkEat[i]) tmpSum+=i;
			}
			if(tmpSum > maxSum) maxSum = tmpSum; 
		}

		
		//상어 움직임 , 못할때까지
		for(int i=1;i<4; i++) { //4X 4 배열이니 최대 3
			int ny = shk.r + (dy[shk.d])*i;
			int nx = shk.c + (dx[shk.d])*i;
			
			if(ny<0 || nx<0 || ny>=4 || nx >=4) continue;
			if(arr[ny][nx]==null) continue;
			
			//백트래킹을 위해 임시배열을 만들어서 값을 담아놓는다
			//* 주의할점 * 자료형이 클래스인 2차원배열을 깊은복사 할때는 값을 = 해서 그대로 저장하는게 아니라
			// new()~~ 로 생성자를 하나하나 다시 생성해줘야한다.
			
			fish tmpArr[][] = new fish[4][4]; //백트래킹을 위한 임시 배열
			for(int ii=0; ii<4; ii++) {
				for(int jj=0; jj<4; jj++) {
					if(arr[ii][jj]!=null) tmpArr[ii][jj] = new fish(arr[ii][jj].n, arr[ii][jj].d);
				
					else tmpArr[ii][jj] =null;
				}
			}
			
			fish tmpFish = arr[ny][nx]; // 백트래킹을 위한 임시 피쉬
			sharkEat[tmpFish.n]= true;
			arr[ny][nx]= null;		
			
			moveShark(new shark(ny, nx, tmpFish.d));
		
			
			sharkEat[tmpFish.n] = false; //백트래킹
			for(int ii=0; ii<4; ii++) {
				for(int jj=0; jj<4; jj++) {
					if(tmpArr[ii][jj]!=null) arr[ii][jj] = new fish(tmpArr[ii][jj].n, tmpArr[ii][jj].d);
					else arr[ii][jj] =null;
				}
			}
	
		}
		
	}
	

	

	static class fish{
		int n, d;
		public fish(int n, int d) {// 번호 방향
			this.n = n;
			this.d = d;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return " "+this.n;
		}
	}
	static class shark{
		int r,c, d; // 위치 방향
		public shark(int r, int c,int d) {
			this.r = r;
			this.c = c;
			this.d =d;
		}
	}
	
	static void print() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(arr[i][j]);
				if(arr[i][j]!=null) System.out.print("/"+arr[i][j].d);
			}
			System.out.println();
		}
		System.out.println();
	}
}
