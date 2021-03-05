import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2810_컵홀더 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum=0; //컵홀더의 수
		int n = Integer.parseInt(br.readLine());//좌석수(사람수)
		String s = br.readLine(); // 좌석나열
		
		sum++; // 맨처음 컵홀더
		boolean lastL = false;
		for(int i=0; i<n; i++){
			
		 	if(s.charAt(i)=='L' && lastL ==false) { // 첫번째 L이면 continue;
		 		lastL= true;
		 		continue;
		 	}else if(s.charAt(i)=='L' && lastL ==true) { //두번째 L이면 그냥 ㄱ
		 		lastL = false;
		 	}
		 	
		 	sum++; // S 이거나 두번째 L이면 컵홀더 하나추가
		}
		
		if(n <sum) sum=n; // 사람수가 컵홀더수보다 적으면 사람수를 출력 
		// *주의* 컵홀더의 개수가아니라 사람이 컴홀더의 꽂을 수있는 최대컵의 개수
		System.out.println(sum);
	}

}
