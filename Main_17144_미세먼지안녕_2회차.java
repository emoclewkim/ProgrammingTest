import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕_2회차 {
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static int  R,C,T;
	static int arr[][];
	static int UAC,DAC; //공기청정기 위치
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) {
					DAC = i;
				}
			}
		}
		UAC = DAC-1;
//		print();
		for(int t=0; t<T; t++) { //****공기청정기와 미세먼지 순서를 바꿔서짜가지고 다시 수정했다. 그이외에 로직에는 이상없었다. 다시 푼문제라 로오류는 없었다.
			spread();
//			System.out.println("미세먼지확산");
//			print();
			aircondition();
//			System.out.println("공기청정기작동");
//			print();
		}
		
		int ans=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]==-1)continue;
				
				ans += arr[i][j];
			}
		}
		System.out.println(ans);
		
	}
	private static void spread() {
		int tarr[][] = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]!=0) {
					int cnt =0;
					for(int t=0; t<4; t++) {
						int ny = dy[t]+i;
						int nx = dx[t]+j;
						
						if(ny <0 || nx <0 || ny >=R || nx >=C) continue;
						if(arr[ny][nx]==-1) continue;
						
						tarr[ny][nx] += arr[i][j]/5;
						cnt++;
					}
					arr[i][j] -= (arr[i][j]/5)*cnt;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]==-1) continue;
				arr[i][j]+= tarr[i][j];
			}
		}
		
	}
	private static void aircondition() {
				for(int i=UAC-1; i>0; i--) {
					arr[i][0] = arr[i-1][0];
				}
				for(int i=0; i<C-1; i++) {
					arr[0][i] = arr[0][i+1];
				}
				for(int i=0; i<UAC; i++) {
					arr[i][C-1] = arr[i+1][C-1];
				}
				for(int i=C-1; i>0; i--){
					arr[UAC][i] = arr[UAC][i-1]; 
				}
				arr[UAC][1]=0;
				
				for(int i=DAC+1; i<R-1; i++){ //*** 공기청정기가 작동할 때 아래에 있는 공기청정기를 아예없애버려서 수정했
					arr[i][0] = arr[i+1][0];
				}
				for(int i=0; i<C-1; i++) {
					arr[R-1][i]= arr[R-1][i+1];
				}
				for(int i=R-1; i>DAC; i--) {
					arr[i][C-1] = arr[i-1][C-1];
				}
				for(int i=C-1; i>0; i--) {
					arr[DAC][i] = arr[DAC][i-1];
				}
				arr[DAC][1]=0;
	}
	
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
