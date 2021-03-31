import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int arr[] = new int[t];
		int d[] = new int[t];
		int sum;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<t; i++) {  
			d[i] = arr[i];
			if(i==0) continue;
			if(d[i] < d[i-1]+ arr[i]) {
				d[i] = d[i-1]+ arr[i];
			}
		}
		
		sum =d[0];
		for(int i=1; i<t; i++) {
			if(sum < d[i]) sum = d[i];
		}
		System.out.println(sum);

	}

}



