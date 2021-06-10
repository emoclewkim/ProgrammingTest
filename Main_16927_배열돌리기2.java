import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
			int rotateCnt = Math.min(N, M)/2;
			
			for(int t=0; t<rotateCnt; t++) {
				
				for(int z=0; z<R % ((2*N+2*M-4)-(t*8)); z++) {				
				
					int temp = arr[t][t]; //맨처음값 빼놓
					
					// (t,t) 부터  < 방향으로 땡기기
					for(int i=t; i<(M-1)-t; i++) {
						arr[t][i] = arr[t][i+1];
					}
					
					// ^
					for(int i=t; i<(N-1)-t; i++) {
						arr[i][(M-1)-t] = arr[i+1][(M-1)-t]; 
					}
					
					// >
					for(int i=(M-1)-t; i>t; i--) {
						arr[(N-1)-t][i] = arr[(N-1)-t][i-1]; 
					}
					
					//v
					for(int i=(N-1)-t; i>t; i--) {
						arr[i][t] = arr[i-1][t];
					}
					
					arr[t+1][t] = temp;
				}
			}		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}