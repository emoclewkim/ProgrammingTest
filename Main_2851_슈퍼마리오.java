import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2851_슈퍼마리오 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		int arr[]= new int[10];
		
		for(int i=0; i<10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<10; i++) {
			sum += arr[i]; // 버섯을 하나씩 더한다
			
			if(sum==100) { //버섯합이 100이면 끗
				break;
			}
			if(sum>100) { // 100보다 커질경우
				int temp1 = 100 - (sum - arr[i]); // 바로직전까지의 버섯합 과
				int temp2 = sum - 100; //현재 까지의 버섯합 을 비교
				
				if(temp1 < temp2) sum = sum-arr[i]; //직전까지의 버섯합이 작다면 이전꺼 선택
				break;
			}
		}
		System.out.println(sum);
	}
}
