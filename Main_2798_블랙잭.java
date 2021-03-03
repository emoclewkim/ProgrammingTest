import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2798_블랙잭 {

	static int arr[];
	static int m,n;
	static int selected[]= new int[3];
	static int v=0; // 3장의카드의 합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; //= new StringTokenizer(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());// n개의 카드중에서 3개를뽑아
		m = Integer.parseInt(st.nextToken()); // m에 최대한 가깝게 만들어라(같거나 작게)
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		combi(0,0,m);
		System.out.println(v);

	}
	
	static void combi(int cnt, int start,int m) {
		if(cnt == 3) {
			int sum=0;
			sum = selected[0]+selected[1]+selected[2];
			if(sum<=m && v<sum) v = sum;
			return;
		}
		
		for(int i=start; i<n; i++) {
			selected[cnt] = arr[i];
			combi(cnt+1, i+1,m);
		}
		
	}

}
