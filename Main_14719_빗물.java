import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H= Integer.parseInt(st.nextToken()); // 4
		int W= Integer.parseInt(st.nextToken()); // 8
		
		int arr[][] = new int[W][H]; // 2차원세계
		int ans=0; // 고이는 빗물의 총량
		
		// 벽 입력받는 부분
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0; j<temp; j++) {
				arr[i][j] = 1;
			}
		}
		
		//빗물이 담기지않을 부분을 체크 
		for(int j=0; j<H; j++) {
			
			for(int i=0; i<W; i++) {
				if(arr[i][j]==1) break;
				arr[i][j] =1;
			}
			
			for(int i=W-1; i>=0; i--) {
				if(arr[i][j]==1) break;
				arr[i][j] =1;
			}	
			
		}

//		배열 찍어보는 부분
//		for(int i=0; i<W; i++) {
//			for(int j=0; j<H; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int i=0; i<W; i++) {
			for(int j=0; j<H; j++) {
				if(arr[i][j]==0) ans++;
			}
		}
		System.out.println(ans);
		
		
	}

}
