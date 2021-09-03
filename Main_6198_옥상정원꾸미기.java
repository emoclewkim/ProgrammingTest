import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6198_옥상정원꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;//= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		long cnt=0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i] > arr[j]){
					cnt++;
					//System.out.println(arr[i]+" "+arr[j]+" "+cnt);
				}else {
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
