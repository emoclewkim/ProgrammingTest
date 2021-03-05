import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine()); // 케이크의 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int cake[] = new int[L+1]; //1~10까지의 케이크 길이 (상태가 1이면 가져간거 0이면 남아있음)
		
		int expectP =0; //가장 많이받을거라고 기대하는 방청객번호
		int expectSum=0; // 방청객이 원하는 케이크수 중 가장 큰값
		int realP =0; // 실제로 많이 받은 방청객 번호
		int realSum=0; // 실제로 방청객이 받은 케이크 수
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int p= Integer.parseInt(st.nextToken()); // p번째부터
			int k= Integer.parseInt(st.nextToken()); // k번째 케이크까지
			
			if(k-p > expectSum) {  
				expectSum = k-p;
				expectP = i;
			}

			int temp=0;
			for(int j=p; j<=k; j++) { // 가져갈 수 있는 케이크 가져가기
				if(cake[j]==0) {
					cake[j]=1;
					temp++;
				}
			}
			
			if(temp > realSum) {
				realSum =temp;
				realP =i;
			}

		}
		
		System.out.println(expectP);
		System.out.println(realP);
		

	}

}
