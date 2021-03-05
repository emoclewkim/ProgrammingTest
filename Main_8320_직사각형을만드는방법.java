import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //정사각형 n개
		int sum=0; //만들수있는 개수
		
		for(int i=1; i<=10000; i++) { // 1~10000까지
			for(int j=i; j<=n; j++) { // 1*1, 1*2, 1*3 ... 2*2,2*3... 3*3, 3*4 ...
				if(i*j<=n) sum++;
			}
		}
		System.out.println(sum);
	}

}
