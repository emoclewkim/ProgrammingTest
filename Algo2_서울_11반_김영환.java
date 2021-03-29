import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_서울_11반_김영환 { //백준 2629 양팔저울 아래처럼 부분집합 2번쓰면 시간초과가난다 dp로 풀어야함 
	static int n, arr[];
	static boolean visit[];
	static boolean visit2[];
	static boolean isPossible; //무게가 비교가능한지 안가능한지 체크하는부분
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine()); // 추의 개수
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());//구슬의 개수
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<m; i++) { // 각각의 입력을 받으면서 구슬의무게가 체크가능한지 출력
			visit = new boolean[n];
			int a = Integer.parseInt(st.nextToken()); //각각의 구슬의 무게를 입력받아서
			isPossible =false;
			subset(0,a); // 부분집합으로 일일이 구해본다
			
			if(isPossible) {
				System.out.print("Y ");
			}else {
				System.out.print("N ");
			}
		}
	}
	private static void subset(int r,int a) {
		if(r == n) {
			int sum=a;
			for(int i=0; i<n; i++) {
				if(visit[i]) {
					sum = sum + arr[i]; // 구슬의 무게와 가지고있는 추의 무게의 부분집합의 합을 
				}
			}
			visit2 = new boolean[n];
			subset2(0,sum); //추의 부분집합들과 비교해서 같으면 비교가 가능하고 다르면 비교가 불가능하ㅏ다
			return;
		}
		
		visit[r] =true;
		subset(r+1,a);
		
		visit[r] =false;
		subset(r+1,a);
		
	}
	
	private static void subset2(int r, int sum) {
		if(r == n) {
			int sum2 =0;
			for(int i=0; i<n; i++) {
				if(visit2[i]) {
					sum2 = sum2 + arr[i]; 
				}
			}
			if(sum == sum2) {
				isPossible =true; // 같으면 비교가 가능한것
			}
			return;
		}
		
		visit2[r] =true;
		subset2(r+1,sum);

		visit2[r] =false;
		subset2(r+1,sum);

	}
}
