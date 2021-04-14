import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int dy[] = {0,-1,0,1}; // 우상좌하
	static int dx[] = {1,0,-1,0}; 
	static int ny[] = {0,1,0,-1}; // 우하좌상
	static int nx[] = {1,0,-1,0};
	static int r,c,t; //세로 가로 몇초후
	static int arr[][]; // 맵
	static int arr2[][];
	static int Uair ; // 공기청정기 위에꺼 행
	static int Dair; // 공기청정기 아래꺼 행
	static ArrayList<point> list; // 미세먼지 좌표값 리스트
	static int sum; // 미세먼지 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		list = new ArrayList<>();
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) Dair = i; // 공기청정기 아랫행 저장, 열은 어차피 0
				else if(arr[i][j]!=0) list.add(new point(i,j)); // 미세먼지 위치들 저장
			}
		}
		Uair = Dair-1; //공기청정기 윗행 저장

		search();
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i][j]!=-1) {					
					sum += arr[i][j];
				}
			}
		}
		System.out.println(sum);
	}
	
	private static void search() {

		for(int z=0; z<t; z++) { // t초 만큼 실행
			
			int dustCnt = list.size(); // 미세먼지 개수
			arr2 = new int[r][c];
			
			for(int i=0; i<dustCnt; i++) { // 처음 있는미세먼지만 확산
				int row = list.get(i).row;
				int col = list.get(i).col;
				int cnt =0;
				
				for(int j=0; j<4; j++) {
					int nr = dy[j] + row;
					int nc = dx[j] + col;
					if(nr<0 || nc <0 || nr >=r || nc >=c) continue; // 범위밖이면 날리고
					if(arr[nr][nc]==-1) continue; // 공기청정기쪽으로는 확산되지 않고
			
					arr2[nr][nc]+= arr[row][col]/5; // 미세먼지 확장을 위한 값을 따로 저장후 나중에 원래배열과 합친다
					cnt++;		
				}
				arr[row][col] = arr[row][col] -(cnt*(arr[row][col]/5));
			}
			
			for(int i=0; i<r; i++) { //따로 저장해둔 배열값을 합친다
				for(int j=0; j<c; j++) {
					if(arr[i][j]!=-1) {
						arr[i][j] += arr2[i][j];
					}
				}
			}
			//System.out.println(dustCnt);
			//print();
			
			//공기청정기 가동
			//공기청정기가 미세먼지를 밀어낸다고 생각하지않고 반대방향으로 하나씩 끌어당긴다고 생각.. 
			int top = Uair;
			int down = Dair;
			
			//위쪽공기청정기
			for(int i= top-1; i>0; i--)
				arr[i][0] = arr[i-1][0];
			for(int i=0; i<c-1; i++)
				arr[0][i] = arr[0][i+1];
			for(int i=0; i<top; i++)
				arr[i][c-1] = arr[i+1][c-1];
			for(int i=c-1; i>1; i--)
				arr[top][i] = arr[top][i-1];
			arr[top][1]=0; //공기청정기에서 나온바람은 좋은바람
			
			//아랫쪽공기청정기
			for(int i=down+1; i<r-1; i++)
				arr[i][0] = arr[i+1][0];
			for(int i=0; i<c-1; i++)
				arr[r-1][i] = arr[r-1][i+1];
			for(int i= r-1; i>down; i--)
				arr[i][c-1] = arr[i-1][c-1];
			for(int i=c-1; i>1; i--)
				arr[down][i] = arr[down][i-1];
			arr[down][1]=0;//공기청정기에서 나온바람은 좋은바람
			
			//print();
			
			list = new ArrayList<>(); 
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(arr[i][j]!=-1 && arr[i][j]!=0) { //새롭게 다시 먼지 몇갠지 샌다
						list.add(new point(i,j));
					}
				}
			}
			
		}
	}

	static class point{
		int row,col;
		
		public point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static void print() { // 배열을 출력해보기 위한 함수
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}
