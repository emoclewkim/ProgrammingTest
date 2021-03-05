import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3052_나머지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>(); // 서로다른 나머지를 담을 리스트
		
		int a = Integer.parseInt(br.readLine())%42;
		list.add(a); //처음에  나머지를 리스트에 넣어준다 
		
		for(int i=1; i<10; i++) {
			int n = Integer.parseInt(br.readLine())%42;
			
			boolean isExist = false;
			
			for(int j=0; j<list.size(); j++) { //이후 나머지들부터 리스트에 존재하는지 안하는지 비교후,
				if(list.get(j)==n) {
					isExist =true;
					break;
				}
			}
			
			if(isExist == false) list.add(n); // 존재하지않는다면 리스트에 추가
		}
		System.out.println(list.size());// 서로다른 나머지개수 출력
		
		//중복저장 안되는 set 사용하면 더좋다!!! set 한번도 써본적없어! ~~~ 좋은꿀팁 감사용~
		//set을 써보자!!!!!!!!!
	}

}
