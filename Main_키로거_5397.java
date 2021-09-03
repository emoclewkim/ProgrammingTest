import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_키로거_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;//= new StringTokenizer(br.readLine());
		StringBuilder sb;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			ArrayList<Character> keys = new ArrayList<>(); // 커서 저장소
			int p=0;// 커서 위치
				
			String logs = br.readLine();
			
			for(int i=0; i<logs.length(); i++) {
				if(logs.charAt(i)=='<') {
					if(p>0 && p< keys.size()) {
						p--; // 커서 앞으로 하나이동
					}
				}else if(logs.charAt(i)=='>'){
					if(p>0 && p< keys.size()) {
						p++; // 커서뒤로 하나 이동
					}
				}else if(logs.charAt(i)=='-') {
					if(keys.size()!=0) { // 입력받은 키로거가 하나라도 있으면
						keys.remove(p-1); // 커서 앞에있는 수 삭제
					}
				}else {
					keys.add(p, logs.charAt(i)); // 입력넣고
					p++; // 커서 오른쪽한칸이동
				}
			}
			
			sb = new StringBuilder();
			for (Character c : keys) {
				sb.append(c);
			}
			System.out.println(sb);
		}
		
		
		
		
		
	}

}
