import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			String str = br.readLine();
			int sum=0; // 점수합
			int cnt=0; // 연속된 O의개수
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)=='O') {
					cnt++;
					sum += cnt;
				}else {
					cnt=0;
				}
			}
			System.out.println(sum);
		}
	}

}
