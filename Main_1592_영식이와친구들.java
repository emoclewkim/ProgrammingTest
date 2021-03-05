import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // N명
		int M = Integer.parseInt(st.nextToken()); // M번받으면 종료
		int L = Integer.parseInt(st.nextToken()); // L반쩨
		int cnt=0;
		
		int arr[] = new int[N]; //1~N
		int i=0;
		while(true) {
			arr[i]++;
			if(arr[i]==M) break;
			cnt++;
			
			if(arr[i]%2!=0) { //받은횟수가 홀수일때 시계로
				i = (i+L)% N;	
			}else {//짝수일때 반시계로
 				i = (i+(N-L))% N;
			}
			
			for(int j=0; j<N; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			System.out.println(cnt);
		}
		
		System.out.println(cnt);
	}
}
