import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_5567_결혼식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		

		int n = Integer.parseInt(br.readLine()); // 동기의 수
		int cnt = Integer.parseInt(br.readLine()); // 리스트의 길이
		int ans =0; // 결혼식에 오는 동기 수
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		ArrayList<Integer> friends = new ArrayList<Integer>(); //상근이 친구들 리스트
		boolean[] invite = new boolean[n+1]; // 결혼식에 오는 친구들 ,0번은 없고 1번은 상근이
		
		
		for(int i =0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==1) {
				friends.add(b);
				invite[b]=true;
			}else {
				input.add(a);
				input.add(b);
			}
		}	

		
		for(int i=0; i<input.size(); i+=2) {
			for(int j=0; j<friends.size(); j++) {
				int a = input.get(i);
				int b = input.get(i+1);
				
				if(friends.get(j)==a) {
					invite[b]=true;
					break;
				}else if(friends.get(j)==b) {
					invite[a]=true;
					break;
				}
			}
		}
			
		
		for(int i=2; i<n+1; i++) {
			if(invite[i]) ans++;
		}
		
		System.out.println(ans);

	}

}
