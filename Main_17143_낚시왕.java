import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	
	static int R,C,m;
	static shark arr[][];
	static int sharkSum; //상어크기함
	static int dy[] = {0,-1,1,0,0}; //X상하우좌 01234
	static int dx[] = {0,0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new shark[R+1][C+1]; // 1부터라서 한칸 늘려줬다
		sharkSum=0;
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			arr[r][c] = new shark(s,d,z);
		}
		
		for(int i=1; i<=C; i++) {
			eatshark(i);
			moveshark();
		}
		
		System.out.println(sharkSum);
	}
	
	private static void moveshark() { 
	// 포문을 돌면서 널값이 아니면 해당 방향과 속력에맞게 이동한다. 그자리에 상어가 있다면 큰상어가 작은상어를 먹는다
		// *****상어는 모두 동시에 이동한다!!!*******
		shark copy[][]= new shark[R+1][C+1]; // 하나하나 이동한 상어를 다른배열에 넣어주고 마지막에 본배열에 복사시켜준다.
		
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(arr[i][j]==null) continue; // 아무것도 없으면 날리고
				shark s = arr[i][j];

				int ny = i;
				int nx = j;
				
				for(int ii=0; ii<s.s; ii++) { // 속력만큼
					ny = ny + dy[s.d]; // 그방향으로 가준다
					nx = nx + dx[s.d];
					
					if(ny <1 || nx <1 || ny >R || nx >C) { 
						// 범위를 벗어나면 방향을 바꿔주고  1 <-> 2  3 <-> 4
						if(s.d==1 || s.d ==3) s.d++;	
						else s.d--;
						// 그만큼 가준다
						ny = ny + dy[s.d]+dy[s.d];
						nx = nx + dx[s.d]+dx[s.d];
					}
				}
				// 속력만큼 다 가고 나서 상어를 만나면 큰상어가 살고 작은상어는 없어진다
				if(copy[ny][nx]!=null) {
					if(s.z < copy[ny][nx].z) s = copy[ny][nx];
				}
				
				//원래있던자리 상어없애주고 새로운자리에 상어 넣어준다
				arr[i][j] = null;
				copy[ny][nx] = s;
			}
		}
		
		arr = copy;
	}

	private static void eatshark(int i) {
		for(int t=1; t<=R; t++) {
			if(arr[t][i]!=null) { // i 열에 땅으로부터 가장 가까운 상으를 먹고 그 자리를 널값으로 바꾼다
				sharkSum += arr[t][i].z;
				arr[t][i] =null;
				break;
			}
		}
	}

	static class shark{
		int s,d,z ; // 속력 방향 크기 (크기가 같은 상어는 없다)

		public shark( int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		@Override
		public String toString() {
			return " "+z;
		}
	}
	
	static void print() {
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
					System.out.print(arr[i][j]+" ");	
			}
			System.out.println();
		}
		System.out.println();
	}
}
